package pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LocatePage extends GenericWrappers{
	
	public LocatePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public ServiceCenterPage clickOnLocateUs(){
		clickByXpath("/html/body/div[3]/header/div/div[2]/div[1]/a");
		return new ServiceCenterPage(driver, test);
	}
	
}
