package com.cybertek.tests.day3_WebElement_Intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /*
 Test Case : Verify URL not changed
	- Open Chrome browser
	- Go to 'http://practice.cybertekschool.com/forgot_password' Links to an
	  external site.
	- Click on 'Retrieve password'
	- VERIFY that url did not change  */

        //Open Chrome Browser:
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // Go to the Link:
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // save expected URL before clicking button to be able to verify at the end
        String expectedUrl = driver.getCurrentUrl();
        // click on Retrieve password:
        //WebElement--> Interface that represent elements on the webpage
        //findElement --> Method used to find element on a page
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        // action that I need to perform: click!
        retrievePasswordButton.click();
        // save actual Url after clicking button to verify
        String actualUrl = driver.getCurrentUrl();
        // VERIFY that url did not change
        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
    }
        // close your browser:
        driver.quit();


    }
}
