package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW_TestCase1_2 {
    /* Locator HW
        Test Case 1:
            Feel free to use any project for automation.
            Test case 1
            Go to Ebay
            enter search term
            click on search button
            print number of results*/

    public static void main(String[] args) {

        //open web browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //maximize it
        driver.manage().window().maximize();

        // navigate to ebay
        driver.get("https://ebay.com");

        //enter search term
        WebElement searchFor= driver.findElement(By.xpath("//input[@aria-label='Search for anything']"));
        searchFor.sendKeys("cars");

        //click search button
        WebElement clickSearchFor= driver.findElement(By.xpath("//input[@value='Search']"));
        clickSearchFor.click();
        // print number of result
        WebElement numberOfResult= driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        System.out.println(numberOfResult.getText());
      /*
    Test case 2:
        Go to Ebay
        search Selenium
        click on search button
        verify title contains Selenium
         */
        //open web browser
        WebDriver driver1 = WebDriverFactory.getDriver("chrome");

        //maximize it
        driver.manage().window().maximize();

        // navigate to ebay
        driver.get("https://ebay.com");

        //enter search term
        WebElement search= driver1.findElement(By.xpath("//input[@aria-label='Search for anything']"));
        search.sendKeys("selenium");

        //click search button
        WebElement clickSearch= driver.findElement(By.xpath("//input[@value='Search']"));
        clickSearch.click();

        // get the title
        String actualResult= driver1.getTitle();
        System.out.println(driver.getTitle());
        String expectedResult= "selenium";
        if(actualResult.contains(expectedResult)){
            System.out.println("passed");
        }else{
            System.out.println("failed");


        }
    }
}


