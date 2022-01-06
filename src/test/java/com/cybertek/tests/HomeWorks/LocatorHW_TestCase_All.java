package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW_TestCase_All {
    /**Test case 1
     Go to Ebay
     enter search term
     click on search button
     print number of results

     Test case 2
     Go to Ebay
     search Selenium
     click on search button
     verify title contains Selenium

     Test case 3
     Go to wikipedia.org (Links to an external site.)
     enter search term `selenium webdriver`
     click on search button
     click on search result `Selenium (software)`
     verify url ends with `Selenium_(software)'
     */
    public static void main(String[] args) throws InterruptedException {
//TEST CASE 1:
        // Go to Ebay:
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https:www.ebay.com");
        // enter search term:
        WebElement searchInputBox = driver.findElement(By.id("gh-ac"));
        searchInputBox.sendKeys("iphone X");
        // click on search button:
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();
        // get and print number of results
        String numberOfResults = driver.findElement(By.xpath("//div[@class='srp-controls__row-cells right']/../div/div/h1")).getText();
        System.out.println("Number of result: " + numberOfResults);
        System.out.println("Test Case 1: PASS");
        Thread.sleep(3000);

        driver.close();

//TEST CASE 2
        //Go to ebay:
        WebDriver driver2 = WebDriverFactory.getDriver("chrome");
        driver2.manage().window().maximize();
        driver2.get("https://www.ebay.com/");
        // search Selenium:
        WebElement searchBox2 = driver2.findElement(By.id("gh-ac"));
        searchBox2.sendKeys("Selenium");
        // click on search button:
        WebElement searchButton2 = driver2.findElement(By.xpath("//input[@id='gh-btn']"));
        searchButton2.click();
        Thread.sleep(2000);
        // verify title contains Selenium:
        String actualTitle1 = driver2.getTitle();
        System.out.println("Page Title: " + actualTitle1);
        if (actualTitle1.toLowerCase().contains("selenium")){
            System.out.println("Current Page Title: " + actualTitle1 + " contains \"Selenium\" ");
            System.out.println("Test Case 2: PASS");
        }else{
            System.out.println("Test Case 2: FAIL");
        }
        driver2.close();

// TEST CASE 3:
        // Go to wikipedia.org (Links to an external site):
        WebDriver driver3 = WebDriverFactory.getDriver("chrome");
        driver3.manage().window().maximize();
        driver3.get("https://www.wikipedia.org/");
        // Enter search term `selenium webdriver`
        WebElement wikiSearchBox = driver3.findElement(By.id("searchInput"));
        wikiSearchBox.sendKeys("selenium webdriver");
        // Click on search button:
        WebElement wikiSearchButton = driver3.findElement(By.xpath("//button[@type='submit']"));
        wikiSearchButton.click();
        // Click on search result `Selenium (software)'
        WebElement seleniumSoftwareLinkElement = driver3.findElement(By.xpath("//a[.=\"Selenium (software)\"]"));
        seleniumSoftwareLinkElement.click();
        // Verify url ends with `Selenium_(software)'
        String actualURL = driver3.getCurrentUrl();
        if (actualURL.toLowerCase().substring(actualURL.length()-19, actualURL.length()).equalsIgnoreCase("selenium_(software)")){
            System.out.println("Actual URL : " + actualURL);
            System.out.println("Expected end with URL : \"...Selenium_(software)\" ");
            System.out.println("Test Case 3 --> PASS");
        }else {
            System.out.println("Actual URL : " + actualURL + " Expected URL : \"...Selenium_(software)\"");
            System.out.println(actualURL.toLowerCase().substring(actualURL.length()-19, actualURL.length()));
            System.out.println("Test Case 3 --> FAIL");
        }
        Thread.sleep(3000);
        driver3.quit();


    }
}
