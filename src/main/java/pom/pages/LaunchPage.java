package pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LaunchPage extends GenericWrappers {
	
	public LaunchPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public LaunchPage searchBox(String data){
		enterById("edit-contains", data);
		pressEnterById("edit-contains");
		return this;
		
	}

	public LocatePage clickOnApplyForNewNumberPlate(){
		clickByCss("a[href='/transaction/apply-number-plate']");
		return new LocatePage(driver, test);
	}
	
	
}
