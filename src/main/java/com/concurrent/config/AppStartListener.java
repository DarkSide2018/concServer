package com.concurrent.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AppStartListener implements ApplicationListener<ApplicationStartedEvent>{
    @Value("${mongopath}")
    private String mongoPath;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
         try {
             // need start before run spring application
            Process exec = Runtime.getRuntime().exec("cmd /c start cmd.exe /C\"" + mongoPath + "\"");
            int processComplete = exec.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
