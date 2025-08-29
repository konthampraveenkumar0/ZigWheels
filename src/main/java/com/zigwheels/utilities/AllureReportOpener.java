package com.zigwheels.utilities;

import java.io.File;
import java.io.IOException;

public class AllureReportOpener {

    public static void cleanAllureResults() {
        File resultsDir = new File("allure-results");
        if (resultsDir.exists() && resultsDir.isDirectory()) {
            File[] files = resultsDir.listFiles();
            if (files != null) {
                for (File f : files) {
                    try {
                        f.delete();
                    } catch (Exception ignored) {}
                }
            }
        }
    }

    public static void openAllureReport() {
        try {
            // Step 1: Generate the Allure report
            ProcessBuilder generate = new ProcessBuilder(
                "cmd.exe", "/c",
                "\"C:\\Users\\2421291\\Downloads\\allure-2.34.1\\allure-2.34.1\\bin\\allure.bat\"",
                "generate", "allure-results", "-o", "allure-report", "--clean"
            );
            generate.inheritIO();
            Process gen = generate.start();
            gen.waitFor();

            // Step 2: Open Allure report in browser
            ProcessBuilder open = new ProcessBuilder(
                "cmd.exe", "/c",
                "\"C:\\Users\\2421291\\Downloads\\allure-2.34.1\\allure-2.34.1\\bin\\allure.bat\"",
                "open", "allure-report"
            );
            open.inheritIO();
            Process openProc = open.start();
            openProc.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
