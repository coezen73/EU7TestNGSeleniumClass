package com.cybertek.tests.day3_WebElement_Intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/* Verify confirmation message
open Chrome browser
go to http://practice.cybertekschool.com/forgot_password Links to an external site.
enter any email
verify that email is displayed in the input box
click on Retrieve password
verify that confirmation message says 'Your e-mail's been sent!'
 */
public class VerifyConfirmationMessage {
    public static void main(String[] args) {
        // Open Chrome Browser:
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // Go to http://practice.cybertekschool.com/forgot_password :
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // Enter any email into InputBox :
        WebElement emailInputBox = driver.findElement(By.name("email"));
        // Save the expected email as a 'String data type':
        String expectedEmail = "mike@smith.com";
        //sendKeys() <-- in order to send an email to inputBox:    * * *
        emailInputBox.sendKeys(expectedEmail);

       /* Somehow, we should get text from webElement:
       Two main ways(methods) to get the txt from WebElements:      * * *
       1. getText()    <-- It will work 99% -  it will return String
       2. getAttribute("value")  <-- second way of getting txt.(Especially from input boxes!)  */
        String actualEmail = emailInputBox.getAttribute("value");
        // to see the expected and actual here:
        System.out.println("expectedEmail : " + expectedEmail);
        System.out.println("actualEmail : " + actualEmail);
        // Verify that email is displayed in the input box:
         if(expectedEmail.equals(actualEmail)){
             System.out.println("PASS");
         }else{
             System.out.println("FAIL");
         }
        // click on retrieve password:
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        // action that I need to perform: click!
        retrievePasswordButton.click();

        // verify that confirmation message says 'Your e-mail's been sent' :
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        // actualConfirmationMessage is a WebElement, we can't print as a String: we need to use 'getText()'
        System.out.println(actualConfirmationMessage.getText());
        // Save expectedMessage to variable:
        String expectedMessage = "Your e-mail's been sent!";
        // Save actualMessage to variable:
        String actualMessage = actualConfirmationMessage.getText();
        // Verify:
         if(expectedMessage.equals(actualMessage)){
        System.out.println("PASS");
        }else {
             System.out.println("FAIL");
             System.out.println("Expected Message: " + expectedMessage);
             System.out.println("Actual message: " + actualMessage);
         }
         driver.quit();
    }

}
