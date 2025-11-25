package practise.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.FileUtility.ExcelUtility;

public class GetProductData {
	ExcelUtility elib= new ExcelUtility();
	@Test(dataProvider="getDataProvider")
	public void getProductInfoTest(String brandName, String productName) throws InterruptedException, EncryptedDocumentException, IOException {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://amazon.in");
		
		/* Search product */
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
	String x="//span[contains(text(),'"+productName+"')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//div[@class='puisg-row puis-desktop-list-row']//div[@class='a-row']/a/span/span[2]/span[2]";
	Thread.sleep(2000);
	String price=driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	
	
	
	elib.writeDataToExcel("products", price, getRowNumberForInput(productName));
	
	driver.quit();
	}
	 private int getRowNumberForInput(String productName) throws IOException {
	        FileInputStream fis = new FileInputStream("./Utility_Files/Testdata6.xlsx");
	        Workbook wb = WorkbookFactory.create(fis);
	        Sheet sheet = wb.getSheet("products");

	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            if ( row.getCell(1).getStringCellValue().equals(productName))
	            {//row != null && row.getCell(1) != null &&
	                wb.close();
	                fis.close();
	                return i;
	            }
	        }
	        wb.close();
	        fis.close();
			int i = 0;
			return i;
	
	 }
	@DataProvider
	public Object[][] getDataProvider() throws EncryptedDocumentException, IOException
	{
		int lastRowNum=elib.getLastRowCount("products");
		//System.out.println(lastRowNum);
		Object[][] objArr= new Object[lastRowNum][2];
		for(int i=0;i<lastRowNum;i++)
		{
			
			objArr[i][0]=elib.getDataFromExcelUtility("products", i+1, 0);
			objArr[i][1]=elib.getDataFromExcelUtility("products", i+1, 1);
		}
		
//		
//		Object[][] objArr= new Object[3][2];
//		objArr[0][0]="poco";
//		objArr[0][1]="POCO C71, Power Black (6GB, 128GB)";
//		
//		objArr[1][0]="poco";
//		objArr[1][1]="POCO M6 Plus 5G Ice Silver 8GB RAM 128GB ROM";
//		
//		objArr[2][0]="poco";
//		objArr[2][1]="POCO C71, Desert Gold (6GB, 128GB)";
		return objArr;
	} 
}

