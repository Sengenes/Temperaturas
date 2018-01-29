package temperaturas;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Temperaturas1 {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  String fileName="C:\\Users\\angeles.sengenes\\Documents\\Selenium\\Temperaturas.csv";
  File file=new File(fileName);
  
 @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\angeles.sengenes\\Documents\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	baseUrl = "http://www.metric-conversions.org/es/temperatura/celsius-a-fahrenheit.htm";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
}
  
 @Test
  public void testTemperaturas() throws Exception {
	    driver.get(baseUrl);
	    
	    try {
	    	Scanner Cent=new Scanner(file);
	    	
	    	
	    	
	    	while(Cent.hasNext()) {
	    		 driver.findElement(By.id("argumentConv")).clear();
	    		 driver.findElement(By.id("argumentConv")).sendKeys("");
	    		 
	    		    String Fahrenheit = driver.findElement(By.id("answer")).getText();
	    		    System.out.println(Fahrenheit);
	    		    }
	    	
	    	Cent.close();
	  }
	    catch (FileNotFoundException e) {
	    	e.printStackTrace();
    }
	    
  
  /*public void testTemperaturas() throws Exception {
    driver.get(baseUrl + "/es/temperatura/celsius-a-fahrenheit.htm");
    // ERROR: Caught exception [unknown command [readCSV]]
    // F1=Fila 1, inicio de loop.
    String F1 = "1";
    // F8=última fila, fin de loop.
    String F8 = "8";
    // ERROR: Caught exception [unknown command [while]]
    // T=valor de temperatura según archivo.
    // ERROR: Caught exception [unknown command [storeCellValue]]
    driver.findElement(By.id("argumentConv")).clear();
    driver.findElement(By.id("argumentConv")).sendKeys("${T}");
    String Fahrenheit = driver.findElement(By.id("answer")).getText();
    System.out.println(Fahrenheit);
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | ${F1}+1 | ]]
    // ERROR: Caught exception [unknown command [endWhile]]
    // No almacena los resultados para comparación.
*/  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

/*  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }*/

/*  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }*/

/*  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }*/
}