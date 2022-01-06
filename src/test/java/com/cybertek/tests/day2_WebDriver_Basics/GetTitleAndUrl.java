package com.cybertek.tests.day2_WebDriver_Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {
       // task: open chrome and navigate to  http://practice.cybertekschool.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");

        /* WE ARE STARTING TO COLLECT THE INFORMATION FROM WEBSITE

     *  Getting the 'title' with selenium: getTitle() -> It gets us the title of the page
        -> we will use 'title' as a verification; as an assertion point(Belirli nokta) */
        // shortcut to create a variable: -> option+enter enter
      //  String title = driver.getTitle();
        String title = driver.getTitle();
        // shortcut to print the variable with the name: soutv
        System.out.println("title = " + RFC4519Style.title);
 /* Getting the 'url' with selenium:-> get the url address from the browser.
        -> after picking getCurrentUrl method, shortcut to create variable:  */
        String currentUrl = driver.getCurrentUrl();
        // shortcut to print it with name: soutv
        System.out.println("currentUrl = " + currentUrl);
 /*Getting the 'Page source code' with selenium: it will get the source code(very long one)of the webpage.
   -> getPageSource() method. it will give us the 'html version in xml file' /   We use the same shortcuts.*/
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }
}
