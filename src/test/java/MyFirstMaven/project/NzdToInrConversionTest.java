package MyFirstMaven.project;

import org.testng.annotations.Test;

import Base.BasePage;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class NzdToInrConversionTest extends BasePage {
	@FindBy(xpath = "//form[@class='Form-s1g6mi0n-0 sc-bxivhb cpWItM']/div[2]/div")
	WebElement fromCountry;
	@FindBy(xpath = "//form[@class='Form-s1g6mi0n-0 sc-bxivhb cpWItM']/div[3]/div")
	WebElement toCountry;
	@FindBy(xpath = "//button[@class='Button-s1ikk70s-0 submitButton SubmitButton-s6euey0-0 fjRCyC']")
	WebElement btnSubmit;
	WebDriver driver;
	@Test
	public void calculateNzdToInrConversion() throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		String enter = Keys.chord(Keys.ENTER);
		driver.get("https://www.xe.com/currencyconverter/");
		Screenshot(driver);
	 	driver.findElement(By.xpath("//input[@id='from']")).sendKeys("nzd");
		action.sendKeys(enter).build().perform();
		driver.findElement(By.xpath("//input[@id='to']")).sendKeys("inr");
		action.sendKeys(enter).build().perform();
		btnSubmit.click();
		Screenshot(driver);
	String inrCurrenryValue =driver.findElement(By.className("converterresult-toAmount")).getText();
	System.out.println(inrCurrenryValue);
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C://TestCapability//TestAutomation//Tools//Drivers//ChromeDriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}

	@AfterTest
	public void afterTest() {
		 driver.close();
	}

}
