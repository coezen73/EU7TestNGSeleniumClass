package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class OpenBrowser {
    public static void main(String[] args) {
        // We have to enter this line every time we want to open 'chrome.'
        // It basically says: " Hey webDriveManager, can you make 'chrome' ready for me for automation?"
    //   WebDriverManager.chromedriver().setup();  // This line is responsible for downloading various browsers
        // This will allow selenium to talk and download necessary things from the Chrome browser

        // Creating an object! (left side is different from right side) This is called polymorphism.-> LATER!
        // WebDriver represents the browser
        // We are creating a 'driver' object for  Chrome browser
        // new ChromeDriver()--> this part will open an 'empty' Chrome browser
   //  WebDriver driver = new ChromeDriver();  // ChromeDriver class comes from Selenium(look import file upper side)

        // We can do whatever necessary with this empty browser, but first we need to go there by navigating:
        // First selenium method we have learned: .get(url); -> It navigates us to the page.
    //   driver.get("https://cybertekschool.com");
       // LETS DO IT FOR FIREFOX WEB BROWSER:

        WebDriverManager.firefoxdriver().setup(); // aloud selenium to automate the firefox web browser
        WebDriver driver = new FirefoxDriver();
        driver.get("https://facebook.com");


    }
}
