
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.FileUtility.ExcelUtility;
import com.comcast.crm.FileUtility.FileUtility;
import com.comcast.crm.JavaUtility.JavaUtility;
import com.comcast.crm.ObjectRepository.ContactsPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class CreateContactWithSupportDate {

	@Test
	public void createcontactwithSupportDate() throws EncryptedDocumentException, IOException, InterruptedException {

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
		hp.getContactLnk().click();

		ContactsPage cp = new ContactsPage(driver);

		cp.getCreateImg().click();

		ExcelUtility elib = new ExcelUtility();
		String lastName = elib.getDataFromExcelUtility("create", 4, 3) + ran;
		cp.getLastName().sendKeys(lastName);

		String currentDate = jlib.getpresentDate();
		String supportDate = jlib.getFutureDate(30);
		cp.getStartDate().clear();
		cp.getStartDate().sendKeys(currentDate);
		
		cp.getEndDate().clear();
		cp.getEndDate().sendKeys(supportDate);

		cp.getSaveBtn().click();

		WebElement signout = hp.getSignoutImg();
		wlib.ActionsMoveToElement(driver, signout);
		Thread.sleep(2000);
		hp.getSignoutLnk().click();
		driver.quit();

	}

}
