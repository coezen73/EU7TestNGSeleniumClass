package com.cybertek.tests.day8_TypesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver; // we declare our webDriver in the class level,
                        // so it is reachable for every unit in the class..

    @BeforeMethod
    public void setUp() {
       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
        driver.quit(); // Important!-> we need to place 'driver.quit()' method always inside the 'AfterMethod'
                        // so even one of our test case fails, the browser will close anyway..

    }

     @Test
     public void test1(){

         driver.get("http://practice.cybertekschool.com/multiple_buttons");

         // save our webElements inside the list:
         List<WebElement> buttons = driver.findElements(By.tagName("button"));
         // we use 'sizeMethod' just like in arrays
         System.out.println("buttons.size() = " + buttons.size());
         // My first assertion, Verify buttons size:
         Assert.assertEquals(buttons.size(),6,"verify buttons size");
        // to get the list, I will use java - 'for each loop' -> iter + enter (shortcut)
         for (WebElement button : buttons) {
          //   System.out.println(button.getText()); // I have getText Method from selenium.
             // to verify each button is on  the screen:
             System.out.println("button.isDisplayed() = " + button.isDisplayed());
             // to be able to complete the verification I need to assert:
             Assert.assertTrue(button.isDisplayed(),"verify buttons are displayed");
         }
         // click second button: use get method than add the click method from selenium..
         buttons.get(1).click();
     }

     @Test
    public void test2(){

         driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // List<WebElement> buttons = driver.findElements(By.tagName("buttoluzgkug"));
       // Passing the locator name which doesn't exist, will not throw us to'NoSuchElement'
        // option+enter+enter-> shortcut to write the data type on the left side:
         List<WebElement> buttons = driver.findElements(By.tagName("buttoluzgkug"));
         System.out.println("buttons.size() = " + buttons.size());
     }
}
