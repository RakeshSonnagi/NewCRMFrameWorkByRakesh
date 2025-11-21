import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.FileUtility.FileUtility;
import com.comcast.crm.JavaUtility.JavaUtility;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.InvoicePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.ObjectRepository.OraganizationPopupPage;
import com.comcast.crm.ObjectRepository.ProductPage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class CreateProductAndInvoice {
	WebDriver driver;

	@Test
	public void createProductAndInvoice() throws IOException, InterruptedException {
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

		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomNumber();
		String startdate = jlib.getFutureDate(10);
		String endDate = jlib.getFutureDate(40);

		LoginPage lp = new LoginPage(driver);
		lp.loginactions(username, password);

		HomePage hp = new HomePage(driver);
		hp.getProductsLnk().click();
		hp.getCreateImg().click();

		ExcelUtility elib = new ExcelUtility();
		String productName = elib.getDataFromExcelUtility("create", 13, 0) + ran;

		ProductPage pp = new ProductPage(driver);
		pp.getProductName().sendKeys(productName);

		pp.getStartDate().sendKeys(startdate);
		pp.getSalesEndDate().sendKeys(endDate);
		WebElement accountDp = pp.getAccountDp();
		WebElement unitDp = pp.getUnitDp();

		wlib.select(accountDp, "306-Internet Sales");
		pp.getPriceEdt().clear();
		pp.getPriceEdt().sendKeys("10");

		wlib.select(unitDp, "Pack");

		pp.getSaveBtn().click();

		pp.getInvoiceLnk().click();
		String p = driver.getWindowHandle();

		InvoicePage ip = new InvoicePage(driver);
		ip.getSubjectEdt().sendKeys("finalBill");

		String OragnizationName = elib.getDataFromExcelUtility("create", 4, 2);
		ip.getOrgName().click();
		wlib.switchNewBrowsertab(driver, "module=Accounts");
		OraganizationPopupPage op = new OraganizationPopupPage(driver);
		op.getSearchEdt().sendKeys(OragnizationName);
		op.getSearchBtn().click();
		Thread.sleep(2000);
		op.getSelectName().click();
		wlib.alertAccept(driver);
		wlib.switchBackToParentwindow(driver, p);
		// driver.switchTo().window(p);

		Thread.sleep(2000);
		 WebElement billEle = ip.getBillAddress();
		 wlib.scrollToEle(driver, billEle);
		ip.getBillAddress().sendKeys("Banashankari");

		ip.getShipAddress().sendKeys("Banashankeri");
		ip.getSaveBtn().click();
		Thread.sleep(2000);

		driver.quit();

	}
}