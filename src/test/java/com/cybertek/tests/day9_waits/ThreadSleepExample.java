package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.jvm.hotspot.runtime.Threads;

import java.util.concurrent.TimeUnit;

public class ThreadSleepExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");
       Thread.sleep(6000); // static wait, just pause. No checking any condition
        // Time consumer. This is the last solution for testers. We have 2 dynamic waits..
        driver.findElement(By.id("username")).sendKeys("MikeSmith");
    }
}
