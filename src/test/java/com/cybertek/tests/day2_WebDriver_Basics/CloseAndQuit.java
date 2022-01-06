package com.cybertek.tests.day2_WebDriver_Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");

        Thread.sleep(5000);// <- pause for (5000) millis  long

        // closing the current tab
       driver.close(); // <- browser will close in 2 sec. -> No need to close it by ourselves.. */

        /* giving new browser tab:
         we can not use second time the same declaration in main method)
         basically, we are opening a new session with new browser. */
        driver = new ChromeDriver(); // <- At each time, we will have an empty-new browser.

        // open a new page(tab):
        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

      // closing all tabs, it ends the session we won't get anything back..
        driver.quit();
    }
}
