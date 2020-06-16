package com.tiandihui.cmd.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiandihui.cmd.common.utils.RootShell.RootShellException.Reason;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.UUID;


public class RootShellCmd {
    private static final String SU = "su";
    private static final String TAG = "WireGuard/RootShell";

    private  File localBinaryDir;
    private  File localTemporaryDir;
    private final Object lock = new Object();
    private  String preamble;
    private Process process;
    private BufferedReader stderr;
    private OutputStreamWriter stdin;
    private BufferedReader stdout;

    @Autowired
    private Logger logger = LoggerFactory.getLogger(getClass());//提供日志类


    public RootShellCmd() {
        localBinaryDir = new File("/Users/tiandihui", "bin");
        localTemporaryDir = new File("/Users/tiandihui", "tmp");
        preamble = String.format("export CALLING_PACKAGE=%s PATH=\"%s:$PATH\" TMPDIR='%s'; id -u\n",
                "tiandihuicmd", localBinaryDir, localTemporaryDir);
    }

    private static boolean isExecutableInPath(final String name) {
        final String path = System.getenv("PATH");
        if (path == null)
            return false;
        for (final String dir : path.split(":"))
            if (new File(dir, name).canExecute())
                return true;
        return false;
    }

    private boolean isRunning() {
        synchronized (lock) {
            try {
                // Throws an exception if the process hasn't finished yet.
                if (process != null)
                    process.exitValue();
                return false;
            } catch (final IllegalThreadStateException ignored) {
                // The existing process is still running.
                return true;
            }
        }
    }

    /**
     * Run a command in a root shell.
     *
     * @param output  Lines read from stdout are appended to this list. Pass null if the
     *                output from the shell is not important.
     * @param command Command to run as root.
     * @return The exit value of the command.
     */
    public int run(final Collection<String> output, final String command)
            throws IOException, RootShell.RootShellException {
        synchronized (lock) {
            /* Start inside synchronized block to prevent a concurrent call to stop(). */
            start();
            final String marker = UUID.randomUUID().toString();
            final String script = "echo " + marker + "; echo " + marker + " >&2; (" + command +
                    "); ret=$?; echo " + marker + " $ret; echo " + marker + " $ret >&2\n";
            logger.info(TAG, "executing: " + command);
            stdin.write(script);
            stdin.flush();
            String line;
            int errnoStdout = Integer.MIN_VALUE;
            int errnoStderr = Integer.MAX_VALUE;
            int markersSeen = 0;
            while ((line = stdout.readLine()) != null) {
                if (line.startsWith(marker)) {
                    ++markersSeen;
                    if (line.length() > marker.length() + 1) {
                        errnoStdout = Integer.valueOf(line.substring(marker.length() + 1));
                        break;
                    }
                } else if (markersSeen > 0) {
                    if (output != null)
                        output.add(line);
                    logger.info(TAG, "stdout: " + line);
                }
            }
            while ((line = stderr.readLine()) != null) {
                if (line.startsWith(marker)) {
                    ++markersSeen;
                    if (line.length() > marker.length() + 1) {
                        errnoStderr = Integer.valueOf(line.substring(marker.length() + 1));
                        break;
                    }
                } else if (markersSeen > 2) {
                    logger.info(TAG, "stderr: " + line);
                }
            }
            if (markersSeen != 4)
                throw new RootShell.RootShellException(RootShell.RootShellException.Reason.SHELL_MARKER_COUNT_ERROR, markersSeen);
            if (errnoStdout != errnoStderr)
                throw new RootShell.RootShellException(RootShell.RootShellException.Reason.SHELL_EXIT_STATUS_READ_ERROR);
            logger.info(TAG, "exit: " + errnoStdout);
            return errnoStdout;
        }
    }

    public void start() throws IOException, RootShell.RootShellException {
        if (!isExecutableInPath(SU))
            throw new RootShell.RootShellException(RootShell.RootShellException.Reason.NO_ROOT_ACCESS);
        synchronized (lock) {
            if (isRunning())
                return;
            if (!localBinaryDir.isDirectory() && !localBinaryDir.mkdirs())
                throw new RootShell.RootShellException(RootShell.RootShellException.Reason.CREATE_BIN_DIR_ERROR);
            if (!localTemporaryDir.isDirectory() && !localTemporaryDir.mkdirs())
                throw new RootShell.RootShellException(RootShell.RootShellException.Reason.CREATE_TEMP_DIR_ERROR);
            try {
                final ProcessBuilder builder = new ProcessBuilder().command("ls");
                //  builder.environment().put("LC_ALL", "C");
                try {
                    process = builder.start();
                } catch (final IOException e) {
                    // A failure at this stage means the device isn't rooted.
                    final RootShell.RootShellException rse = new RootShell.RootShellException(RootShell.RootShellException.Reason.NO_ROOT_ACCESS);
                    rse.initCause(e);
                    throw rse;
                }
                stdin = new OutputStreamWriter(process.getOutputStream(), StandardCharsets.UTF_8);
                stdout = new BufferedReader(new InputStreamReader(process.getInputStream(),
                        StandardCharsets.UTF_8));
                stderr = new BufferedReader(new InputStreamReader(process.getErrorStream(),
                        StandardCharsets.UTF_8));

                if (stdin != null) {
                    return;
                }
              //  stdin.write(preamble);
             //   stdin.flush();
                // Check that the shell started successfully.
                final String uid = stdout.readLine();
                if (!"0".equals(uid)) {
                    logger.warn(TAG, "Root check did not return correct UID: " + uid);
                    throw new RootShell.RootShellException(RootShell.RootShellException.Reason.NO_ROOT_ACCESS);
                }
                if (!isRunning()) {
                    String line;
                    while ((line = stderr.readLine()) != null) {
                        logger.warn(TAG, "Root check returned an error: " + line);
                        if (line.contains("Permission denied"))
                            throw new RootShell.RootShellException(RootShell.RootShellException.Reason.NO_ROOT_ACCESS);
                    }
                    throw new RootShell.RootShellException(RootShell.RootShellException.Reason.SHELL_START_ERROR, process.exitValue());
                }
            } catch (final IOException | RootShell.RootShellException e) {
                stop();
                throw e;
            }
        }
    }

    public void stop() {
        synchronized (lock) {
            if (process != null) {
                process.destroy();
                process = null;
            }
        }
    }

    public static class RootShellException extends Exception {
        private final Object[] format;
        private final RootShell.RootShellException.Reason reason;

        public RootShellException(final RootShell.RootShellException.Reason reason, final Object... format) {
            this.reason = reason;
            this.format = format;
        }

        public Object[] getFormat() {
            return format;
        }

        public RootShell.RootShellException.Reason getReason() {
            return reason;
        }

        public boolean isIORelated() {
            return reason != RootShell.RootShellException.Reason.NO_ROOT_ACCESS;
        }

        public enum Reason {
            NO_ROOT_ACCESS,
            SHELL_MARKER_COUNT_ERROR,
            SHELL_EXIT_STATUS_READ_ERROR,
            SHELL_START_ERROR,
            CREATE_BIN_DIR_ERROR,
            CREATE_TEMP_DIR_ERROR
        }
    }
}
