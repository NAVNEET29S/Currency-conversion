package Base;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class BasePage extends Base {
	
	public static void Screenshot(WebDriver driver) throws IOException
	{
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH mm ss");
    String date= dateFormat.format(new Date());
    String time = timeFormat.format(new Date());
     System.out.println("Date = "+ date +" time = "+ time);
	TakesScreenshot tkeSceen=(TakesScreenshot)driver;
	File scrFile =tkeSceen.getScreenshotAs(OutputType.FILE);
	File destFile = new File(System.getProperty("user.dir")+"//screenshot//"+date+"//"+time+".png");
	FileUtils.copyFile(scrFile, destFile);						
	}
	
}
	