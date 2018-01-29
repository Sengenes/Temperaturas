//https://stackoverflow.com/questions/41697488/read-column-values-from-excel-file-using-selenium-java

package temperaturas;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;	//Funciona con archivo .xlsx - Cambiar en declaración H por X
import org.apache.poi.xssf.usermodel.XSSFWorkbook;	//Funciona con archivo .xlsx
import org.apache.poi.hssf.usermodel.HSSFSheet;	//Para archivo .xls - Cambiar en declaración X por H
import org.apache.poi.hssf.usermodel.HSSFWorkbook;	//Para archivo .xls
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Temperaturas1OK {
	private WebDriver driver;
	private String baseUrl;
	
@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://www.metric-conversions.org/es/temperatura/celsius-a-fahrenheit.htm";
//	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	}
	  
@Test
	public void testTemperaturas() throws Exception {
    	driver.get(baseUrl);
		FileInputStream fs=new FileInputStream(new File("C:\\Users\\angeles.sengenes\\Documents\\Java\\Selenium\\Temperaturas2.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		
		while(rowIterator.hasNext()) {
			Row row= rowIterator.next();
			
			if(row.getRowNum()!=0) { //Saltea la primer fila de los títulos.
				Iterator cellIterator=row.cellIterator();
				while (cellIterator.hasNext()){
					
					Cell cell=(Cell) cellIterator.next();
					
					double Cent=cell.getNumericCellValue();
							
					driver.findElement(By.id("argumentConv")).clear();
		    		driver.findElement(By.id("argumentConv")).sendKeys(String.valueOf(Cent));	//sendKeys se limita a String, "valueOf" para que ingrese números.
		    		 
		    		String results = driver.findElement(By.id("answer")).getText();
		    		System.out.println(results);
		    
				}
			}
		}
	}

@After
public void tearDown() throws Exception {
  driver.close();
    
  	}
}