package com.matrix.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.matrix.pages.BaseSetUp;
import com.matrix.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends LoginPage {
	LoginPage loginPage;

	@Test(priority = 1)
	public void tc_001_withoutAnyInput() {
		loginPage = new LoginPage();
		try {
			loginPage.withoutAnyInput();
			if (driver.findElement(By.id("edit-submit")) != null) {
				test.log(LogStatus.PASS, "Test withoutAnyInput Passed");
			} else {
				test.log(LogStatus.FAIL, "Test withoutAnyInput failed");
			}

		} catch (InterruptedException e) {
			test.log(LogStatus.SKIP, "Test withoutAnyInput Skipped");
			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void tc_002_validUserNameOnly() {
		loginPage = new LoginPage();
		try {
			loginPage.validUserNameWithoutPassword();
			if (driver.findElement(By.id("edit-submit")) != null) {
				test.log(LogStatus.PASS, "Test validUserOnly Passed");
			} else {
				test.log(LogStatus.FAIL, "Test validUserOnly Failed");
			}

		} catch (InterruptedException e) {
			test.log(LogStatus.SKIP, "Test validUserOnly Skipped");
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void tc_004_invalidsUsernName() {
		loginPage = new LoginPage();
		try {
			loginPage.invalidUserCredentials();
			if (driver.findElement(By.id("edit-submit")) != null) {
				test.log(LogStatus.PASS, "Test invalidUserName Passed");
			} else {
				test.log(LogStatus.FAIL, "Test invalidUserName Failed");
			}
		} catch (InterruptedException e) {
			test.log(LogStatus.SKIP, "Test invalidUserName Skipped");
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void tc_003_validUserPasswordOnly() {
		loginPage = new LoginPage();
		try {
			loginPage.validUserPasswordOnly();
			if (driver.findElement(By.id("edit-submit")) != null) {
				test.log(LogStatus.PASS, "Test validUserPasswordOnly Passed");
			} else {
				test.log(LogStatus.FAIL, "Test validUserPasswordOnly Failed");
			}

		} catch (InterruptedException e) {
			test.log(LogStatus.SKIP, "Test validUserPasswordOnly Skipped");
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void tc_login_006_checkContactUsLink() {
		loginPage = new LoginPage();
		try {
			loginPage.clickOnContactUs();
			if (driver.findElement(By.xpath("//h1[text()='Contact us']")) != null) {
				loginPage.clickOnBackToLogin();
				test.log(LogStatus.PASS, "Test checkContactUsLink Passed");
			} else {
				test.log(LogStatus.FAIL, "Test checkContactUsLink Failed");
			}
		} catch (

		InterruptedException e) {
			test.log(LogStatus.SKIP, "Test checkContactUsLink Skipped");
			e.printStackTrace();
		}
	}

	@Test(priority = 6)
	public void tc_login_007_checkForgotPasswordLink() {
		loginPage = new LoginPage();
		try {
			loginPage.clickOnForgotPassLink();
			if (driver.findElement(By.xpath("//h2[text()='Status message']")) != null) {
				Assert.assertTrue(loginPage.isResetPassSentMSgPresent());
				test.log(LogStatus.PASS, "Test checkForgotPasswordLink Passed");
			} else {
				test.log(LogStatus.FAIL, "Test checkForgotPasswordLink Failed");
			}
		} catch (

		InterruptedException e) {
			test.log(LogStatus.SKIP, "Test checkForgotPasswordLink Skipped");
			e.printStackTrace();
		}
	}

	@Test(priority = 7)
	public void tc_005_validUserCredentials() {
		loginPage = new LoginPage();
		try {
			loginPage.validUserCredentials();
			if (driver.getCurrentUrl().contentEquals("https://testing.matrics.agile451.net/?check_logged_in=1")) {
				test.log(LogStatus.PASS, "Test validUserCredentials Passed");
			} else {
				test.log(LogStatus.FAIL, "Test validUserCredentials Failed");
			}
		} catch (InterruptedException e) {
			test.log(LogStatus.SKIP, "Test validUserCredentials Skipped");
			e.printStackTrace();
		}
	}


}
