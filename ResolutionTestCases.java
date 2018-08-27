package testing;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ResolutionTestCases extends SuiteClass {
	
	
	@DataProvider
	public Object[][] dimensions()
	{
     return new Object[][] {{320, 480},{360,544},{480, 800},{600,800},{768, 1024},{1024,768},{1366,768}};
	}
	
	@Test(dataProvider = "dimensions")
	public void resolutionTest(int a, int b)
	{
		Dimension dimen = new Dimension(a,b);
		driver.manage().window().setSize(dimen);
		
		String location = "D:\\Apurva\\KSSResolution\\images\\";
		
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	    try {
			ImageIO.write(fpScreenshot.getImage(),"PNG",new File(location +time+"\\"+a+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		
	}
	
	

}
