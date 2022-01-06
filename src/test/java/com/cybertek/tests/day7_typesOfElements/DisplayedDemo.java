package com.cybertek.tests.day7_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.manage().window().maximize();

        WebElement usernameInput = driver.findElement(By.id("username"));
        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        //verify username inputBox that is not displayed on the screen
        //click start button
        //verify username displayed on the screen


        //verify username inputBox that is not displayed on the screen
        Assert.assertFalse(usernameInput.isDisplayed(),"verify that InputBox is NOT displayed");
        //click start button -> find startButton and click in one line:
        driver.findElement(By.cssSelector("#start>button")).click();
        //Need to wait around 5 sec to load the next page:
        Thread.sleep(6000);
        Assert.assertTrue(usernameInput.isDisplayed(),"Verify that username inputBox is displayed");

    }
}
