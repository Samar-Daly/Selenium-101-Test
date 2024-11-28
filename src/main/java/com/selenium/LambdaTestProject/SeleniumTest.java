package com.selenium.LambdaTestProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.net.URL;
import java.util.List;

public class SeleniumTest {

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    public void runTests() throws Exception {
        List<DesiredCapabilities> capabilitiesList = LambdaTestConfig.getParallelCapabilities();

        // Loop through the capabilities list and execute tests in parallel
        for (DesiredCapabilities capabilities : capabilitiesList) {
            WebDriver driver = new RemoteWebDriver(
                    new URL("https://samardaly77:S78mLEJcUDFWfmCNumt13hApAwFXe9EhiJTpuwCfnTPrSWVujU@hub.lambdatest.com/wd/hub"),
                    capabilities);

            // Running tests for each browser/OS combination
            try {
                // Test Scenario 1 - Simple Form Demo
                TestScenarios.simpleFormDemo(driver);
                System.out.println("Starting SimpleFormDemo test...");
                // Test Scenario 2 - Drag & Drop Sliders
                TestScenarios.dragAndDropSliders(driver);

                // Test Scenario 3 - Input Form Submit
                TestScenarios.inputFormSubmit(driver);

            } finally {
                driver.quit();
            }
        }
    }
}