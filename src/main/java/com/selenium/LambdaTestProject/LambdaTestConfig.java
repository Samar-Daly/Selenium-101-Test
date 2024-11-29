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
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPlatformName("Windows 10");
        chromeOptions.setBrowserVersion("130");

        HashMap<String, Object> chromeLtOptions = new HashMap<>();
        chromeLtOptions.put("username", "samardaly77");
        chromeLtOptions.put("accessKey", "S78mLEJcUDFWfmCNumt13hApAwFXe9EhiJTpuwCfnTPrSWVujU");
        chromeLtOptions.put("visual", true);
        chromeLtOptions.put("video", true);
        chromeLtOptions.put("network", true);
        chromeLtOptions.put("build", "SeleniumAssignmentBuild");  // Build name
        chromeLtOptions.put("project", "SeleniumAssignment");  // Project name
        chromeLtOptions.put("name", "SeleniumChromeTest");  // Test name
        chromeLtOptions.put("console", "true");
        chromeLtOptions.put("selenium_version", "4.0.0");
        chromeLtOptions.put("w3c", true);

        chromeOptions.setCapability("LT:Options", chromeLtOptions);
        capabilitiesList.add(new DesiredCapabilities(chromeOptions));

        // Safari on macOS
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setPlatformName("macOS Monterey");
        safariOptions.setBrowserVersion("15");

        HashMap<String, Object> safariLtOptions = new HashMap<>();
        safariLtOptions.put("username", "samardaly77");
        safariLtOptions.put("accessKey", "S78mLEJcUDFWfmCNumt13hApAwFXe9EhiJTpuwCfnTPrSWVujU");
        safariLtOptions.put("visual", true);
        safariLtOptions.put("video", true);
        safariLtOptions.put("network", true);
        safariLtOptions.put("build", "SeleniumAssignmentBuild");  // Build name
        safariLtOptions.put("project", "SeleniumAssignment");  // Project name
        safariLtOptions.put("name", "SeleniumSafariTest");  // Test name
        safariLtOptions.put("console", "true");
        safariLtOptions.put("selenium_version", "4.0.0");
        safariLtOptions.put("w3c", true);

        safariOptions.setCapability("LT:Options", safariLtOptions);
        capabilitiesList.add(new DesiredCapabilities(safariOptions));

        return capabilitiesList;
    }
}
