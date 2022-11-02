package sdet;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

public class DownloadFile_FireFoxBrowser {
	
	@Test(enabled=true)
	public void login() throws FindFailed, Exception{
		
		FirefoxProfile profile=new FirefoxProfile();
		
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",   "text/plain,application/pdf"); //Set Mime type of File
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		
		//Download files in desired location
		profile.setPreference("browser.download.dir", System.getProperty("user.dir")+".\\FileFolder");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("pdfjs.disabled", true); //Only for PDF File
		
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
		
		 
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver(option);
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//download Text File
		driver.findElement(By.id("textbox")).sendKeys("This is dummy Test data for Text file");
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
		
		IsFileExist(System.getProperty("user.dir")+".\\FileFolder"); //Verify Folder, File Exist or not
		
		Thread.sleep(2000);
		
		//download PDF file
		driver.findElement(By.id("pdfbox")).sendKeys("This is dummy Test data for Text file");
		driver.findElement(By.id("createPdf")).click();
		driver.findElement(By.id("pdf-link-to-download")).click();	
		
		IsFileExist(System.getProperty("user.dir")+".\\FileFolder"); //verify folder File is available or not
		
	}
	
	boolean IsFileExist(String path){
		File f=new File(path);
		
		if(f.exists()){
			return true;
		}
		else{
			return false;
		}
	}

}
