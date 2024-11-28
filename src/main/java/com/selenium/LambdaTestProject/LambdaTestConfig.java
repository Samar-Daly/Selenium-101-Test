package com.selenium.LambdaTestProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

public class LambdaTestConfig {

    // Method to get capabilities for multiple browser/OS combinations
    public static List<DesiredCapabilities> getParallelCapabilities() {

        List<DesiredCapabilities> capabilitiesList = new ArrayList<>();

        // Chrome on Windows 10
        DesiredCapabilities chromeCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPlatformName("Windows 10");
        chromeOptions.setBrowserVersion("130");

        HashMap<String, Object> chromeOptionsMap = new HashMap<>();
        chromeOptionsMap.put("username", "samardaly77");
        chromeOptionsMap.put("accessKey", "S78mLEJcUDFWfmCNumt13hApAwFXe9EhiJTpuwCfnTPrSWVujU");
        chromeOptionsMap.put("visual", true);
        chromeOptionsMap.put("video", true);
        chromeOptionsMap.put("network", true);
        chromeOptionsMap.put("name", "SeleniumAssignmentBuild");
        chromeOptionsMap.put("project", "SeleniumAssignment");
        chromeOptionsMap.put("name", "SeleniumTestChrome");
        chromeOptionsMap.put("console", "true");
        chromeOptionsMap.put("selenium_version", "4.0.0");
        chromeOptionsMap.put("w3c", true);

        chromeOptions.setCapability("LT:Options", chromeOptionsMap);
        chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilitiesList.add(chromeCapabilities);

        // Safari on macOS
        DesiredCapabilities safariCapabilities = new DesiredCapabilities();
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setPlatformName("macOS Monterey");
        safariOptions.setBrowserVersion("130");

        HashMap<String, Object> safariOptionsMap = new HashMap<>();
        safariOptionsMap.put("username", "samardaly77");
        safariOptionsMap.put("accessKey", "S78mLEJcUDFWfmCNumt13hApAwFXe9EhiJTpuwCfnTPrSWVujU");
        safariOptionsMap.put("visual", true);
        safariOptionsMap.put("video", true);
        safariOptionsMap.put("network", true);
        safariOptionsMap.put("name", "SeleniumAssignmentBuild");
        safariOptionsMap.put("project", "SeleniumAssignment");
        safariOptionsMap.put("name", "SeleniumTestSafari");  // Test name for Safari
        safariOptionsMap.put("console", "true");
        safariOptionsMap.put("selenium_version", "4.0.0");
        safariOptionsMap.put("w3c", true);

        safariOptions.setCapability("LT:Options", safariOptionsMap);
        safariCapabilities.setCapability("browserName", "Safari");  // Setting Safari browser capability
        safariCapabilities.setCapability("platformName", "macOS Monterey");  // macOS capability
        capabilitiesList.add(safariCapabilities);

        return capabilitiesList;
    }
}
