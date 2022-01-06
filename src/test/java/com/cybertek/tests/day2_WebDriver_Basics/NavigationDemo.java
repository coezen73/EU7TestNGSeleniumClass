package com.cybertek.tests.day2_WebDriver_Basics;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup(); //for downloading various browsers

        WebDriver driver = new FirefoxDriver();  //creating a 'driver' object from selected browser

        driver.get("https://google.com");   // 'get method' to navigate to selected website (google)


        // '.get()' is not the only method that we can navigate to browser
        // this one navigate to another website with different selenium method.
        driver.navigate().to("https://www.facebook.com");

        // we can stop (or give a break) in between the pages by using a JAVA code:
        Thread.sleep(5000); // It will wait for 5 sec on facebook page  before navigate back to google.

        // navigate back to previous page:
        driver.navigate().back();

    Thread.sleep(5000);

    // goes back to back
        driver.navigate().forward();

        Thread.sleep(5000);

        // refreshing the webpage:
        driver.navigate().refresh();
    }
}
