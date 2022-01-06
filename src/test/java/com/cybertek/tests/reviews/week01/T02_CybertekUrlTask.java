package com.cybertek.tests.reviews.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T02_CybertekUrlTask {
    /* go to http:// practice.cybertekdchool.com/ web site
    verify if the url contains "cybertekschool"
    verify the title as well
     */
    public static void main(String[] args) {
// initialize

      WebDriverManager.firefoxdriver().setup(); // aloud selenium to automate the firefox web browser
      WebDriver driver = new FirefoxDriver();
      driver.get("http://practice.cybertekschool.com");

        String title = driver.getTitle();
        System.out.println("title = " + title);
        driver.getCurrentUrl();




    }

    public static class InellijSettings {
        /*
    1. SETTINGS
       mouse zoom : Settings ->  editor->General-> Mause control

        Command  + shift + F Looks inside the whole project
        Command +F -> looks this current opened file

     2. When we create our Selenium projct what is the build tool?
      - > MAVEN: Built tool (Gradle, Ant)
        Manage Dependecies (Libraries)
        Built: repeated steps when creating a project*/

    }
}
