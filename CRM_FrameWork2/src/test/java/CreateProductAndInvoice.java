import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.JavaUtility.JavaUtility;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.InvoicePage;
import com.comcast.crm.ObjectRepository.OraganizationPopupPage;
import com.comcast.crm.ObjectRepository.ProductPage;

public class CreateProductAndInvoice extends BaseClass {

	@Test
	public void createProductAndInvoice() throws IOException, InterruptedException {

		wlib.waitForPageToLoad(driver);

		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomNumber();
		String startdate = jlib.getFutureDate(10);
		String endDate = jlib.getFutureDate(40);

		HomePage hp = new HomePage(driver);
		hp.clickOnProductLnkAndClickOnCreateImg();

		ExcelUtility elib = new ExcelUtility();
		String productName = elib.getDataFromExcelUtility("create", 13, 0) + ran;

		ProductPage pp = new ProductPage(driver);
		pp.enterProductNameWithSupportDate(productName, startdate, endDate);
		WebElement accountDp = pp.getAccountDp();
		WebElement unitDp = pp.getUnitDp();

		wlib.select(accountDp, "306-Internet Sales");
		pp.enterPriceDetails();

		wlib.select(unitDp, "Pack");
		pp.clickOnSaveBtnAndInvoiceBtn();

		String p = driver.getWindowHandle();

		InvoicePage ip = new InvoicePage(driver);
		ip.enterSubjectField();

		String OragnizationName = elib.getDataFromExcelUtility("create", 4, 2);
		ip.clickOnOrgLnk();
		wlib.switchNewBrowsertab(driver, "module=Accounts");
		OraganizationPopupPage op = new OraganizationPopupPage(driver);
		op.searchForOrgAndClickOnSearchBtnAndSelectName(OragnizationName);
		wlib.alertAccept(driver);
		wlib.switchBackToParentwindow(driver, p);
		// driver.switchTo().window(p);

		Thread.sleep(2000);
		WebElement billEle = ip.getBillAddress();
		wlib.scrollToEle(driver, billEle);
		ip.enterBillingAddAndShippingAdd();
		Reporter.log("Product is created successfully and Invoice is generated for product",true);

	}
}