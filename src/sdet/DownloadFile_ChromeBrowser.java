package sdet;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

public class DownloadFile_ChromeBrowser {
	
	@Test(enabled=true)
	public void login() throws FindFailed, Exception{
		
		//download files in required location using chrome
		
		HashMap<String, Object> chromePrefs=new HashMap<String, Object>();
		
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.prompt_for_download", "false");
		chromePrefs.put("download.default_directory", System.getProperty("user.dir")+".\\FileFolder"); //Configure path
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
        DesiredCapabilities cap=DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(cap);
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
