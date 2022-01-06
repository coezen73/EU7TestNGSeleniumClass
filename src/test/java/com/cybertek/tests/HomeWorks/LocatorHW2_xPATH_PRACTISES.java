package com.cybertek.tests.HomeWorks;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*         XPATH PRACTICES
    DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
    3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        a. “Home” link
        b. “Forgot password” header
        c. “E-mail” text
        d. E-mail input box
        e. “Retrieve password” button
    4.Print text of a,b,c,e and put some email to d */

public class LocatorHW2_xPATH_PRACTISES {
    public static void main(String[] args) {
        //Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH locator only (total of 6)

        //a. “Home” link
        WebElement homeLink= driver.findElement(By.xpath("//a[.='Home']"));
        //print it
        System.out.println(homeLink.getText());


        //b. “Forgot password” header

        WebElement ForgotPasswordHeader= driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        //print it
        System.out.println(ForgotPasswordHeader.getText());


        // c. locate “E-mail” text
        WebElement EmailText= driver.findElement(By.xpath("//label[.='E-mail']"));
        //get text or print it
        System.out.println(EmailText.getText());


        // d. E-mail input box
        WebElement EmailInputBox= driver.findElement(By.xpath("//input[@name='email']"));
        // put some email to d
        EmailInputBox.sendKeys("BilginBey@SDET.com");


        // e. “Retrieve password” button
        //print it
        WebElement RetrievePasswordButton= driver.findElement(By.xpath("//button[@id='form_submit']"));
        System.out.println(RetrievePasswordButton.getText());

    }

}
