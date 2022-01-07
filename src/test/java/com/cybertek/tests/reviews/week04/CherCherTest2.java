package com.cybertek.tests.reviews.week04;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CherCherTest2 {
 /*  Task3:
    1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    2. Login with username: Tester, password: test
    3. Click  Order button
    4. Verify under Product Information, selected option is “MyMoney”
    5. Then select FamilyAlbum, make quantity 2, and click Calculate,
    6. Then verify Total is equal to Quantity*PricePerUnit   */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// for find the element
 //1.Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }
    @AfterMethod
    public void tearDown(){
    //    driver.close();
    }
    @Test
    public void WebOrderTest() throws InterruptedException {
// 2.Login with username: Tester, password: test
        WebElement inputUsername = driver.findElement(By.id("ctl00_MainContent_username"));
        inputUsername.sendKeys("Tester");
        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
        inputPassword.sendKeys("test"+ Keys.ENTER); // to enter the keys

//  3. Click  Order button (Link)
        WebElement orderLink = driver.findElement(By.linkText("Order"));
        orderLink.click();
        // HOW TO DEAL WITH SELECT DROPDOWN BUTTONS:
// 4. Verify under Product Information, selected option is “MyMoney”
        // What is 'MyMoney'? -> expected condition:
        String expectedSelectedOption = "MyMoney";
        WebElement  productDropdownElement = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        // I need to use Select class methods.
        // In java, in order to use the 'instance methods' which come from a class, we have to 'create an object':
        Select productDropdown = new Select(productDropdownElement);//  -> My parameter
        String actualSelectedOption = productDropdown.getFirstSelectedOption().getText(); // <- option+enter
        // now I have 'expected' and 'actual' selected options to be able to compare:
        Assert.assertEquals(actualSelectedOption,expectedSelectedOption,"First selected option is NOT expected");


    }
}
