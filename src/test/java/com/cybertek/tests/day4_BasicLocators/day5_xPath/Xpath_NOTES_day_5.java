package com.cybertek.tests.day4_BasicLocators.day5_xPath;

public class Xpath_NOTES_day_5 {
/*            * * XPATH * *
        id
        name
        tagName
        className
        linkText
        PartialLinkText
        xPath (1 class)
        CSS(1 class)

==================

 xPath --->  is a unique way of finding elements on HTML page. It navigates through the html and
             tries to find element based on description we provide.

-------------------
 ABSOLUTE xPath:
                starts with single'/'
                It starts looking for elements from the root of html page.
                We describe all elements between 'html' tag and our element in descending order.
            Example:
                /html/body/div/div[2]/div/div/button[3]
                If we have same tagName and if we want to point specific element,
                we can use 'index' which is: [indexNumber]
           NOTE: Unlike java, index starts from '1' in HTML.

       * * Disadvantage of absolute xpath :
                It relies on the page hierarchy, if developers change the page,
                Absolute xPath will stop working very likely.
----------------------
RELATIVE xpath:
                It starts with double '//'
                and looks the element ANYWHERE on the page. It doesn't concern 'Parent-Child' relation
                //li/a --> We can combine // - /. Find 'li' element then find its child which has an 'a' tag

===============================================================================

                * * RELATIVE XPATH - SOME FORMULAS * *
  EXAMPLE HTML LINE: <button onclick="button1()">Button 1</button>

                <button : TagName        "button1()" :Value
                onclick= : Attribute      Button 1 : Text/content


  * ATTRIBUTE & VALUE: //button[@onclick='button1()'] ->  //Find any 'button element' with[@ 'onclick attribute'
                                                         which is equal= to 'button1() value'].

  * VALUE ONLY:  //button[@*='button1()'] -> //Find any 'button element' that has [@* 'ANY attribute'
                                               which is equal= to 'button1() value'].  ('*' can replace with TagName)

  * VISIBLE TEXT: //button[text()='Button 1'] OR //button[.='Button 1'] -> //Find any 'button element' that has
                                                        [text() or '.' a text which is equal= to 'Button 1 exact text']

 - //*[text()='Button 1']  ->  //* Find 'ANY element' that has[text() a text which is equal= to 'Button 1 text']

  * VISIBLE TEXT (PARTIAL): //TagName[contains(text(),'exact text')] -> locating elements containing exact text within,
                              an element -> We can use to get 'static' part of the text to make our test case dynamic!

  * STARTING WITH: //TagName[starts-with(@Attribute,'Value')] -> We can use it,  If attributes first part is Static!

  * ENDS WITH:  //TagName[ends-with(@Attribute,'Value')]  -> We can use it,  If attributes last part is Static!
    * * It doesn't work with Chrome!

  * CONTAINS: //TagName[contains(@Attribute,'Value')] ->
 ======================================================================================================================

  NOTE: What if there are MULTIPLE ELEMENTS for an XPATH?
        * If they 'don't have same parents' but xPath giving 'multiple matches' for our formula:

                    (OUR INDEX FORMULA)[INDEX NUMBER]:
       Example:  (//a[contains(text(),'Dynamic')])[2]

---------------------------------------------------------
    * * * LOCATING ELEMENTS RELATIVE TO KNOWN ELEMENT * * *

  We have learned  to locate Parent to child formulas.
        What if you want to move to sibling? OR You found the child and  want to go back to Parent. . ?

  * LOCATING PARENTS ELEMENT: //<knownXpath>/parent::*  OR, TagName EXAMPLE: -> //button[@name='button2']/parent::*

  * LOCATING FOLLOWING(OLDER BRO/SIS) SIBLING: //<knownXpath>/following-sibling::* OR TagName
                                 EXAMPLE: ->   //button[@name='button2']/following-sibling::*

  * LOCATING PRECEDING(YOUNGER BRO/SIS) SIBLING: //<knownXpath>/preceding-sibling::* OR TagName
                                   EXAMPLE: ->   //button[@name='button2']/preceding-sibling::*
  NOTE: MAGICAL DOTS!  After 'known Xpath' when you use '/..' you will go one level up,
                        and you can add one after another..
           Example:  //button[@name='button2']/../../../../..   -> We can go up to till the html tag!!

* We can use with Xpath; the 'text/content' even if there is a 'space' in between the words in 'class attribute'
 */

}
