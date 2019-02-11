package pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class ServiceCenterPage extends GenericWrappers{
	
	public ServiceCenterPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public ServiceCenterPage enterCode(String data){
		enterById("locatorTextSearch", data);
		pressEnterById("locatorTextSearch");
		return this;
	}
	
	public ServiceCenterPage verifyOutput(String text){
		verifyTextByXpath("//*[@id='locatorListView']/div/div/div/div[1]/a", text);
		return this;
	}
}
