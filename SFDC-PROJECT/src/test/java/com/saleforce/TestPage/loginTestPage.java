package com.saleforce.TestPage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saleforce.Base.reusablemethod;
import com.saleforce.Page.homePage;
import com.saleforce.Page.logInPage;



public class loginTestPage extends  reusablemethod{
	logInPage loginpage;
	homePage homepage;

	public  loginTestPage() {
		super();
	}
@BeforeMethod
public void SetBrowser() throws InterruptedException, IOException {
	property();
	 Browserlunch();	 
	loginpage= new logInPage();
}
@Test
public void checkTitle() {
String Title=loginpage.getSFDCTitle();
	Assert.assertEquals(Title,"Login | Salesforce");
}
 @Test
 public void Validatelogo() {
  boolean flag=loginpage.CheckLogo();
  Assert.assertTrue(flag);	 
 }

@Test
public void loginTest() {
	
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
@Test
public void enterWrongUser() {
	
	homepage = loginpage.login(prop.getProperty("wrongUsername"), prop.getProperty("wrongPassword"));
}
@AfterMethod
public void tearDown(){
	driver.quit();
}

}


