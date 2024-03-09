package org.test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Demo {
	 
	
	public  static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		//Launch URL
		driver.get("http://52.220.0.67");
		driver.manage().window().maximize();
		
		//Login
		WebElement userName =driver.findElement(By.xpath("//input[@name='txtMobile']"));
		userName.sendKeys("9876543210");
		WebElement passWord = driver.findElement(By.xpath("//input[@name='txtPassword']"));
		passWord.sendKeys("123456789");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(5000);
		
		//Accounts Tab
		WebElement accountsTab = driver.findElement(By.xpath("//div[text()='Accounts']"));
		accountsTab.click();
		Thread.sleep(2000);
		
		//Fetching Accounts Module Menu List
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",accountsTab );
		List<WebElement> accountsMenuItems = driver.findElements(By.xpath("(//ul[@class='menu-sub'])[13]"));
		WebElement accountsMenu;
		for (int i=0; i<accountsMenuItems.size();i++) {
			accountsMenu = accountsMenuItems.get(i);
			String menuList = accountsMenu.getText();
			if (menuList.isEmpty()) {
				System.out.println("Accounts Tab menu list is not displayed");
			}else {
				System.out.println("Accounts Tab Menus List :" + menuList +" is Displayed");
			}
			
		}
		
		//Paymnets Menu List Validation
		
		WebElement payments = driver.findElement(By.xpath("//div[text()='Payments']"));
		payments.click();
		Thread.sleep(2000);
		
		WebElement paymentNo = driver.findElement(By.xpath("//input[@id='txtPaymentCode']"));
		String paymentNumber = paymentNo.getAttribute("value");
		if (paymentNo.isDisplayed()) {
			System.out.println("Payment number is displayed as: " +paymentNumber);
		}else {
			System.out.println("Payment number is not dispalyed");
		}
		
		WebElement paymentDate = driver.findElement(By.xpath("(//div[@class='input-group'])[2]"));
		String date = paymentDate.getText();
		System.out.println("Payment date is displayed Today's Date as: " +date);
		
		WebElement paymentMethod= driver.findElement(By.xpath("(//span[@title='Select Payment Type'])[1]"));
		paymentMethod.click();
		List<WebElement> paymentMethodList = driver.findElements(By.xpath("//ul[@class='select2-results__options']"));
		WebElement paymentList;
		for (int i=0; i<paymentMethodList.size();i++) {
			paymentList = paymentMethodList.get(i);
			String listMethod = paymentList.getText();
			if (listMethod.isEmpty()) {
				System.out.println("Payment methods is not displayed");
			}else {
				System.out.println("Payment Methods is dispalyed as " +listMethod);
			}
		
	}
		
		WebElement generalExpenses = driver.findElement(By.xpath("//li[text()='General Expense']"));
		

}
}
