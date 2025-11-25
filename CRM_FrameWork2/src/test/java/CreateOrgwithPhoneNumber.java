
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.FileUtility.FileUtility;
import com.comcast.crm.JavaUtility.JavaUtility;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.ObjectRepository.OrgPage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class CreateOrgwithPhoneNumber {
	@Test
	public void createOrgwithPhoneNumber() throws IOException {

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
		HomePage hp = new HomePage(driver);
		hp.getOrgLnk().click();

		OrgPage op = new OrgPage(driver);
		op.getCreateimg().click();

		// read testscript data from excel sheet
		ExcelUtility elib = new ExcelUtility();
		String orgName = elib.getDataFromExcelUtility("org", 7, 2) + ran;

		op.getAccName().sendKeys(orgName);

		String phonenum = elib.getDataFromExcelUtility("org", 7, 3);
		// System.out.println(phonenum);
		op.getPhoneNumber().sendKeys(phonenum);

		op.getSavebtn().click();
		;

		String actphonenum = op.getActPhoneNumber().getText();
		if (actphonenum.equals(phonenum)) {
			System.out.println("===phone number is verified successfully===");
		}

		driver.quit();

	}

}
