import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.FileUtility.FileUtility;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.ObjectRepository.ProductSearchPage;
import com.comcast.crm.ObjectRepository.PurchaseOrderPage;
import com.comcast.crm.ObjectRepository.VendorsPage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class CreateVendorsAndInvoice {
	
	public class CreateVendor {
		WebDriver driver;
		@Test
		public void createVendor() throws IOException, InterruptedException
		{
			FileUtility plib = new FileUtility();
			String browser = plib.getDataFromProperties("browser");
			String url = plib.getDataFromProperties("url");
			String username = plib.getDataFromProperties("username");
			String password = plib.getDataFromProperties("password");

			WebDriverUtility wlib = new WebDriverUtility();
			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
			} else {
				driver = new ChromeDriver();
			}

			driver.get(url);
			wlib.maxBrowser(driver);
			wlib.waitForPageToLoad(driver);
			
			LoginPage lp = new LoginPage(driver);
			lp.loginactions(username, password);
			
			HomePage hp= new HomePage(driver);
			WebElement moreLnk = hp.getMoreLnk();
			wlib.ActionsMoveToElement(driver, moreLnk);
			Thread.sleep(3000);
			hp.getVendorLnk().click();
			
			VendorsPage vp=new VendorsPage(driver);
			vp.getCreateImg().click();
			vp.getVendorName().sendKeys("InnovativeComputers");
			vp.getSaveBtn().click();
			vp.getPurchaseLnk().click();
			
			PurchaseOrderPage pp= new PurchaseOrderPage(driver);
			pp.getSubjectEdt().sendKeys("newBattery");
			pp.getBillAddress().sendKeys("Rajajinagar");
			pp.getCopyRadio().click();
			String p = driver.getWindowHandle();
			

			pp.getSearchIcon().click();
			wlib.switchNewBrowsertab(driver, "module=Accounts");
			
			ProductSearchPage psp=new ProductSearchPage(driver);
			psp.getSearchEdt().sendKeys("mobiles616");
			psp.getSearchBtn().click();
			psp.getSelectName().click();
			
			
			wlib.switchBackToParentwindow(driver, p);
			
			pp.getQtyEdt().sendKeys("1");
			pp.getPriceEdt().sendKeys("1000");
			pp.getSaveBtn().click();
			
			driver.quit();
			
			
			
		}
		
	}

}
