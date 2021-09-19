package com.demoworkflow.automation.demoworkflow;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericMode {
	 public static WebDriver driver = null;
	 
	public static WebDriver browserIntit(String browserType)
	{
	
	  String projectdirectory=System.getProperty("user.dir");
		switch (browserType.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectdirectory+"//Executeables//chromedriver.exe");
			driver= new ChromeDriver();
			break;
		case "iE":
			System.setProperty("webdriver.driver.chromer", projectdirectory+"//Excuteables//IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.driver.chromer", projectdirectory+"//Excuteables//geckodriver.exe");
			driver= new FirefoxDriver();
			break; 
		default:
			System.out.println("invalid browsertype---");
			System.exit(0);
			break;
		}
		
		return driver;
		
	}
	
	
	public static void closeBrowser(String whatToDo, WebDriver dri) 
	{
	   if (whatToDo.equalsIgnoreCase("close")) 
	   {
		   dri.close();  
	} 
	   else 
	{
		   dri.quit();
	}	
	}
	
	
public static void naviagate(String url) 
{
  driver.get(url); 
}


public static boolean verifyHeader(String str,String headerType) 
{
	boolean isvalid=false;
	try {
		WebElement ele= driver.findElement(By.xpath(".//h"+headerType+"[contains(text(),'"+str+"')]"));
		isvalid=true;
	} catch (WebDriverException e) {
		System.out.println(e.getMessage());
		// TODO: handle exception
	}
	return isvalid;
	
	
}


public static void selectdropval(String type,String name) 
{
 boolean isavail;
	WebElement el=driver.findElement(By.xpath(".//select[@name='"+type+"']"));
	
	isavail=el.isDisplayed() && el.isEnabled();
	if (isavail)
	{
		Select st = new Select(el);
	int sz=	st.getOptions().size();
	if (sz>0) {
		st.selectByValue(name);
	} 
	else
	{
   System.out.println("Invalid Dropdown ");
	}
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	 
	
	
}

public static boolean isValidPage(String expected) 
{
	boolean isvalid = false;
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String curl=driver.getCurrentUrl();
	if (curl.contains(expected)) {
		isvalid=true;
	} else {
   System.out.println("URL expacted is mismatched");
	}
return	isvalid;
}


public static void clickbtn() 
{
	WebElement btn=driver.findElement(By.xpath(".//input[@value='Find Flights']"));
	btn.click();
}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
		
		
	}

}
