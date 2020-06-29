package com.tiandihui.cmd.component;

import com.tiandihui.cmd.common.javashell.ExecuteResult;
import com.tiandihui.cmd.common.javashell.LocalCommandExecutor;
import com.tiandihui.cmd.common.utils.StringUtils;
import com.tiandihui.cmd.service.VpnConnectStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;


@Component
public class VpnConnectStatusTimeTask {


    private Process process;
    private BufferedReader stderr;
    private OutputStreamWriter stdin;
    private BufferedReader stdout;

    private Logger LOGGER = LoggerFactory.getLogger(VpnConnectStatusTimeTask.class);
  /*  @Autowired
    private VpnConnectStatusService vpnConnectStatusService;

    @Autowired
    private LocalCommandExecutor localCommandExecutor; */


    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
    // @Scheduled(cron = "0 0/1 * ? * ?")
    @Scheduled(cron = "0/15 * *  * * ? ")   //每5秒执行一次
    private void updateVpnConnectStatus() {

        System.out.println("updateVpnConnectStatus");

        // vpnConnectStatusService.updateVpnConnectStatus();


      //  LOGGER.info("content：\n" + executeResult.getExecuteOut());
        //  LOGGER.info( "java -version：\n" + javaVerCmdResult.getExecuteOut());
     /*   Runtime runtime = Runtime.getRuntime();
        try {
            //   Process process = runtime.exec("java -version");
            //  BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String filePath = getClass().getResource("/").getPath() + "test.sh";
            Process process = Runtime.getRuntime().exec(filePath);
            process.waitFor();

            //  Process process = Runtime.getRuntime().exec(cmdStr);
            BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            int index = -1;

            String line;
            System.out.println("OUTPUT");
            while ((line = stdoutReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("ERROR");
            while ((line = stderrReader.readLine()) != null) {
                System.out.println(line);
            }
            int exitVal = process.waitFor();
            System.out.println("process exit value is " + exitVal);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        vpnConnectStatusService.updateVpnConnectStatus();
        LOGGER.info("查询命令，{}", 1); */
    }


}

