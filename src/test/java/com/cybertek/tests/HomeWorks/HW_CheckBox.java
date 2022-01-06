package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
 /*Test Case Verify CheckBox CheckAll and UncheckAll Buttons
1.	Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2.	Login with-----Username: Tester, password: test
DO AS TEST CASE 1
3.	Click on check all button verify all the checkboxes are checked
4.	Click on uncheck all button verify that all the checkboxes are unchecked
DO AS TEST CASE 2
5.	Select one of the checkbox and delete one person
6.	Then verify that deleted item is no longer exists
*/
public class HW_CheckBox {
  @Test
     public void test1() throws InterruptedException {
         WebDriver driver = WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();

// 1.Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
         driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

//2.Login with-----Username: Tester, password: test
         WebElement inputUsername = driver.findElement(By.id("ctl00_MainContent_username"));
         inputUsername.sendKeys("Tester");
         WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
         inputPassword.sendKeys("test");
         Thread.sleep(2000);
         WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
         loginButton.click();

//3.Click on check all button verify all the checkboxes are checked
         WebElement checkAllBtn = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
         checkAllBtn.click();
         // from id / 'ctl00_MainContent_orderGrid_ctl02_OrderSelector'
         //  to  id /  'ctl00_MainContent_orderGrid_ctl09_OrderSelector' check boxes
         for (int i = 2; i <=9; i++) {
             String id = "ctl00_MainContent_orderGrid_ctl0" + i + "_OrderSelector";// String concatenation +i+
             WebElement checkBox = driver.findElement(By.id(id));
             Assert.assertTrue(checkBox.isSelected());
         }
        Thread.sleep(2000);

//4. Click on uncheck all button verify that all the checkboxes are unchecked
         WebElement uncheckAllBtn = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
         uncheckAllBtn.click();
         for(int i = 2; i<=9; i++){
             String id = "ctl00_MainContent_orderGrid_ctl0" + i + "_OrderSelector";
             WebElement checkBox = driver.findElement(By.id(id));
             Assert.assertFalse(checkBox.isSelected());
         }

//5. Select one of the checkbox and delete one person
        WebElement lastPerson = driver.findElement(By.xpath("//td[text()='Clare Jefferson']"));
         String lastPersonName = lastPerson.getText();
         WebElement lastCheckBox = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl09_OrderSelector"));
         lastCheckBox.click();
         WebElement deleteButton = driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete"));
         deleteButton.click();
         Thread.sleep(2000);
//6.	Then verify that deleted item is no longer exists
         WebElement lastPersonAfterDelete = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td[2]"));
         String lastPersonAfterDeleteText = lastPersonAfterDelete.getText();

      System.out.println(lastPersonName);
      System.out.println(lastPersonAfterDeleteText);
      Assert.assertNotEquals(lastPersonName, lastPersonAfterDeleteText);

         Thread.sleep(2000);
         driver.quit();
     }
     @AfterMethod
     public void tearDown() {
         System.out.println("Close Browser");
     }
 }
