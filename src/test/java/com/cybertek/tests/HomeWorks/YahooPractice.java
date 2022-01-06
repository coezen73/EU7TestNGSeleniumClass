package com.cybertek.tests.HomeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooPractice {

    /* open page, go to yahoo, verify the title
    expect3dTitle= "Yahoo"
    actualTitle = webPage
     */
    public static void main(String[] args) {
        // set up browser type
        WebDriverManager.chromedriver().setup();
        // how can I open a new page :
        WebDriver driver = new ChromeDriver();
        // go to the page :
        driver.get("http://www.yahoo.com");
        String expectedTitle = "Yahoo";
        String actualTitle = driver.getTitle();
        System.out.println("expectedTitle= "+ expectedTitle);
        System.out.println("actualTitle = " + actualTitle);

    }
}
