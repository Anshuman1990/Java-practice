package com.practice.language.process;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        ProcessBuilder pb1 = new ProcessBuilder("notepad.exe");
        Process notepadProcess = pb1.start();
        ProcessHandle ph = notepadProcess.toHandle();
        ProcessHandle.Info info = ph.info();

        System.out.println("Process path : " + info.command().get());
        System.out.println("Process start time : " + info.startInstant().get());
        System.out.println("Process owner : " + info.user().get());
        System.out.println("Process CPU usage : " + info.totalCpuDuration().get());

        List<ProcessHandle> allProcess = ProcessHandle.allProcesses().collect(Collectors.toList());    // Line 1
        allProcess.forEach(processHandle -> {
            ProcessHandle.Info info1 = processHandle.info();
            System.out.println(processHandle.pid());
            System.out.println(info1.command().orElse(null));
            System.out.println(info1.startInstant().orElse(null));
            System.out.println(info1.totalCpuDuration().orElse(null));
            System.out.println("************************************************");
        });


    }
}
