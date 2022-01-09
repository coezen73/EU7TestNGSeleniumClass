package com.cybertek.tests.day10_Actions_JS;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() { driver = WebDriverFactory.getDriver("chrome"); }
    @AfterMethod
    public void tearDown() throws InterruptedException { Thread.sleep(2000);  driver.quit(); }

    @Test
    public void hoverTest() throws InterruptedException {
    driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = driver.findElement(By.tagName("img"));

        // Actions -->  selenium class that contains all the user interactions
        // how to create an actions object --> passing driver as a constructor
        // action class suppose to work with the browser that I have opened(driver)
        // -> need to connect with each other:
        Actions actions = new Actions(driver);
        // perform() --> perform or complete the action:
        // moveToElement() --> move your mouse to webElement (hover over):
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

         WebElement viewLink = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(viewLink.isDisplayed(), "verify view link is displayed");

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        // Jamal: This should work for each case (Which it doesn't... !)
    /* List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(1000);
        if(acceptAndClose.size()>0){
            acceptAndClose.get(0).click();
        }else if(acceptCookies.size())>0){
            acceptCookies.get(0).click();
        } */

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

     // If you see accept and close message use  this:
     driver.findElement(By.xpath("//*[.='Accept and Close']")).click();
      // or sometimes it might also require this as well..
      //  driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        //dragAndDrop() method:
       // Thread.sleep(2000);
       // actions.dragAndDrop(source,target).perform();
       // step by step method:
        Thread.sleep(2000);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();


    }
}
