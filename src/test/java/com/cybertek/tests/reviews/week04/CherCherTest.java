package com.cybertek.tests.reviews.week04;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CherCherTest {
/* Task1:
    1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    2. Click on "Click me, to Open an alert after 5 seconds"
    3. Explicitly wait until alert is present
    4. Then handle the Javascript alert */

    WebDriver driver; // declaring of our reference for the object
    WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        // Get the browser:
        driver = WebDriverFactory.getDriver("chrome"); // creating object
        // Arrange the size of the window:
        driver.manage().window().maximize();
        // Add IMPLICITLY WAIT -> This is going to be applied all the test cases from now on:
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);// for find the element
        // Go to the web address:
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
        }
        @Test
    public void alertPresentTest(){
            // Click on "Click me, to Open an alert after 5 seconds"
            WebElement initiateALert = driver.findElement(By.id("alert"));
            initiateALert.click();

            wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.alertIsPresent());
            // handle javascript alert
            // if you don't wait you will get NoAlertPresentException: no such alert
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }

    }



