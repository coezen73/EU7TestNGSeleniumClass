package com.cybertek.tests.day2_WebDriver_Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CQpractise {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.close();
        driver = new FirefoxDriver();
        driver.get("https://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        driver.quit();




    }
}
