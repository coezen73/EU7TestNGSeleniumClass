package com.cybertek.tests.day6_CSS;

public class CLASS_NOTES_day_6 {
 /*
                                * * *  CSS  * * *
                               _ANOTHER   LOCATOR_

     * Cascading Style Sheets (CSS), is a simple design language indented to simplify the
       process of making web pages presentable.
     * It handles the 'look' and 'feel' part of webpage.You can control the color of the text,
       style of fonts, spacing between paragraphs,how columns are sized, what background images
       or colors are used, etc.
     * It is another LOCATOR in Selenium.
     * CSS is easier than 'Xpath' and easier to write as well...
---------------------------------------------------------------------
* LOCATING ELEMENT WITH ID: TagName#idvalue '#': looking for id
                    - If we remove the tagName, it will search for all elements:  #button_three
                    -> ID
                    <button id="disappearing_button"</button>
                    * xPATH: //button[@id='disappearing_button']
                    * CSS: button#disappearing_button OR, #disappearing_button
-----------
* LOCATING ELEMENT WITH CLASS: TagName.classValue  '.': looking for Class
                    <a class="nav-link" href="/">Home</a>
                    * xPATH: //a[@class='nav-link']
                    * * CSS: a.nav-link OR, .nav-link
-----------
* LOCATING ELEMENT WITH CLASS(MORE THAN ONE) DAV:

     <button class="btn btn-primary">Button 1</button> 'btn': a class / 'btn-primary': another class /
                                                            ' '(space): different class = multiple classes
     (button).btn.btn-primary => Find element that has an attributes 'class', which are equal to btn AND btn-primary
------------
 * LOCATING ELEMENT WITH KNOWN ATTRIBUTE & VALUE: TagName[attribute='value']

                * It is used for locating elements when at least 1 of the attribute value is static.
   Example:
           <button class="btn btn-primary" onclick="button1()">Button 1</button>

           * xPATH: //button[@onclick='button1()']    * CSS: (button)   [onclick='button1()']
------------

NOTE:
* * * BY USING CSS SELECTOR, WE CAN NOT USE TEXT OF ELEMENT, TO LOCATE.
       ONLY XPATH CAN FIND THE SPECIFIC WEB ELEMENT TEXT !! -> //TagName[contains(text(),'exact text')]

-----------

                        * LOCATION DYNAMIC ELEMENT WITH:
*  'STARTING WITH': TagName[attribute^='value']
                                                 '^': For looking 'starting part of the value'.
     Example:                                    * We use when 'first part of the attribute value is static.'
   <button class="btn btn-primary" onclick="button3()" id="button_check">Button 3</button>
   * xPATH: //button[starts-with(@id,'button_')]  * CSS: button[id^='button']
----------
* ENDS WITH:  (Xpath is not working with chrome!)   CSS-> TagName[attribute$='value']
                                                '$': For looking 'ending part of the value'.
                                                *  We use when 'last part of the attribute value is static.'
      Example:
    <button  id="button_check">Button 3</button>
    * CSS: button[id$='_button']
 ----------
* CONTAINS: TagName[attribute*='value']  '*' For looking any part of the value (contains)
    Example:
    <button  id="disappearing_button">Don't click!</button>
    * xPATH: //button[contains(@id,'ring')]   * CSS: button[id*='ring']
 -----------
 * INDEX IN CSS: (If they are under the same family)  <yourCSS>:nth-of-type(index)
     Example:
     <button class="btn btn-primary" onclick="button2()" id="btn324">Button 2</button>
  * * * xPATH: //button[2]            * CSS: button[onclick^='button']:nth-of-type(2)
    * IN CSS, IT IS VERY PAINFUL AND NOT USEFUL.-> + It only works if they have same parent.
------------
MULTIPLE ATTRIBUTES: TagName[attribute1='value1'][attribute2='value2']
* If both attributes are matching then it will find an element
       Example:
        <button class="btn btn-primary" onclick="button2()" name="button2">Button 2</button>
         button[onclick='button2()'][name='button2']
-----------------------------------------------------------------------------------------------------
* LOCATE CHILD ELEMENT :

* Xpath: //tag/tag/tag -> we use '/'
* CSS:  tag>tag>tag>  -> we use '>'
    Example:
    * div>h3 -> find any 'h3' element whose parent is 'div'
    * ul>li>a -> find 'ul, then its child li, then its child a
-----------
* LOCATE DESCENDANT(GRANDCHILD) ELEMENT :

* Xpath: //tag//tag/tag -> we use '//'
* CSS: tag tag tag -> we use ' ' (space)
    Example:
    * ul a -> find 'ul', then find its descendant 'a'
 ----------

 * * * NO CHILD TO PARENT IN CSS ! !
  * Xpath: /../../
-----------
* LOCATE FOLLOWING SIBLING (YOUNGER BRO/SIS)

* * CSS:  <knownCSS>~TagName -> we use '~' (tilda)
    Example:
    * h3~p
-------------------------------------------------------------------------------------------------------
 Interview Q:                 * * CSS    vs     XPATH * *
- CSS is slightly faster than xpath on IE, with other browsers it is negligible.
- CSS is easier to write and read, cleaner syntax.

1. CSS can't locate an element using text
* Xpath:  //*[.="Don't Click"]           CSS: NA (Not Applicable) -> (Uygulanamaz)

2. CSS can't find from matches based on index (different parents)
* Xpath: (Xpath formula)[indexNumber]   CSS: NA

3. CSS can't locate child to parent
* Xpath: //button/../.. -> move to parent   CSS: NA
------------------------------------------------------------------
   HIERARCHY OF LOCATORS - (FOR ALL ELEMENTS EXCEPT LINKS)

   * id:  Always look for id first, they are unique. (Dynamic Problem.!)

   * name: Not always unique, but not repeated that much.(Careful about radioButtons)

   * tagName: If it is unique(only one) or first one in the page

   * className: If there is a space, we should avoid using it, tagName rules are valid here too.
-----------
   * CSS:  partial dynamic - attribute value - more than one class, direct id

   * Xpath: text of element - index - child parent

   LINKS
   Go with LinkText or PartialLinkText


  */




}
