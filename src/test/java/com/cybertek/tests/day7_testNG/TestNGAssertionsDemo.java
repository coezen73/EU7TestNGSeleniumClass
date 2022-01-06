package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.xml.dom.ParentSetter;


public class TestNGAssertionsDemo {
/* - Assert has methods used to do assertions like when we compare values.
   - If assertion fails, rest of the method will NOT execute
   - If your code fails in one @Test annotation, it will not affect other @Test s,
      each of them work independently. */

   @BeforeMethod
   public void setUp(){
       System.out.println("Open Browser");
   }
    @Test  // Assert.assertEquals(actual,expected)--> it checks two values if same or not:
    public void test1() {

        System.out.println("First Assertion");
        Assert.assertEquals("title", "title");
        System.out.println("Second Assertion");
        Assert.assertEquals("url", "url");
    }
    @Test
            public void test2(){
        Assert.assertEquals("test2","test2");
        }
    @Test  // Assert.assertTrue(condition) --> it checks whether condition returns true or not:
    public void test3(){

       String expectedTitle = "Cyb";
       String actualTitle = "Cybertek";
       Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title if it starts with Cyb");
    }
    @Test
    public void test4(){
       // verify  if email contains @ sign
        String email= "mike@smith.com";
      Assert.assertTrue(email.contains("@"), "Verify if email contains @");
    }
    @Test  //  Assert.assertFalse(condition) --> verifies if the condition return false or not :
    public void test5(){

       Assert.assertFalse(0>1,"Verify that 0 is not greater than 1");
    }
    @Test // Assert.assertNotEquals(actual,expected)--> verifies that two values are NOT equal to each other
    public void test6(){
       Assert.assertNotEquals("one","one");
    }

        // close? -> after method will always run
    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");
    }

    /* NOTE: Whether your testcase fail or not, your before and after method  execute ALWAYS.
              So, even if your code fails, you can quit from driver, close browser.*/


}
