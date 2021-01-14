package com.weavesocks.utilities.listeners;

import com.weavesocks.driver.Browser;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(AllureListener.class);

    private static String getTestMethodName(ITestResult testResult) {
        return testResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver threadDriver = Browser.getDriverInstance().getThreadDriver();

        if (threadDriver != null) {
            LOGGER.info("Screenshot was captured for test case: {} ", getTestMethodName(result));
            saveScreenshotPNG(threadDriver);
        }
    }
}
