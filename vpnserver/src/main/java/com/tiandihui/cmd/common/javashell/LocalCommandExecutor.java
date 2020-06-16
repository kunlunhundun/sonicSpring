package com.tiandihui.cmd.common.javashell;

public interface LocalCommandExecutor {
    ExecuteResult executeCommand(String command, long timeout);
}