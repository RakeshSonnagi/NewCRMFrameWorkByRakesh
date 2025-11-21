package com.comcast.crm.WebDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtility {
	WebDriver driver;
//	public void launchBrowser(String key, String url)
//	{
//		
//		if(key.equals("chrome"))
//		{
//			driver=new ChromeDriver();
//		}
//		else if(key.equals("firefox")) 
//		{
//			driver= new FirefoxDriver();
//		}
//		else {
//			driver = new ChromeDriver();
//		}
//		driver.get(url);
//		
//	}
	public void maxBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void waitForPageToLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void waitForElementPresent(WebDriver driver, WebElement ele) 
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForSomeCondition(WebDriver driver, String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs(title));
	}
	public void switchNewBrowsertab(WebDriver driver, String exp)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) 
		{
			String windowID = it.next();
			driver.switchTo().window(windowID);
			@Nullable
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(exp)) 
			{
				break;
			}
		}
	}
	
	public void switchBackToParentwindow(WebDriver driver,String parentId) 
	{
		driver.switchTo().window(parentId);
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String name)
	{
		driver.switchTo().frame(name);
	}
	public void switchToFrame(String value, WebDriver driver)
	{
		driver.switchTo().frame(value);
	}
	
	public void select(WebElement dropDown, int index)
	{
		Select s=new Select(dropDown);
		s.selectByIndex(index);
	}
	public void select(WebElement dropDown, String value)
	{
		Select s=new Select(dropDown);
		s.selectByValue(value);
	}
	public void select(String Visibletext,WebElement dropDown)
	{
		Select s=new Select(dropDown);
		s.selectByVisibleText(Visibletext);
	}

	public void ActionsMoveToElement(WebDriver driver, WebElement ele) 
	{
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();;
	
	}
	
	public void scrollToEle(WebDriver driver, WebElement ele)
	{
		Actions act= new Actions(driver);
		act.scrollToElement(ele);
	}
	public void alertAccept(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
}
