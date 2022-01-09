package com.cybertek.tests.day10_Actions_JS;

import com.cybertek.utilities.WebDriverFactory;
import javafx.scene.effect.BloomBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
    WebDriver driver;
    @BeforeMethod
    public void setUp() { driver = WebDriverFactory.getDriver("chrome"); }
    @AfterMethod
    public void tearDown() throws InterruptedException { Thread.sleep(2000);  driver.quit(); }


    //We can use javascript if other options does not work like clicking, sendkeys, also scroll up and down..
    @Test
    public void clickWithJS(){
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        // casting from Jse, so we can use methods from it:
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // How to click an element in Selenium WebDriver using JavaScript? google it -> stackoverflow:
        jse.executeScript("arguments[0].click();", dropdownLink);
    }
    @Test
    public void typeWithJS(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Set value of input instead of sendKeys() - Selenium WebDriver? google it -> stackoverflow:
        String text = "Hello Disabled Input";
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);

      // ("arguments[0].setAttribute('value', '" + text +"') -> this is the JS code part.
        // We are manipulating only the value part->(+ text +)
    }
    @Test
    public void ScrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        //to be able to scroll up and down we need to enlarge the display first!!
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // We want to scroll 10 times: for iterator loop (shortcut: itar+enter)
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            // how to scroll down in javascript selenium? code from google->stackoverflow:
            jse.executeScript("window.scrollBy(0,250)");
            }
        // how to scroll down in javascript selenium? code from google->stackoverflow:
        for (int j = 0; j < 10; j++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");
        }
    }
    @Test
    public void   scrollToElement() throws InterruptedException {
        // just to go to element directly without scrolling up and down:
        driver.get("https://www.amazon.com/");
        WebElement eng = driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // google -> stackoverflow:
        jse.executeScript("arguments[0].scrollIntoView(true);",eng );

    }
}
