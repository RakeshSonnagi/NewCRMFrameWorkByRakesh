import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.FileUtility.FileUtility;
import com.comcast.crm.JavaUtility.JavaUtility;
import com.comcast.crm.ObjectRepository.CampaignPage;
import com.comcast.crm.ObjectRepository.CreateCampaignPopup;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class CreateCampaignAndDelete {
	WebDriver driver;
	@Test
	public void campaignTest() throws IOException, InterruptedException 
	
	{
		FileUtility plib=new FileUtility();
		String browser = plib.getDataFromProperties("browser");
		String url=plib.getDataFromProperties("url");
		String username = plib.getDataFromProperties("username");
		//System.out.println(username);
		String password = plib.getDataFromProperties("password");
		
		WebDriverUtility wlib = new WebDriverUtility();
		if(browser.equals("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(browser.equals("firefox")) 
			{
				driver= new FirefoxDriver();
			}
			else {
				driver = new ChromeDriver();
			}
			
		driver.get(url);
		wlib.maxBrowser(driver);
		wlib.waitForPageToLoad(driver);
		
		JavaUtility jlib=new JavaUtility();
		int ran=jlib.getRandomNumber();
		
		LoginPage lp= new LoginPage(driver);
		lp.loginactions(username, password);
//		lp.getUsernameEle().sendKeys(username);
//		lp.getPasswordEle().sendKeys(password);
//		lp.getLoginBtn().click();
		
		HomePage hp=new HomePage(driver);
		WebElement createDp = hp.getDropDown();
		wlib.select(createDp, "Campaigns");
		
		ExcelUtility elib= new ExcelUtility();
		String campaignName = elib.getDataFromExcelUtility("create", 10, 0) + ran;
		CreateCampaignPopup cp=new CreateCampaignPopup(driver);
		cp.getCampaignNameEle().sendKeys(campaignName);
		cp.getSaveBtn().click();
		
		
		hp.getCampaignLnk().click();
		
		CampaignPage cp1=new CampaignPage(driver);
		WebElement cDW = cp1.getCampaignInDp();
		wlib.select("Campaign Name", cDW);
		cp1.getSearchField().sendKeys(campaignName);
		cp1.getSearchBtn().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='"+campaignName+"' and @title='Campaigns']/parent::td/following-sibling::td//a[text()='del']")).click();
		
		wlib.alertAccept(driver);
		Thread.sleep(2000);
		driver.quit();
	}

}
