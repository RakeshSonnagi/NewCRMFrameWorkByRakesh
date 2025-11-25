

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.FileUtility.FileUtility;
import com.comcast.crm.JavaUtility.JavaUtility;
import com.comcast.crm.ObjectRepository.CreateCampaignPopup;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class CreateCampaign {

	@Test
	public void createOrg() throws IOException {

		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// get the values from property file
		String browser = flib.getDataFromProperties("browser");
		String url = flib.getDataFromProperties("url");
		String username = flib.getDataFromProperties("username");
		String password = flib.getDataFromProperties("password");
		WebDriver driver;

		// launch browser
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		wlib.maxBrowser(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(url);

		String pageTitle = driver.getTitle();
		wlib.waitForSomeCondition(driver, pageTitle);

		int ran = jlib.getRandomNumber();

		LoginPage lp = new LoginPage(driver);
		lp.loginactions(username, password);
	
		HomePage hp=new HomePage(driver);
		WebElement quickDP = hp.getQuickcreateDp();
		wlib.select(quickDP, "Campaigns");

		ExcelUtility elib=new ExcelUtility();
		String campaignName = elib.getDataFromExcelUtility("create", 10, 0)+ ran;
		CreateCampaignPopup ccp=new CreateCampaignPopup(driver);
		ccp.getCampaignNameEle().sendKeys(campaignName);

		ccp.getSaveBtn().click();
		System.out.println("<===Campaign Created Successfully==>");
		driver.quit();
		
	}

}
