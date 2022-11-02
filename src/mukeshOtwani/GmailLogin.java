package mukeshOtwani;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class GmailLogin {
	
	@Test(enabled=true)
	public void login() throws FindFailed, Exception{
		
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com/");
		
		//screen.wait(image1, 10);
		/*Pattern image1=new Pattern("C:\\Users\\vishalkumar\\Desktop\\SikuliImage\\UserNameHMS.PNG");
		Pattern image2=new Pattern("C:\\Users\\vishalkumar\\Desktop\\SikuliImage\\PasswordNameHMS.PNG");*/
		
		Screen screen=new Screen();
		Pattern image1=new Pattern(System.getProperty("user.dir")+"\\SikuliImage1\\SiginButton.PNG");
		
		
		Pattern image2=new Pattern(System.getProperty("user.dir")+"\\SikuliImage1\\UseName.PNG");
		Pattern image3=new Pattern(System.getProperty("user.dir")+"\\SikuliImage1\\Password.PNG");
		Pattern image4=new Pattern(System.getProperty("user.dir")+"\\SikuliImage1\\SignInButton.PNG");
		
		screen.wait(image1, 10);
		
		Thread.sleep(3000);
		screen.click(image1);
		screen.type(image2,"vishalkr.demo");
		screen.type(image3,"Test@123");
		screen.click(image4);
		
		//screen.wait(image2, 1000);
		
		
		
	}

}
