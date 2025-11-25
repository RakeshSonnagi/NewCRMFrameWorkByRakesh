import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.InvoicePage;
import com.comcast.crm.ObjectRepository.OpportunityPage;
import com.comcast.crm.ObjectRepository.OraganizationPopupPage;
import com.comcast.crm.ObjectRepository.ProductSearchPage;
import com.comcast.crm.ObjectRepository.PurchaseOrderPage;

public class SelectOppAndGenerateInvoice extends BaseClass {

	@Test
	public void selectOpp() throws IOException, InterruptedException {
		wlib.waitForPageToLoad(driver);

		HomePage hp = new HomePage(driver);
		hp.clickOnOppLnk();

		OpportunityPage op = new OpportunityPage(driver);
		WebElement searchDp = op.getSearchDp();
		wlib.select(searchDp, "potentialname");
		op.enterSearchField();

		op.getOppName().click();
		String p = driver.getWindowHandle();

		op.clickOnInvoiceLnk();

		InvoicePage ip = new InvoicePage(driver);
		ip.enterSubjectField();

		ExcelUtility elib = new ExcelUtility();
		String OragnizationName = elib.getDataFromExcelUtility("create", 4, 2);
		ip.clickOnOrgLnk();
		wlib.switchNewBrowsertab(driver, "module=Accounts");
		OraganizationPopupPage op1 = new OraganizationPopupPage(driver);
		op1.searchOrgAndSelectOrgAndClickOnSave(OragnizationName);
		wlib.alertAccept(driver);
		wlib.switchBackToParentwindow(driver, p);

		Thread.sleep(2000);
		WebElement billEle = ip.getBillAddress();
		wlib.scrollToEle(driver, billEle);
		ip.enterBillingAddAndShippingAdd();

		PurchaseOrderPage pp = new PurchaseOrderPage(driver);
		pp.clickOnSearchIcon();
		wlib.switchNewBrowsertab(driver, "module=Accounts");

		ProductSearchPage psp = new ProductSearchPage(driver);
		psp.enterSearchFieldAndClickOnSaveBtnAndSelectName();

		wlib.switchBackToParentwindow(driver, p);
		pp.enterQtnAndEnterPriceClickOnSave();
		wlib.alertAccept(driver);
		Reporter.log("For selected Opportunity Invoice generated successfully", true);

	}
}
