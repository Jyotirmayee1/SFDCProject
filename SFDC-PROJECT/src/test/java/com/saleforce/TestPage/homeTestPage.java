package com.saleforce.TestPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saleforce.Base.reusablemethod;
import com.saleforce.Page.homePage;
import com.saleforce.Page.logInPage;

public class homeTestPage {
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
		 homepage =new homePage();
	}
	@Test
	public void validatelogout() {
	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}  
}
}