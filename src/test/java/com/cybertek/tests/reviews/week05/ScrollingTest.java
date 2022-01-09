package com.cybertek.tests.reviews.week05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollingTest {
/*- P.I.Q.: How many ways do you know to scroll using Selenium?
    1. action.moveToElement().perform()
    2. PageUp, PageDown keys for scrolling
        action.sendKeys(Keys.PAGE_UP, PAGE_DOWN)
    3. jse.executeScript("window.scrollBy(0,250)");
    4. jse.executeScript("arguments[0].scrollIntoView(true)",cybertekSchoolLink); */
 WebDriver driver;
 @BeforeMethod
    public void setUp(){
     driver= WebDriverFactory.getDriver("chrome");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     driver.get("http://practice.cybertekschool.com/");

 }
 @AfterMethod
    public void tearDown(){
     driver.close();
 }
 @Test
    public void moveToElementTest() throws InterruptedException { // 1 - declared the exception
     // scroll down to 'POWERED BY CYBERTEK'
     Actions actions = new Actions(driver);

     WebElement cybertekSchoolLink = driver.findElement(By.linkText("Cybertek School"));
     // scrolling to that element:
     Thread.sleep(3000);  //  1- checked exception

     actions.moveToElement(cybertekSchoolLink).perform();
     Thread.sleep(3000);

    // advanced Keyboard actions
     driver.get("http://practice.cybertekschool.com/infinite_scroll");
     actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

     Thread.sleep(1000);

 }
 @Test
    public void scrollTestWithJSE() throws InterruptedException {
     // We need to downcast our driver:
     JavascriptExecutor jse = (JavascriptExecutor) driver;
     // first way with JSE
     Thread.sleep(2000);
     jse.executeScript("window.scroll(0, document.body.scrollHeight)");
     Thread.sleep(1000);
     jse.executeScript("window.scroll(0,- document.body.scrollHeight)");
     Thread.sleep(1000);
    // Second way with JSE
     // Second way with JSE
     WebElement cybertekschoolLink = driver.findElement(By.linkText("Cybertek School"));
     jse.executeScript("arguments[0].scrollIntoView(true)",cybertekschoolLink);
     Thread.sleep(1000);
 }

    /*
    HW: This is from a real interview task:
    v.Test application www.IonicPartners.com:
vi. Test 1: Go to <Blog> page and scroll it down
vii. Test 2: Go to <About> page, scroll it down and click on Twitter icon at the bottom of the page
     */


}


