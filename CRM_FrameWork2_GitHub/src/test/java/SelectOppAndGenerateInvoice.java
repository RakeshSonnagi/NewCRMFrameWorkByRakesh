import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.FileUtility.FileUtility;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.InvoicePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.ObjectRepository.OpportunityPage;
import com.comcast.crm.ObjectRepository.OraganizationPopupPage;
import com.comcast.crm.ObjectRepository.ProductSearchPage;
import com.comcast.crm.ObjectRepository.PurchaseOrderPage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class SelectOppAndGenerateInvoice {
	
	
	WebDriver driver;
	@Test
	public void selectOpp() throws IOException, InterruptedException 
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
		
		HomePage hp=new HomePage(driver);
		hp.getOppLnk().click();
		
		OpportunityPage op=new OpportunityPage(driver);
		WebElement searchDp = op.getSearchDp();
		wlib.select(searchDp,"potentialname");
		op.getSearchField().sendKeys("Zoho");
		op.getSearchBtn().click();
		
		op.getOppName().click();
		String p = driver.getWindowHandle();
		
		op.getCreateinvoiceLnk().click();
		
		InvoicePage ip = new InvoicePage(driver);
		ip.getSubjectEdt().sendKeys("finalBill");

		ExcelUtility elib= new ExcelUtility();
		String OragnizationName = elib.getDataFromExcelUtility("create", 4, 2);
		ip.getOrgName().click();
		//OraganizationPopupPage op1= new OraganizationPopupPage(driver);
		wlib.switchNewBrowsertab(driver, "module=Accounts");
		OraganizationPopupPage op1 = new OraganizationPopupPage(driver);
		op1.getSearchEdt().sendKeys(OragnizationName);
		op1.getSearchBtn().click();
		Thread.sleep(2000);
		op1.getSelectName().click();
		wlib.alertAccept(driver);
		wlib.switchBackToParentwindow(driver, p);
		// driver.switchTo().window(p);

		Thread.sleep(2000);
		 WebElement billEle = ip.getBillAddress();
		 wlib.scrollToEle(driver, billEle);
		ip.getBillAddress().sendKeys("Kattariguppe");

		ip.getShipAddress().sendKeys("Kattariguppe");
		
		PurchaseOrderPage pp= new PurchaseOrderPage(driver);
		pp.getSearchIcon().click();
		wlib.switchNewBrowsertab(driver, "module=Accounts");
		
		ProductSearchPage psp=new ProductSearchPage(driver);
		psp.getSearchEdt().sendKeys("mobiles616");
		psp.getSearchBtn().click();
		psp.getSelectName().click();
		
		
		wlib.switchBackToParentwindow(driver, p);
		
		pp.getQtyEdt().sendKeys("10");
		pp.getPriceEdt().clear();
		pp.getPriceEdt().sendKeys("1000");
		pp.getSaveBtn().click();
	
		driver.quit();
		

}
}
