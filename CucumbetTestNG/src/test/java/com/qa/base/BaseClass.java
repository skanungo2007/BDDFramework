package com.qa.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.HelperClass;


public class BaseClass {
	
	
	protected static WebDriver driver;
	
	
	public static void initialize() throws IOException {
		
		
		if(HelperClass.readProperty("browser").equalsIgnoreCase("chrome")) {
			
			String driverPath = "D:\\AutomationProject\\Drivers\\chromedriver.exe";
			
			System.setProperty("webdriver.chrome.driver", driverPath);
			
			driver = new ChromeDriver();
		
			
		} else if(HelperClass.readProperty("browser").equalsIgnoreCase("edge")) {
			
			String driverPath = "D:\\AutomationProject\\Drivers\\msedgdriver.exe";
			
			System.setProperty("webdriver.edge.driver", driverPath);
			
			driver = new EdgeDriver();
			
			
		} else {
			
			String driverPath = "D:\\AutomationProject\\Drivers\\geckodriver.exe";
			
			System.setProperty("webdriver.gecko.driver", driverPath);
			
			driver = new FirefoxDriver();
						
			
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get(HelperClass.readProperty("url"));
	
		
		
	}

	
	public static void closeBrowser() {
		
		System.out.println("Closing browser");
		driver.quit();
	}
}
