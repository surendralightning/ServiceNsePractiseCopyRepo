package wrappers;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class ProjectWrappers extends GenericWrappers {
	
	public String browserName;
	public String dataSheetName;
	
	@BeforeMethod
	public void launchApplication(){
		
		test = startTestCase(testCaseName, testDescription);
		test.assignAuthor(authors);
		test.assignCategory(category);
		invokeApp("chrome", "https://www.service.nsw.gov.au/");
	}
	@AfterMethod
	public void closebrowser(){
		closeAllBrowsers();
	}

	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}
	
	@AfterSuite
	public void afterSuite(){
		endResult();
	}
	@AfterClass
	public void afterClass(){
		endTestcase();
	}
	

	@DataProvider(name="fetchData")
	public Object[][] getDatainput() throws IOException{
		return Dataprovider.retreiveData(dataSheetName);
		
	}

}
