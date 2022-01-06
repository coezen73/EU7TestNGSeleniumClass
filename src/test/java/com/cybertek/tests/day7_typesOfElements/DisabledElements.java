package com.cybertek.tests.day7_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioBtn = driver.findElement(By.cssSelector("#green"));

        // how to check any element is enabled or disabled (clickable? )
        System.out.println("greenRadioBtn.isEnabled() = " + greenRadioBtn.isEnabled());
        Assert.assertFalse(greenRadioBtn.isEnabled(),"Verify that green radio button is NOT enabled(disabled)");

        greenRadioBtn.click();
    }
    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_control");

        WebElement InputBox = driver.findElement(By.cssSelector("[type='text']"));
        InputBox.sendKeys("message from Cemil");
        driver.quit();
    /*
    When we try to interact with disabled elements 2 things can happen:
    1.no action will happen and code will not fail, not complain
    2.no action will happen,
    but we can get NoSuchElementException: no such element: Unable to locate element!
 */
    }
}
