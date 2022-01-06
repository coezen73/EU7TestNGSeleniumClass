package com.cybertek.tests.day7_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
   /* Radio Buttons
    Radio button is a type of elements in which only one option can be selected among group of options
    (Example: Gender - Male, Female, Other)
    Based on the requirements you might or might not have default option selected.
    //how to check radio button selected or not ?
    isSelected() --> if radio buttons selected it will return true, if not it will return false.
    //how to select radio button ?
    we can use click() method for selecting radio buttons
     //how can we check if the webElement is enabled ?
    isEnabled() --> method that returns true if the button enabled, if not it returns false. */
    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        // locating radio buttons:
        WebElement blueRadioBtn = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioBtn = driver.findElement(By.id("red"));

        // how to check radio button 'is selected or not'?
        // isSelected() --> If radio buttons selected, it will return true; if not,false.
        System.out.println("blueRadioBtn.isSelected() = " + blueRadioBtn.isSelected());
        System.out.println("redRadioBtn.isSelected() = " + redRadioBtn.isSelected());

        // Verify blue is selected, red is not.. (Instead of 'if' statement we have Assert methods)
        Assert.assertTrue(blueRadioBtn.isSelected(),"verify that blue btn IS selected");
        Assert.assertFalse(redRadioBtn.isSelected(),"verify that red btn is NOT selected");

        //how to click the radio btn?
        redRadioBtn.click();

        // BLUE -> False
        Assert.assertFalse(blueRadioBtn.isSelected(),"Verify that blue is NOT selected");
        // RED -> True
        Assert.assertTrue(redRadioBtn.isSelected(),"Verify that red is selected");

        Thread.sleep(3000);
        driver.quit();

    }
}
