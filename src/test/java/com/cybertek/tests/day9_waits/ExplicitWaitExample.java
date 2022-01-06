package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //   Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();

        WebElement userNameInput = driver.findElement(By.id("username"));

        //HOW TO WAIT EXPLICITLY'?
        //1. create Explicit 'wait' object with 2 parameters:
        // (1st:my browser object(driver) and  2nd:(upto) how many seconds want to wait.)
        WebDriverWait wait = new WebDriverWait(driver, 100);
        //2. objectName and (.) methods:->until (kind of Provided if statement.visibilityOf(element))
        wait.until(ExpectedConditions.visibilityOf(userNameInput));

        userNameInput.sendKeys("MikeSmith");
    }
    @Test
    public void test2(){
      driver.get("http://practice.cybertekschool.com/dynamic_controls");
      //click enable
      driver.findElement(By.xpath("//*[.='Enable']")).click();
      //finding inputbox
      WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.elementToBeClickable(inputBox));
      inputBox.sendKeys("MikeSmith");

    }
}