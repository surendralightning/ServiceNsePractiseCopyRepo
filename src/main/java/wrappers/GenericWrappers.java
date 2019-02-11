package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericWrappers extends Reporter {
	
	
	public RemoteWebDriver driver;
	
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver_64bit.exe");
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")){
				System.setProperty("webdriver.internetexplorer.driver", "./drivers/internetexplorer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			//System.out.println("The browser"+browser+" launched.");
			reportStep("The browser"+browser+" launched.", "pass");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The browser"+browser+"not launched due to unknown error");
			reportStep("The browser"+browser+"not launched due to unknown error","fail");
			
		}
	}
	
	public long takeSnap() {
		long number=1000000l;
		// TODO Auto-generated method stub
		try {
			number=(long)Math.floor(Math.random()*10000000)+1000000l;
			File pic =  driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("./reports/images/"+number+".jpeg");
			FileUtils.copyFile(pic, dest);
		} 
		catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("The browser got closed because of unknown error ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}	
		return number;
	}

	
	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(idValue).sendKeys(data);
			//System.out.println("The element specified by the "+idValue+"Filled with correct input data" +data);
			reportStep("The element specified by the "+idValue+"Filled with correct input data" +data, "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified by the "+idValue+"not found");
			reportStep("The Element specified by the "+idValue+"not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified by the"+idValue+"not visible");
			reportStep("The Element specified by the"+idValue+"not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("theElement specified by the"+idValue+"is in invalid state");
			reportStep("theElement specified by the"+idValue+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("The element specified by the "+nameValue+"Filled with correct input data" +data);
			reportStep("The element specified by the "+nameValue+"Filled with correct input data" +data, "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified by the "+nameValue+"not found");
			reportStep("The Element specified by the "+nameValue+"not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified by the "+nameValue+"not visible");
			reportStep("The Element specified by the "+nameValue+"not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified by the"+nameValue+"is in invalid state");
			reportStep("The Element specified by the"+nameValue+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}{
			takeSnap();
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			//System.out.println("The element specified by the "+xpathValue+"Filled with correct input data");
			reportStep("The element specified by the "+xpathValue+"Filled with correct input data", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified by the "+xpathValue+"not found");
			reportStep("The Element specified by the "+xpathValue+"not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified by the "+xpathValue+"not visible");
			reportStep("The Element specified by the "+xpathValue+"not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified by the"+xpathValue+"is in invalid state");
			reportStep("The Element specified by the"+xpathValue+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}{
			takeSnap();
		}
		
	}
	public void clickByCss(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByCssSelector(id).click();
			System.out.println("The element specified with"  +id+"is clicked successfully");
			reportStep("The element specified with"  +id+"is clicked successfully", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+id+" was not found");
			reportStep("The Element specified with "+id+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+id+" was not visible");
			reportStep("The Element specified with "+id+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with "+id+" is in invalid state");
			reportStep("The Element specified with "+id+" is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}{
			takeSnap();
		}
	}

	
	
	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actualtext = driver.findElementByXPath(xpath).getText();
			System.out.println(actualtext+""+text);
			if(actualtext.equals(text)){
				System.out.println("the element with"+xpath+" is matched with the expected text");
				reportStep("The text is verified successfully", "pass");
			}else{
				System.err.println("the element with"+xpath+" is not matched with the expected text");
				reportStep("The text is not verified successfully", "fail");
			}
			//System.out.println("The text is verified successfully");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+xpath+" was not found");
			reportStep("The Element specified with "+xpath+" was not found" ,"fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+xpath+" was not visible");
			reportStep("The Element specified with "+xpath+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with"+xpath+"is in invalid state");
			reportStep("The Element specified with"+xpath+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}{
			takeSnap();
		}
	}
	public void pressEnterById(String Id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(Id).sendKeys(Keys.ENTER);
			//System.out.println("Tab operation performed successfully on the specified element"+Id);
			reportStep("Tab operation performed successfully on the specified element"+Id, "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified by the "+Id+"is not found to perform Tab operation");
			reportStep("The Element specified by the "+Id+"is not found to perform Tab operation", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified by the"+Id+"not visible");
			reportStep("The Element specified by the"+Id+"not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("theElement specified by the"+Id+"is in invalid state");
			reportStep("theElement specified by the"+Id+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	
		}

	
	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("The element specified with"  +xpathVal+"is clicked successfully");
			reportStep("The element specified with"  +xpathVal+"is clicked successfully", "pass");
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+xpathVal+" was not found");
			reportStep("The Element specified with "+xpathVal+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+xpathVal+" was not visible");
			reportStep("The Element specified with "+xpathVal+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with"+xpathVal+"is in invalid state");
			reportStep("The Element specified with"+xpathVal+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}{
			takeSnap();
		}
	}
	
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			//System.out.println("Browser got closed");
			reportStep("Browser got closed", "pass");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Browser got closed because of unknown error");
			reportStep("The Browser got closed because of unknown error", "fail");
		} {
			takeSnap();
		}

}}
