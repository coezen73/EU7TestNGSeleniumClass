package com.cybertek.tests.day4_BasicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("firefox");
        // make browser fullscreen:
        driver.manage().window().maximize();

        driver.get("https://practice.cybertekschool.com/sign_up");

        WebElement  fullNameInput = driver.findElement(By.name("full_name"));

        fullNameInput.sendKeys("Mike Smith");

       // put some  email & click signup button:

        // proper and long way:
       // WebElement emailInput = driver.findElement(By.name("email"));
       // emailInput.sendKeys("mike@smith.com");

        // lazy way: * * *
        driver.findElement(By.name("email")).sendKeys("mike@smith.com");

        Thread.sleep(2000);

        driver.findElement(By.name("wooden_spoon")).click();



    }
}
