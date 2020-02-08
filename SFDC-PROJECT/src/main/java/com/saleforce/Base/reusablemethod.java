package com.saleforce.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class reusablemethod {

	public static WebDriver driver=null;
	 public static Properties prop;
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICITLY_WAIT=10;
	//private static ExtentReports extent;
	//private static ExtentTest Logger;
	public static ExtentHtmlReporter Reporter;
	public static  ExtentReports extent;
	public static  com.aventstack.extentreports.ExtentTest logger ;
	
public  static void main(String[] args) throws InterruptedException, IOException  {
	 Browserlunch();	
	// extentReports();
	
	}
public static void extentReports() {
	
	 Reporter = new ExtentHtmlReporter("./Reports1/Secondextent.html");
	 extent = new ExtentReports();
	 extent.attachReporter(Reporter);	
	 logger = extent.createTest("testName");
	
	
}
public static void property() {
try {	
	prop = new Properties ();
	FileInputStream ip =  new	FileInputStream ("C:\\eclipse-workspace\\SFDC-PROJECT\\src\\main\\java\\com\\saleforce\\utility\\utility.properties");
	prop.load(ip);
}
catch(FileNotFoundException e) {
	e.printStackTrace();
} 
catch(IOException e) {
	e.printStackTrace();
}	
	
}
public static void Browserlunch() throws InterruptedException {
		
		//String ChromDriverPath="C:\\Users\\jyoti\\Downloads\\chromedriver_win32.zip";
		System.setProperty("webdriver.chrome.driver","C:\\jyoti\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		 Thread.sleep(3000);
			System.out.println("Browser lunch is completed");
			}
		
// name of the method: Entertext         
public static void Entertext(WebElement ele,String Textvalue, String ObjectName) {
		if (ele.isDisplayed())
		{
			ele.sendKeys(Textvalue);
	
		System.out.println(Textvalue +"has been successfully entered into"+ ObjectName);
			//Logger.log(LogStatus.INFO, Textvalue+"has been succesfully entered in to" +ObjectName);
			}
			else
			{  System.out.println("Object is not displayed");
				//Logger.log(LogStatus.ERROR, "System is not  display in the"+ObjectName);
			}	
		
	        }

	// name of the method:   clickobject--->Button
	         
	
public  static void ClickElement(WebElement ele,String Objectname) {
		if (ele.isDisplayed())
		{
			ele.click();
	
			System.out.println(Objectname +"has been successfully clicByked");
			}
			else
			{System.out.println("Object is not displayed");
			}	
	}
	// The method is for move the mouse to the middle of the element and
	 // the element is scrolled into view than its location is calculated
	 
public static void MouseOverAction(WebElement ele,By locator ,String  ObjectName,String Textvalue) {
		
		WebElement We=driver.findElement(locator);
		new Actions(driver).moveToElement(We).build().perform();
		
		 }
	// switch to frame
public static void Switchframe(By locator) {

	    for(int i=0; i<=i; i++){
		driver.switchTo().frame(i);
		 int total =driver.findElements(locator).size();
		System.out.println(total);
	    driver.switchTo().defaultContent();}
		
	}
	//Switch to Windoews
public  static void SwitchToWindow() {
		  String mainWindow=driver.getWindowHandle();
		  Set<String>set=driver.getWindowHandles();
		  Iterator <String> itr=set.iterator();
		  while(itr.hasNext()) {
			  String childWindow=itr.next();
		      System.out.println("Myprofile method completed");
		  if (!mainWindow.equals(childWindow)) {
		      System.out.println (driver.switchTo().window(childWindow).getTitle());
		        
		        }
		        }
		        }
//Methods for drag and drop	
public static void draganddrop(By source,By target,String ObjectName) {
	WebElement from=driver.findElement(source);
	WebElement To=driver.findElement(target);
	new Actions(driver).dragAndDrop(from,To).perform();
	
	
}
// This method is to check whether the pupup present in the screen.
public static  void isPupupPreasent(WebElement ele ,String objectName) {
   if (ele.isDisplayed())
	{System.out.println(ele +"Is displayed in he screen");}
   else 
	{System.out.println(ele+"not found in the Screen");}
				
}
//Read Xlsx data
public static void readXlData(String locator) throws IOException{
	FileInputStream fs=new FileInputStream(new File(locator));
	HSSFWorkbook wb=new HSSFWorkbook(fs);
	HSSFSheet sheet=wb.getSheet("Sheet1");
	int rowCount=sheet.getLastRowNum()+1;
	int colCount=sheet.getRow(0).getLastCellNum();
	String[][] data=new String[rowCount][colCount];
	for(int i=0;i<rowCount;i++){
		for(int j=0;j<colCount;j++){
			int cellType=sheet.getRow(i).getCell(j).getCellType();
			if(cellType==HSSFCell.CELL_TYPE_NUMERIC){
				int val=(int)sheet.getRow(i).getCell(j).getNumericCellValue();
				data[i][j]=String.valueOf(val);
			}
			else
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
		}
	}
	
	for(int i=0;i<data.length;i++){
		for(int j=0;j<data[0].length;j++){
			
			System.out.print(data[i][j]+ " ");
		}
		System.out.println();
	}
	}
/*
 Convert web driver object to TakeScreenshot
 Call getScreenshotAs method to create image file  Move image file to new destination
 Copy file at destination
 */
public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
	
	TakesScreenshot srcShot=((TakesScreenshot)webdriver);
	File SrcFile=srcShot.getScreenshotAs(OutputType.FILE);
	File DestFile=new File( fileWithPath);
	FileUtils.copyFile(SrcFile, DestFile);

}

}


