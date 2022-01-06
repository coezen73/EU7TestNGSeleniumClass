package com.cybertek.tests.day2_WebDriver_Basics;

public class Navi_BasicLocNOTESday2_3_4 {

/*                       * * SELENIUM - SUMMARY, DAY 2-3-4 * *

                                      _DAY 2_

 Navigation to webpage with 3 code lines:
1-  WebDriverManager.firefox driver().setup(); //-> responsible for downloading various browsers
2-  WebDriver driver = new FirefoxDriver();  // -> creating a 'driver' object from selected browser
3-  driver.get("https://www.google.com");    // -> 'get method' to navigate to selected website (google)

  Creating a new package:
1- right to tests
2- click new -> package
3- Name: add to day2_web-driver_basics
4_ Hit to enter

  Creating utility package:
1. Right click on Cybertek package
 2. New -> package
  3. Name : utilities
   4. Enter
---------------------------------------------------------------------------------
METHODS:
  driver = current place of my browser!
  - driver.get(url)   --> navigate to selected website
  - driver.navigate().to(url) --> navigate to selected website

  - driver.navigate().back()  --> navigate to previous webpage
  - driver.navigate().forward() --> navigate to next webpage
  - driver.navigate().refresh() -->  refreshing the webpage

  - driver.getTitle() -->  gets the title of the page (inside the header)
  - driver.getCurrentUrl()   --> gets the url from browser
  - driver.getPageSource() -->  gets the source code(xml) of the page

  - Thread.sleep(millis:) --> break for estimated seconds in between the pages (Java)
  - driver.close() --> close the current tab
  - driver.quit() -->  close everything
----------------------------------------------------------------------------------

 _ BIG PICTURE_

	JAVA --> It is programming language in which wee write our tests

	IntelliJ -> we use it to write and execute our code/tests (Just like Eclipse)

	Library/Dependencies -> Set of pre-written classes, methods which we can add to our code and use

	SELENIUM -> automation tool/library, just another dependency

	MAVEN -> built management tool. We use to manage dependencies for example: we added selenium and
	          Java  faker libraries..

	Pom.xml --> brain of maven. We put dependencies and settings here.

=====================================================================================================================
                                      _DAY 3_

** Once you get the test case what will you do first?

	1* Read The test case & Try to understand
	2* Manually execute the test case
		1- Functionality should not be broken (it is working)
		2- Is it automatable with Selenium or not? (not having image, color, design etc.)
	3* Should pass manually first
---------------------------------------------------------------------------------------------
** 	How to read an error message ?

	1. Find 'exception' keyword and read the error message
	2. Go to end of the error?
	3. Click the blue link to see which line caused an error

-----------------------------------------------------------
                                         _DAY 4_
    METHODS:

  * findElement(By. )  <-- to look for a WebElement
     click()   <--  Selenium Element Action/ click the button
    sendKeys()  <-- Selenium Element Action/ send/give your text
    getText()   <-- Selenium Element Action/
    getAttribute("value")  <-- Selenium Element Action
-----------------
    getTitle()  <-- Selenium
    getCurrentUrl()  <-- Selenium General Method
--------------------------------------
  ** How to identify web elements ?

        1.Navigate to website
        2.Open the source(inspect button)
        3.Find the unique property(name or id values) for the element
-> (id, class, type = ATTRIBUTES / form_submit, forgot_password, radius = VALUES
----------------------------------------------------
* * * *
        driver       < --     Our page,browser
        driver.findElement()  <-- A method, used to find webElement on the page
        'By' is a selenium class for locators.

----------------------------------------------------------------
BASIC LOCATORS:
  *  We have 8 different locators':
                id
                name
                tagName
                className
                linkText
                PartialLinkText
                xPath (1 class)
                CSS(1 class)
==================

first locator: id
                      Be careful->  unique, but might be dynamic!!
 id <-- It will be always unique and the first locator we are looking for.
         * We have only  one condition before using it:
            If there is an id attribute available, we will check if it is DYNAMIC or NOT.
         * How to understand id value is changing/dynamic ?
            While we inspect the WebElement, we should REFRESH the webpage!
            If id values are changing, we CAN NOT use it. Refresh a couple of times always, to make sure.
            If it is not changing --> static, then we will use it.
==================

Second locator: name
                        Be careful -> mostly static, but there might be more than 1 (duplicate)
 Name <-- if we cannot use id, or it is dynamic, we look for the 'name'.
        name locator is static %99.99 time. BUT;
        name can be duplicate(radio buttons) so be careful. / might be problematic!!
----------
   * if we cannot find name or id, we look for

 tagName <--    <input type="text" name="full_name">
                <Input --> tag here
                rest is attribute and value
   * The problem is: Selenium reads the source code from top to bottom.
     If your locators matched with one webElement, selenium stops there.
   * If there is no id or name, we can use tagName based on two conditions:
            1.Tag should be used only one time.!
            2.There are multiple same tags, but you want to point the first tag.
  * We can not use index when we use tagName locator.
  *If there are multiple usage of same tag, we cannot point the second one.
====================

Third 	Locator:

className <--  Another attribute for locating web elements / we will be using a lot! * * *
               We will use it later to locate multiple elements in one shot.

         * * * When we shouldn't use classname locator ?
                If there IS A SPACE in the class attribute value, we CANNOT USE it.
====================

Fourth Locator:

linkText --> using FULL TEXT of link to locate link webElement on the webpage.
partialLinkText--> using UNIQUE PART of the link text to locate link webElement.
* * *  To find the link in HTML, we are looking for '<a'.
  */

}
