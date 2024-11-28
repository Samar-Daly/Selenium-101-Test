package com.selenium.LambdaTestProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScenarios {
    
   // Wait for element visibility
   public static WebElement waitForElement(WebDriver driver, By locator, int timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

// Test Scenario 1: Simple Form Demo
public static void simpleFormDemo(WebDriver driver) {
    driver.get("https://www.lambdatest.com/selenium-playground");
    driver.findElement(By.linkText("Simple Form Demo")).click();
    assert driver.getCurrentUrl().contains("simple-form-demo");

    String message = "Welcome to LambdaTest";
    try {
        WebElement messageBox = waitForElement(driver, By.id("user-message"), 10);
        messageBox.sendKeys(message);
        driver.findElement(By.id("showInput")).click();
        WebElement displayMessage = waitForElement(driver, By.id("message"), 10);
        assert displayMessage.getText().equals(message);
    } catch (NoSuchElementException | TimeoutException e) {
        System.out.println("Element not found or timed out: " + e.getMessage());
    }
}

// Test Scenario 2: Drag & Drop Sliders
public static void dragAndDropSliders(WebDriver driver) {
    driver.get("https://www.lambdatest.com/selenium-playground");
    driver.findElement(By.linkText("Drag & Drop Sliders")).click();

    try {
        // Wait for the slider element to be present
        WebElement slider = waitForElement(driver, By.cssSelector(".sp__range"), 10);

        // Using Actions to drag the slider to a specific value
        Actions actions = new Actions(driver);

        // Move the slider (this value might need to be adjusted based on the actual slider's range)
        actions.dragAndDropBy(slider, 80, 0).perform();  // Move slider to value 95 (adjust based on screen resolution)

        // Get the output element where the slider value is displayed
        WebElement sliderValue = driver.findElement(By.id("rangeSuccess"));

        // Verify the value is 95 (you can also print to debug)
        assert sliderValue.getText().equals("95");

    } catch (NoSuchElementException | TimeoutException e) {
        System.out.println("Element not found or timed out: " + e.getMessage());
    }
}

// Test Scenario 3: Input Form Submit
public static void inputFormSubmit(WebDriver driver) {
    driver.get("https://www.lambdatest.com/selenium-playground");
    driver.findElement(By.linkText("Input Form Submit")).click();

    try {
         // Click submit without filling out form
        driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[6]/button")).click();
        WebElement errorMessage = waitForElement(driver, By.xpath("//input[@required]"), 10);
        assert errorMessage.getAttribute("validationMessage").equals("Please fill out this field.");

        // Fill out the form
        driver.findElement(By.id("name")).sendKeys("Samar Daly");
        driver.findElement(By.id("inputEmail4")).sendKeys("samardaly@gmail.com");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.id("company")).sendKeys("LambdaTest");
        driver.findElement(By.id("websitename")).sendKeys("LambdaTest.com");
        WebElement countryDropdown = waitForElement(driver, By.id("country"), 10);
        countryDropdown.sendKeys("United States");
        driver.findElement(By.name("city")).sendKeys("NewYork");
        driver.findElement(By.id("inputAddress1")).sendKeys("Street1");
        driver.findElement(By.id("inputAddress2")).sendKeys("Street2");
        driver.findElement(By.id("inputState")).sendKeys("NewYrokCity");
        driver.findElement(By.id("inputZip")).sendKeys("073");
        driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[6]/button")).click();

        // Validate success message
        WebElement successMessage = waitForElement(driver, By.xpath("//h1[contains(text(), 'Thanks for contacting us')]"), 10);
        assert successMessage.getText().contains("Thanks for contacting us");
    } catch (NoSuchElementException | TimeoutException e) {
        System.out.println("Element not found or timed out: " + e.getMessage());
    }
}

}
