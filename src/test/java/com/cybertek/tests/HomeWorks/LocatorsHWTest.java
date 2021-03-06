package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsHWTest {
  /*Test case
        Go to Ebay
        search Selenium
        click on search button
        print number of results
        verify title contains Selenium */
  public static void main(String[] args) throws InterruptedException {

      // This handles all those downloading necessary driver for your operating system
      WebDriverManager.chromedriver().setup();

      WebDriver driver = WebDriverFactory.getDriver("chrome"); // open an empty browser
      // Go to Ebay
      driver.get("https://www.ebay.com/");

      // search Selenium
      WebElement searchBox = driver.findElement(By.id("gh-ac"));

      String expectedSearcItem = "Selenium";

      searchBox.sendKeys(expectedSearcItem);

      Thread.sleep(2000);

      driver.close();

  }


}
