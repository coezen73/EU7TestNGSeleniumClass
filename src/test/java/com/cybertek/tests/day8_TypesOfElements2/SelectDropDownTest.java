package com.cybertek.tests.day8_TypesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

        }
    @Test

    public void test1() {

        driver.get("http://practice.cybertekschool.com/dropdown");

   // locate your dropdown just like any other webElement with unique locator:
        // we locate it by id:
        WebElement dropdownElement = driver.findElement(By.id("state"));
    // We're passing the webElement(dropdownElement) into the constructor to create a connection
    // ->   If we have 'select' Tag,  Create a Select object by passing that element as a constructor.
        // 'Select' is a class from selenium:
        Select stateDropdown = new Select(dropdownElement);

    // getOptions() -> it is returning us the list of all available webElements from dropdown
        List<WebElement> options = stateDropdown.getOptions();
    // print size of the options
        System.out.println("options.size() = " + options.size());
    // print options one by one (shortcut: iter+enter)
        for (WebElement option : options) {
            System.out.println(option.getText());

        }
    }
    @Test
    public void test2() throws InterruptedException {
        // we are going to deal with the same dropdown, so I copied first 3 lines from above:
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("state"));
        Select stateDropdown = new Select(dropdownElement);
        // verify that first selection is 'Select a state':
        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

 // HOW TO SELECT OPTIONS FROM DROPDOWN?
        // 1. Select using visible text:(What ever we see on the display..)
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");

        expectedOption = "Virginia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify this selection");

        // 2.Select using index:
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify this selection");

        // 3. Select by value:
        Thread.sleep(2000);
        stateDropdown.selectByValue("TX");

        expectedOption = "TX";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify this selection");

    }
}
