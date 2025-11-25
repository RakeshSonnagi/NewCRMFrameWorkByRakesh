import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.ProductSearchPage;
import com.comcast.crm.ObjectRepository.PurchaseOrderPage;
import com.comcast.crm.ObjectRepository.VendorsPage;

public class CreateVendorsAndInvoice {

	public class CreateVendor extends BaseClass {
		@Test
		public void createVendor() throws IOException, InterruptedException {

			wlib.waitForPageToLoad(driver);

			HomePage hp = new HomePage(driver);
			WebElement moreLnk = hp.getMoreLnk();
			wlib.ActionsMoveToElement(driver, moreLnk);
			Thread.sleep(3000);
			hp.clickOnVendorLnk();

			VendorsPage vp = new VendorsPage(driver);
			vp.clickOnImgAndEnterVendorNameClickOnsaveBtn();

			PurchaseOrderPage pp = new PurchaseOrderPage(driver);
			pp.enterSubjectFieldAndBillAddAndSelectRadioBtn();
			String p = driver.getWindowHandle();
			pp.clickOnSearchIcon();
			wlib.switchNewBrowsertab(driver, "module=Accounts");

			ProductSearchPage psp = new ProductSearchPage(driver);
			psp.enterSearchFieldAndClickOnSaveBtnAndSelectName();

			wlib.switchBackToParentwindow(driver, p);

			pp.enterQtnAndEnterPriceClickOnSave();
			Reporter.log("Vendor id created successfully with Invoice",true);

		}

	}

}
