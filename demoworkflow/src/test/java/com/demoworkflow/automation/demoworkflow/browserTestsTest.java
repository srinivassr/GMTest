package com.demoworkflow.automation.demoworkflow;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class browserTestsTest {
	
	WebDriver driv=null;
	public String src="Boston";
	public String dst="Rome";
	
	
  @Test(priority=1)
  public void initbrowser() 
  {
	  driv=GenericMode.browserIntit("chrome");
  }
   
  
  
  
  @Test(priority=2)
  public void gotowebsite() throws InterruptedException 
  {
	  boolean isvalid;
	 GenericMode.naviagate("https://blazedemo.com/");
	 Thread.sleep(5000);
	 isvalid= GenericMode.verifyHeader("Welcome to the Simple Travel Agency!","1");
	 Thread.sleep(5000);
    GenericMode.selectdropval("fromPort", src);
    Thread.sleep(3000);
    GenericMode.selectdropval("toPort", dst);
    Thread.sleep(3000);
    GenericMode.clickbtn();
   boolean v1= GenericMode.verifyHeader(src,"3") && GenericMode.verifyHeader(dst,"3") && GenericMode.isValidPage("reserve");
   
    
	 if (!isvalid) {
	    System.out.println("Failed due to exeception");
	}
	 else
	 {
		 System.out.println("Successfully added source & Destination");
	 }
  }
  
  @Test(priority=3 ,dependsOnMethods={"initbrowser"})
  public void closeborwser() 
  {
	 GenericMode.closeBrowser("close", driv);
  }
}
