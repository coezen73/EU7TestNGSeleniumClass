package com.cybertek.tests.reviews.week03;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class CheckBoxHomeWork {


    public class CheckBoxHW {

        public WebDriver driver; // declare your variable/object globally and use it at every method
        @BeforeClass             // annotations are there to effect your test flow
        public void setClass(){
            driver = WebDriverFactory.getDriver("chrome"); // initialize our driver object
        }

        @BeforeMethod
        public void openPage(){
            driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
            driver.manage().window().maximize();
            // Login to WebPage
            WebElement userNameBox = driver.findElement(By.id("ctl00_MainContent_username"));
            userNameBox.sendKeys("Tester");
            WebElement passwordBox = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$password']"));
            passwordBox.sendKeys("test");
            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
            submitButton.click();
        }

        @AfterMethod
        public void closeBrowser(){
            driver.close();
        }

        @AfterClass
        public void killSession(){
            driver.quit();
        }

        @Test
        public void checkBoxAll(){
            // Click on check all button
            WebElement checkAllButton = driver.findElement(By.linkText("Check All"));                          checkAllButton.click();
            // verify all the checkboxes are checked

            // (//input[@type='checkbox'])[1] for the first
            // (//input[@type='checkbox'])[2]
// findElements method : can get actually dynamically row number
       /*
      Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected()); //1
      Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected()); //2
      Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).isSelected()); //3
      Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).isSelected()); //4
      Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).isSelected()); //5
        */

            for (int i = 1; i <= 8 ; i++) {
                String rowChechBoxLocator = "(//input[@type='checkbox'])["+i+"]"; // String Concatination
                WebElement rowCheckBox = driver.findElement(By.xpath(rowChechBoxLocator));
                Assert.assertTrue(rowCheckBox.isSelected(),"The CheckBox IS NOT selected");
            }

            WebElement unheckAllButton = driver.findElement(By.linkText("Uncheck All"));
            unheckAllButton.click();
            for (int i = 1; i <= 8 ; i++) {
                String rowChechBoxLocator = "(//input[@type='checkbox'])["+i+"]"; // String Concatination
                WebElement rowCheckBox = driver.findElement(By.xpath(rowChechBoxLocator));
                // Assert False method  rowCheckBox.isSelected() = NO looking for a FALSE result
                Assert.assertFalse(rowCheckBox.isSelected(),"The CheckBox IS STILL selected");
            }
        }

        @Test
        public void deletePersonTest(){
            String name = "Charles Dodgeson"; // if I change the name code test should still work
// locator for person name cell: //*[contains(text(),'Steve Johns')]
// locator for checkBox of the person that I want to delete
//   //*[contains(text(),'Steve Johns')]/preceding-sibling::*/input  (sibling method)
//  //*[contains(text(),'Steve Johns')]/..//td[1]/input     (parent-child method)
//   //td[2]//*[contains(text(),'Charles Dodgeson')]

            String locatorCheckBoxOfPerson = "//*[contains(text(),'"+name+"')]/preceding-sibling::*/input";

            WebElement checkBoxOfPerson = driver.findElement(By.xpath(locatorCheckBoxOfPerson));

            checkBoxOfPerson.click();

            WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
            deleteButton.click();

// After I delete, I will get all the names and put them in a ArrayList then verfiy that deleted person is not in the list

            // locator for the first person
            // (//input[@type='checkbox'])[1]/../../td[2]
            ArrayList<String> names = new ArrayList<>();

            for (int i = 1; i <= 7; i++) {
                String eachNameLocator = "(//input[@type='checkbox'])["+i+"]/../../td[2]";
                WebElement eachNameElement = driver.findElement(By.xpath(eachNameLocator));
                String eachName = eachNameElement.getText();
                names.add(eachName);
            }

            System.out.println("names = " + names);

            Assert.assertFalse(names.contains(name),"The Name is STILL there, could NOT delete");


        }
    }
}



