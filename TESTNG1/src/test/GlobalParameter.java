package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GlobalParameter {

	public WebDriver driver=null;
	
	
	

	@Test
	public void Login() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\vivek\\eclipse-workspace\\TestNG1\\src\\datadriven.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("username"));
		
		if(prop.getProperty("browser").equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vivek\\Documents\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if((prop.getProperty("browser")).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vivek\\Documents\\chromedriver_win32\\chromedriver.exe");

			 driver = new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\vivek\\Documents\\edgedriver_win64\\msedgedriver.exe");
			 driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void Software() {
		System.out.println("I m the Test");
		
	}
	
		
	
	

}

