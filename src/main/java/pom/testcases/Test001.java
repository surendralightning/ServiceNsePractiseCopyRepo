package pom.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.LaunchPage;
import wrappers.ProjectWrappers;

public class Test001 extends ProjectWrappers{
	
	@BeforeClass
	public void setValues(){
		testCaseName = "TC001";
		testDescription = "Project";
		authors = "SUrendra";
		category = "Sample";
		dataSheetName = "TestData";
	}
	
	
	@Test(dataProvider="fetchData")
	public void tc001(String search, String code, String verify){
		new LaunchPage(driver, test)
		.searchBox(search)
		.clickOnApplyForNewNumberPlate()
		.clickOnLocateUs()
		.enterCode(code)
		.verifyOutput(verify);
	}

}
