package reusableComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reusable_Methods {

	public static WebDriver driver;
	public static Alert alt;
	public static JavascriptExecutor js ;

	public static void launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void launchUrl(String url) {

		driver.get(url);
	}

	public static void maximizeWindow() {

		driver.manage().window().maximize();
	}

	public static void implicitWait(int timeInSeconds) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
	}

	public static void passValue(WebElement elementRef, String value) {
		elementRef.sendKeys(value);
	}

	public static void passValue(WebElement elementRef, double value) {
		
		Double upcasted = value;
		String input = upcasted.toString();
		elementRef.sendKeys(input);
	}

	public static void clickButton(WebElement elementRef) {
		elementRef.click();
	}

	
	public static String fetchBackText(WebElement elementRef) {
		return elementRef.getText();

	}
	
	public static void acceptAlert() {
		driver.switchTo().alert();
		alt.accept();
	}
	
	public static void dismissAlert() {
		driver.switchTo().alert();
		alt.dismiss();

	}
	
	public static String fetchBackAttributeValue(WebElement elementRef, String AttributeName) {
		return elementRef.getAttribute(AttributeName);

	}
	
	
	public static void scrollDown(WebElement elementRef) {
		 js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", elementRef);

	}
	
	
	
	

	public static String readProperty(String fileName, String propertyName) throws IOException {

		FileInputStream f = new FileInputStream("C:\\Users\\kavin\\eclipse-workspace\\SampleId\\src\\test\\resources\\Config Files\\" + fileName + ".properties");
		Properties prop = new Properties();
		prop.load(f);
		return prop.getProperty(propertyName);
	
	}
	
}
