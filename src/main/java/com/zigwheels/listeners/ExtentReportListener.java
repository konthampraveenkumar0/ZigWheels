package com.zigwheels.listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.zigwheels.utilities.ScreenshotCapture;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        new File("screenshots").mkdirs();

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String reportPath = "test-output/Report_History/ExtentReport_" + timestamp + ".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Zig Wheels Automation Report");
        sparkReporter.config().setReportName("Zig Wheels Test Results");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Application", "Zig Wheels");
        extentReports.setSystemInfo("Environment", "Test");
        extentReports.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("User", System.getProperty("user.name"));
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String testDescription = result.getMethod().getDescription();
        extentTest = extentReports.createTest(testName, testDescription);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test passed successfully");
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test failed");
        Throwable throwable = result.getThrowable();
        if (throwable != null) {
            extentTest.log(Status.FAIL, throwable.getMessage());
        }

        try {
            Object testInstance = result.getInstance();
            Field driverField = testInstance.getClass().getDeclaredField("driver");
            driverField.setAccessible(true);
            WebDriver driver = (WebDriver) driverField.get(testInstance);
          
            
            String screenshotPath = ScreenshotCapture.captureScreenshot(driver, result.getMethod().getMethodName());
            extentTest.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            extentTest.log(Status.WARNING, "Could not capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test was skipped");
        if (result.getThrowable() != null) {
            extentTest.log(Status.SKIP, result.getThrowable().getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    public static ExtentTest getExtentTest() {
        return extentTest;
    }
}
