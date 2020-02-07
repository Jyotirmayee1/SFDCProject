package com.saleforce.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saleforce.Base.reusablemethod;


public class homePage extends reusablemethod {

//xpath for Chatter Tab
 @FindBy(xpath="//span[contains(text(),'Chatter')]")
 WebElement chatter;

//xpath for contacts tab
@FindBy(xpath= "//span[@class='slds-truncate'][contains(text(),'Contacts')]")
WebElement contacts;

//xpath for Account tab
@FindBy(xpath= "//span[@class='slds-truncate'][contains(text(),'Accounts')]")
WebElement account;

//xpath for Sales tab
@FindBy(xpath= "//span[@class='slds-truncate'][contains(text(),'Sales')]")
WebElement sales;

//xpath for Lead tab
@FindBy(xpath= "//span[@class='slds-truncate'][contains(text(),'Leads')]")
WebElement lead;

//xpath for Opportunities tab
@FindBy(xpath= "//span[@class='slds-truncate'][contains(text(),'Opportunities')]")
WebElement opportunities;

//xpath for Cases tab
@FindBy(xpath= "//span[@class='slds-truncate'][contains(text(),'Cases')]")
WebElement cases;

//xpath for Reports tab
@FindBy(xpath= "//span[@class='slds-truncate'][contains(text(),'Reports')]")
WebElement reports;

//xpath for Dashboards tab
@FindBy(xpath= "//span[@class='slds-truncate'][contains(text(),'Dashboards')]")
WebElement dashboard;

//xpath for Files tab
@FindBy(xpath= "//span[@class='slds-truncate'][contains(text(),'Files')]")
WebElement files;

//xpath for Tasks tab
@FindBy(xpath= "//span[@class='slds-truncate'][contains(text(),'Tasks')]")
WebElement task;

//xpath for Uimage
@FindBy(xpath="//div[@class='profileTrigger branding-user-profile bgimg slds-avatar "
		+ "slds-avatar_profile-image-small circular forceEntityIcon']//span[@class='uiImage']")
WebElement image;

//xpath for logout
@FindBy(xpath= "//a[contains(text(),'Log Out')]")
WebElement logout;

//Initialization of page Factory objects
	public homePage() {
	PageFactory.initElements(driver, this);
	}

public void logoutSfdc(String un,String pwd) {
	 logout.click();
	
}

}
