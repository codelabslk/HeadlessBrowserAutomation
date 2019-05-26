package com.codelabs.headlessautomation;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeadlessExecution {
	


	public WebDriver setUp() {
		try {
			String os = System.getProperty("os.name").toLowerCase();
			File file = null;

			if (os.indexOf("windows") >= 0) {
				file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator
						+ "chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			} else if (os.indexOf("mac") >= 0) {
				file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator
						+ "chromedriver_mac");
				Runtime.getRuntime().exec("chmod 777 " + file.getAbsolutePath());
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			} else {
				throw new Exception("undefined OS type detected");
			}
			
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			WebDriver driver = new ChromeDriver(options);
			return driver;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Test
	public void testcase01() {

		WebDriver driver = setUp();
		try {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://localhost:8080/CodeLabsDemo/");
			driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
			driver.findElement(By.xpath("//input[@id='UserRegistrationName']")).sendKeys("John Doe");
			tearDown(driver);
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	@Test
	public void testcase02() {

		try {

			WebDriver driver = setUp();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://localhost:8080/CodeLabsDemo/");
			driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
			driver.findElement(By.xpath("//input[@id='UserRegistrationName']")).sendKeys("John Doe");
			tearDown(driver);
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	@Test
	public void testcase03() {

		try {
			WebDriver driver = setUp();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://localhost:8080/CodeLabsDemo/");
			driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
			driver.findElement(By.xpath("//input[@id='UserRegistrationName']")).sendKeys("John Doe");
			tearDown(driver);
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	
	@Test
	public void testcase04() {

		try {
			WebDriver driver = setUp();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://localhost:8080/CodeLabsDemo/");
			driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
			driver.findElement(By.xpath("//input[@id='UserRegistrationName']")).sendKeys("John Doe");
			tearDown(driver);
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	@Test
	public void testcase05() {

		try {
			WebDriver driver = setUp();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://localhost:8080/CodeLabsDemo/");
			driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
			driver.findElement(By.xpath("//input[@id='UserRegistrationName']")).sendKeys("John Doe");
			tearDown(driver);
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	
	public void tearDown(WebDriver driver) {
		if (driver != null) {
			driver.close();
			driver.quit();
		}

	}

}
