package com.cybertek.tests.day4_BasicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDLocatorTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // click 'don't click button:
        WebElement dontClickButton = driver.findElement(By.id("disappearing_button"));

        dontClickButton.click();
        // let's say; if we type wrong like instead of 'button', I type 'buttons'
        // error/ exception  <-- "No such element"

        driver.close();



    }


}
