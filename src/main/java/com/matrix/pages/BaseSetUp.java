package com.matrix.pages;

import static com.matrix.pages.BaseSetUp.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.matrix.common.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetUp extends ActionMethod implements TimeOuts {

	public static WebDriver driver = null;
	public static Properties prop;
	public static ExtentTest test;
	public static ExtentReports extent;

	public WebDriver getDriver() {
		return driver;
	}

	public BaseSetUp() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\ws\\Matrix\\Matrix\\Matrix\\ConfigFiles\\Sys.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite()
	public void beforeSuite() {

		try {
			String browserName = prop.getProperty("browser");

			if (browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserName.equals("FF")) {
				// System.setProperty("webdriver.gecko.driver",
				// "D:\\work\\esignlyNew\\geckodriver.exe");
				WebDriverManager.firefoxdriver().setup();
				// driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			String Uname = "matrix_dev";
			String Password1 = "matrix_dev_2020";

			String url = "https://" + Uname + ":" + Password1 + "@" + "dev.matrics.agile451.net/"; 
			driver.get(url);

		} catch (Exception e) {

		}

	}

	@BeforeClass
	public static void startTest() {
		extent = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		test = extent.startTest("Demo");
	}

	/*
	 * Below method will kill driver
	 */
	@AfterClass()
	public void endTest() {
		extent.endTest(test);
		extent.flush();
	}

//	@AfterClass
//	public static void endTest()
//	{
//	report.endTest(test);
//	report.flush();
//	}

	@AfterSuite(alwaysRun = true)
	public void afterTestSuite() {
		BaseSetUp.driver.quit();
	}
}
