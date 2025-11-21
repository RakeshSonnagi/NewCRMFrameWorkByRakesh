
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
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.ObjectRepository.OrgPage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class CreateOrgNameWithIndustry {

	@Test
	public void createOrgwithIndusrty() throws IOException, InterruptedException {

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
		String orgName = elib.getDataFromExcelUtility("org", 1, 2) + ran;

		op.getAccName().sendKeys(orgName);
		WebElement industryDrop = op.getIndustryDp();
		String industryName = elib.getDataFromExcelUtility("org", 4, 3);
		wlib.select(industryName, industryDrop);


		Thread.sleep(2000);
		WebElement typeDrop = op.getAccttype();
		String typeName=elib.getDataFromExcelUtility("org", 4, 4);
		wlib.select(typeName, typeDrop);

		op.getSavebtn().click();

		/*
		 * String
		 * actualOrgName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).
		 * getText(); String exp=orgName; if(actualOrgName.contains(exp)) {
		 * System.out.println("Organization created Successfully"); }
		 */
		// close the browser

		// Verify The IndustryName and Type
		String actIndustryName = op.getActIndustryName().getText();
		if (actIndustryName.equals(industryName)) {
			System.out.println("===Indusrty Name is correct===");
		}

		String acttypeName = op.getActtypeName().getText();
		if (acttypeName.equals(typeName)) {
			System.out.println("===Select type for Indusrty is correct===");
		}

		driver.quit();

	}

}
