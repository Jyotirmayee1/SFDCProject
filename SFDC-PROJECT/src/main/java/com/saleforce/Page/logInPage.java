package com.saleforce.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saleforce.Base.reusablemethod;


public class logInPage extends reusablemethod {

	//C
	//id for Usename 
	@FindBy(id="username")
	WebElement username;

	//id for password field
	@FindBy(id="password")
	WebElement password ;
	
	//id for logintab
	@FindBy(id="Login")
	WebElement Login ;	
	
	//id for remember me 
	@FindBy(id="rememberUn")
	WebElement rememberMe ;
	
	//id for forgot password
	@FindBy(id="forgot_password_link")
	WebElement forgotPWD ;
	
	// id for Usercustom Domain
	@FindBy(id="mydomainLink")
	WebElement   UsercustomDomain;
	
	//id for try for free
	@FindBy(id="signup_link")
	WebElement tryForFree  ;
	
	//Id for logo
	//@FindBy(id="logo")
	@FindBy(xpath="//img[@id='logo']")
	WebElement SFDClogo  ;
	
	//Initialization of page Factory objects
	public logInPage() {
	PageFactory.initElements(driver, this);
	}
	
	//This Method is returb=n sfdc title
	public  String getSFDCTitle() {
		return driver.getTitle();
		
	}
	//Check the Logo
	public  boolean CheckLogo() {
		return SFDClogo.isDisplayed();
		}
	//Check the UsenamePlace
	public boolean userName() {
		return username.isDisplayed();
		}	
	
	//This login page is return homePage
	 public homePage login(String un,String pwd) {
		 username.sendKeys(un);
		 password.sendKeys(pwd);
		 Login.click();
		  return new  homePage();
	}	
	//This login page is return homePage
	 public void  WrongInput(String un,String pwd) {
		 username.sendKeys(un);
		 password.sendKeys(pwd);
		 Login.click();
	}
	//rememember me button check
	 public homePage rememberMe(String un,String pwd) {
		 username.sendKeys(un);
		 password.sendKeys(pwd);
		 rememberMe.click();
		 Login.click();
		 return new  homePage(); 
	 }
	 
	//This login page is return homePage
		 public void forgotPassword(String un) {
			 username.sendKeys(un);
			 forgotPWD .click();
			 
}

}