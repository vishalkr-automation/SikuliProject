package naveenAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class TestingFlashPlayer {
	
	@Test(enabled=true)
	public void login() throws FindFailed, Exception{
		
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/watch?v=OtQAMoXYqes");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		Screen screen=new Screen();
		Pattern pause=new Pattern(System.getProperty("user.dir")+"\\SikuliImage\\FlashPlayerYTB\\YT_Pause.PNG");
		Pattern play=new Pattern(System.getProperty("user.dir")+"\\SikuliImage\\FlashPlayerYTB\\YT_Play.PNG");
		Pattern setting=new Pattern(System.getProperty("user.dir")+"\\SikuliImage\\FlashPlayerYTB\\YT_Settings.PNG");
		Pattern autoSetting=new Pattern(System.getProperty("user.dir")+"\\SikuliImage\\FlashPlayerYTB\\YT_AutoSetting.png");
		
		//screen.wait(pause, 1000);
		
		//Thread.sleep(3000);
		
		
		//screen.wait(play, 1000);
		screen.click(play);
		System.out.println("Clicked on Play");
		
		//screen.wait(pause, 1000);
		screen.click(pause);
		System.out.println("Clicked on Pause");
		
		//screen.wait(play, 1000);
		screen.click(play);
		System.out.println("Clicked on Play");
		
		//screen.wait(setting, 1000);
		screen.click(setting);
		System.out.println("Clicked on Setting");
		
		//screen.wait(autoSetting, 1000);
		//screen.click(autoSetting);
		//System.out.println("Clicked on Auto Setting");
		
		
		
		
		
		
		
	}

}
