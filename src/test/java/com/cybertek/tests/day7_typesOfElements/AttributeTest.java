package com.cybertek.tests.day7_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void  test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));

        /* getAttribute("attributeName")
        When we pass valid 'attribute name' to 'getAttribute method',
                                    it will 'return the value' of that attribute: */

        // get the value of 'value' attribute:
        System.out.println(blueRadioButton.getAttribute("value"));// on

        //get the value of 'type' attribute:
        System.out.println(blueRadioButton.getAttribute("type")); // radio

        //get the value of 'name' attribute:
        System.out.println(blueRadioButton.getAttribute("name")); // color

        /* get the value of 'checked' attribute:
        Since it doesn't keep any value,it will return true or false based on the condition; */
        System.out.println(blueRadioButton.getAttribute("checked")); // true

        // Trying to get an attribute which doesn't exist:
        // If we pass 'non-existing attribute', it will 'return null'.
        System.out.println(blueRadioButton.getAttribute("href"));// null

        // "outerHTML" returns full html of that element.
        System.out.println(blueRadioButton.getAttribute("outerHTML"));
        // ->   <input type="radio" id="blue" name="color" checked="">


        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));

        // As a third way, if we can not find the element, we can use this to get the element:
        System.out.println(button2.getAttribute("outerHTML"));
        String outerHTML = button2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("Button 2"));

        System.out.println("Inner HTML:"+ button2.getAttribute("innerHTML"));

       /* When we need to get text of the web element:
        1.getText();
        2.getAttribute("value"); (inputBoxes)
        // Most of the time first two method is enough
        3.getAttribute("innerHTML"); --> it will work certain cases
        4.getAttribute("outerHTML"); --> manipulate and verify(contains)
*/
        driver.quit();
    }

}
