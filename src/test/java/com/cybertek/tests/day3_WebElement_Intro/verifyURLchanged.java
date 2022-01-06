package com.cybertek.tests.day3_WebElement_Intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/* Verify URL changed
- open Chrome browser
- go to http://practice.cybertekschool.com/forgot_password Links to an external site.
- enter any email
click on Retrieve password
verify that url changed to http://practice.cybertekschool.com/email_sent
 */
public class verifyURLchanged {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailInputBox = driver.findElement(By.name("email"));// <- There is no id, but name..
        // * this time sendKeys() <--  send keyboard action to the webElement:
        emailInputBox.sendKeys("mike@cybertek.com");
        // click retrieve password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        // To avoid the environmental issues (speed of internet or computer..etc):
        Thread.sleep(3000);

        // TASK
        //Verify that url changed to 'http://practice.cybertekschool.com/email_sent'

        // create an expected url:
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        // Saving actual url from browser after we enter any email and click retrieve password button
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            // If it is failed , I can compare the expected and actual results:
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("actualUrl = " + actualUrl);
        }
        driver.quit();
    }
}
