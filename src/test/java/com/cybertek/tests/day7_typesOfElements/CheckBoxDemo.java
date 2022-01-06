package com.cybertek.tests.day7_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo<driver> {

// Checkboxes have multiple selection, we have also both select or unselect options

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.cssSelector("#box1"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));

        // How to verify checkBox is selected or not?
        // Just like a radio buttons, we use isSelected() method to check.
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        //* shortcut: 'command+d' copy and past the entire line
        //* shortcut: 'command+x' delete the entire line

        // Verify checkbox 1 is NOT selected, but 2 is..
        Assert.assertFalse(checkBox1.isSelected(),"Checkbox1 is NOT selected");
        Assert.assertTrue(checkBox2.isSelected(),"CheckBox2 is selected");
        Thread.sleep(2000);

        // How to check checkboxes? -> just like in radio button, we use .click()method
        checkBox1.click();
        System.out.println("Clicked the checkBox1");

        //verify the actual result
        Assert.assertTrue(checkBox1.isSelected(),"Checkbox1 is selected");
        Assert.assertTrue(checkBox2.isSelected(),"CheckBox2 is selected");

        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        Thread.sleep(2000);
        driver.quit();
    }

}
