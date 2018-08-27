package testing;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteClass {

	public static WebDriver driver ;
	public static WebDriverWait wait;
	public static  String time;
	
	public void folder()
	{
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
		time = dateFormat.format(now);
		File dir  = new File("D:\\Apurva\\KSSResolution\\images\\" + time);
		dir.mkdir();
	}
	
	@BeforeSuite
	public void beforesuite()
	{
		//ChromeDriver
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		// List Screen
		driver.get("https://jeromie.github.io/kss/list/");
		
		if(new File("D:\\Apurva\\KSSResolution\\images").exists())
		{    	folder();
		}
		
		else
		{
			new File("D:\\Apurva\\KSSResolution\\images").mkdir();
			folder();
		}
		
		
		 
		    
		    
		    
		    
		    
		    
		    
	}
	
	@AfterSuite
	public void aftersuite()
	{
		driver.close();
	}
	
}
