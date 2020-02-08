package com.saleforce.TestPage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.saleforce.Base.reusablemethod;
import com.saleforce.Page.homePage;
import com.saleforce.Page.logInPage;



public class loginTestPage extends  reusablemethod{
	logInPage loginpage;
	homePage homepage;
	public ExtentHtmlReporter Reporter;
	public  ExtentReports extent;
	public  com.aventstack.extentreports.ExtentTest logger ;

	public  loginTestPage() {
		super();
	}
	@ BeforeClass
	public void setExtentRepo() {
		
		 Reporter = new ExtentHtmlReporter("./Reports/Fitextent.html");
		 extent = new ExtentReports();
		 extent.attachReporter(Reporter);	
		 logger = extent.createTest("testName");
		
		
	}	 
@BeforeMethod
public void SetBrowser() throws InterruptedException, IOException {
	property();
	 Browserlunch();

	loginpage= new logInPage();
}
@Test
public void checkTitle() {
	logger.log(Status.PASS, "checkTitle");
	logger.log(Status.INFO, "checkTitle");
String Title=loginpage.getSFDCTitle();
	Assert.assertEquals(Title,"Login | Salesforce");
	
}

 @Test
 public void Validatelogo() {
	 logger.log(Status.PASS, "Validatelogo");
		logger.log(Status.INFO, "Validatelogo"); 
  boolean flag=loginpage.CheckLogo();
  Assert.assertTrue(flag);	 
  
 }
 
@Test
public void  validateUseName() {
	logger.log(Status.PASS, " validateUseName");
	logger.log(Status.INFO, " validateUseName");
boolean Uname= loginpage.userName();
Assert.assertTrue(Uname);	
}

@Test(priority=3)
public void loginTest() {
	logger.log(Status.PASS, "loginTes");
	logger.log(Status.INFO, "loginTes");
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	
	
	/*WebElement username= driver.findElement(By.id("username"));
	
	username.sendKeys(" naik.jyotii12-tq3n@force.com");
	WebElement password=driver.findElement(By.id("password"));
	
	password.sendKeys("Ishi1234 ");
	WebElement login=driver.findElement(By.id("Login"));
	login.click();
	System.out.println(" Login is completed"); 
	 */
}
@Test(priority=1)
public void enterWrongUser() {
	logger.log(Status.PASS, "enterWrongUser");
	logger.log(Status.INFO, "enterWrongUser");
loginpage.login(prop.getProperty("wrongUsername"), prop.getProperty("wrongPassword"));
}
@Test(priority=2)
public void validateRememberme() {
	logger.log(Status.PASS, "validateRememberme");
	logger.log(Status.INFO, "validateRememberme");
loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

}
@Test
public void ValidateForgotPasswod() {
	logger.log(Status.PASS, "ValidateForgotPasswod");
	logger.log(Status.INFO, "ValidateForgotPasswod");
	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	

}

@AfterMethod
public void tearDown(){
	driver.quit();
}
@AfterClass
public void teardown() {
		extent.flush();
}

}


