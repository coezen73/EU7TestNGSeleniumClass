package com.cybertek.tests.day4_BasicLocators.day5_xPath;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AmazonTest {
    /**
     * TASK
     * go to amazon.com
     * search for selenium
     * click search button
     * verify 1-48 of 304 results for "Java"
     */

    public static void main(String[] args) throws InterruptedException {
        //open Chrome browser and go to amazon:
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        //Search for selenium:
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("selenium");

        // Click search button:
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        // Verify 1-48 of 304 results for "selenium"--> 'results for' is static : only doable with xpath
        WebElement result = driver.findElement(By.xpath("//*[contains(text(),'results for')]"));
        // to return the result(actual) text:
        String resultText = result.getText();
        System.out.println("resultText = " + resultText);

        String expectedResult = "1-48 of 198 results for";
        System.out.println("expectedResult = " + expectedResult);

        Thread.sleep(3000);

        //Verify:
        if (expectedResult.equals(resultText)){
        System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.close();
    }
}




