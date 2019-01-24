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
	WebDriver driver = null;

	@BeforeMethod
	public void setUp() {
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
				throw new Exception("undefined os type detected");
			}
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testcase01() {

		try {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://localhost:8080/CodeLabsDemo/");
			driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
			driver.findElement(By.xpath("//input[@id='UserRegistrationName']")).sendKeys("John Doe");

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}

	}

}
