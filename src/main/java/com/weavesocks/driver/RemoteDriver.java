package com.weavesocks.driver;

import com.weavesocks.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class RemoteDriver  {

    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);
    private static final String SELENOID_HUB_URL = "http://localhost:4444/wd/hub";

    public WebDriver createDriver(String browserName, String version) {
        WebDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
        capabilities.setVersion(version);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        capabilities.setAcceptInsecureCerts(true);
        try {
            driver = new RemoteWebDriver(
                    URI.create(SELENOID_HUB_URL).toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            LOGGER.info(e.getMessage());
        }

        return driver;
    }
}
