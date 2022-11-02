package sdet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class UploadFile {
	
	@Test(enabled=true)
	public void login() throws FindFailed, Exception{
		
		Screen screen=new Screen();
		
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		
		Pattern image1=new Pattern(System.getProperty("user.dir")+"\\SikuliImage\\UploadFile\\ChooseFile.PNG");
		Pattern image2=new Pattern(System.getProperty("user.dir")+"\\SikuliImage\\UploadFile\\FileName.PNG");
		Pattern image3=new Pattern(System.getProperty("user.dir")+"\\SikuliImage\\UploadFile\\OpenButton.PNG");
		
		screen.wait(image1, 10);
		
		Thread.sleep(3000);
		
		screen.click(image1);
		screen.type(image2, System.getProperty("user.dir")+"\\SikuliImage\\UploadFile\\PDFRead.txt");
		screen.click(image3);
		
		
	}

}
