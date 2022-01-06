package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class multipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void SwitchWindowsTest(){

        driver.get("http://practice.cybertekschool.com/windows");

        // get title
        System.out.println("Title before new window: " + driver.getTitle());
        driver.findElement(By.partialLinkText("Click Here")).click();
        System.out.println("Title after new window: " + driver.getTitle());

      //  System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        String currentWindowHandle = driver.getWindowHandle();// represents current window!
        // getWindowHandles method will get the all windows and place inside the Set
        Set<String> windowHandles = driver.getWindowHandles();// represent all open windows
// Set is a collection. Just like a list, but no duplicate values and it doesn't keep the order (no index)

        for (String handle : windowHandles) {
     if (!handle.equals(currentWindowHandle)){ // whenever it is not equal to my current window,
         driver.switchTo().window(handle); // it will switch to this one..
        }
    }
        System.out.println("Title after switch new window: " + driver.getTitle());

    }
        @Test
    public void moreThanTwoWindows(){

            driver.get("http://practice.cybertekschool.com/windows");
            driver.findElement(By.partialLinkText("Click Here")).click();

            System.out.println("Before Switch: " + driver.getTitle());

            Set<String> windowHandles = driver.getWindowHandles();
            // loop through each window:
            for (String handle : windowHandles) {
                // one by one change it, switch it
                driver.switchTo().window(handle);
            // whenever our title equals to our expected window title:
            if(driver.getTitle().equals("New Window")){
                // stop on that window!..
                break;
            }
            }
            System.out.println("After Switch: " + driver.getTitle());
        }




}
