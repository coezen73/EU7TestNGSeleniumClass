package com.cybertek.tests.day7_testNG;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import org.testng.annotations.*;

public class BeforeAfterMethod {
   @BeforeClass
   public void setUpClass(){
       System.out.println("--BEFORE CLASS--");
       System.out.println("Execute One Time Before The Class");
   }
   @Test
    public void test1(){

       System.out.println("First Test Case");
    }
    @Ignore
    @Test
    public void test2(){

       System.out.println("Second Test Case");
    }
    @Test
    public void test3(){

       System.out.println("Third Test Case");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Webdriver, Opening Browser");
    }
    @AfterMethod
    public void tearDown(){

       System.out.println("Closing Browser");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("--AFTER CLASS--");
        System.out.println("Some Reporting Codes Place Here");
    }
}
