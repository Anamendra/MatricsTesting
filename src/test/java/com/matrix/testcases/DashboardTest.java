package com.matrix.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.matrix.pages.DashboardPage;
import com.matrix.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class DashboardTest extends DashboardPage {

	DashboardPage dashboardPage;

	public DashboardTest() {
		super(); // Need to create constructor to initialize properties file
	}

	@Test(priority = 1)
	public void tc_dash_001_verify_Dashboard_Heading() {
		dashboardPage = new DashboardPage();

		try {
			Assert.assertTrue(dashboardPage.isDashboardTitlePresent());

			if (driver.findElement(By.xpath("//h1[contains(text(),'Your personalised dashboard')]")) != null) {
				test.log(LogStatus.PASS, "Test isDashboardTitlePresent Passed");
			} else {
				test.log(LogStatus.FAIL, "Test isDashboardTitlePresent Failed");
			}
		} catch (InterruptedException e) {
			test.log(LogStatus.SKIP, "Test isDashboardTitlePresent Skipped");
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void tc_dash_002_click_On_Training_Matrix() {

		dashboardPage = new DashboardPage();

		try {
			dashboardPage.clickOnSideBar(2);
			if (driver.findElement(By.xpath("//a[contains(text(),'Training Matrix')]")) != null) {
				test.log(LogStatus.PASS, "Test clickTrainingMatrix Passed");
			} else {
				test.log(LogStatus.FAIL, "Test clickTrainingMatrix Failed");
			}
		} catch (InterruptedException e) {
			test.log(LogStatus.SKIP, "Test clickTrainingMatrix Skipped");
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void tc_dash_003_click_TrainingManagementSideBar() {
		dashboardPage = new DashboardPage();
		try {
			dashboardPage.clickOnSideBar(3);
			if (driver.findElement(By.xpath("//a[text()='Training Management']")) != null) {
				test.log(LogStatus.PASS, "Test TrainingManagementSideBar Passed");
			} else {
				test.log(LogStatus.FAIL, "Test TrainingManagementSideBar Failed");
			}
		} catch (InterruptedException e) {
			test.log(LogStatus.SKIP, "Test TrainingManagementSideBar Skipped");
			e.printStackTrace();
		}
	}
	@Test(priority = 4)
	public void tc_dash_004_click_TasksSideBar() {
		dashboardPage = new DashboardPage();
		try {
			dashboardPage.clickOnTasks();
			if (driver.findElement(By.xpath("//a[contains(text(),'Tasks')]")) != null) {
				test.log(LogStatus.PASS, "Test TasksSideBar Passed");
			} else {
				test.log(LogStatus.FAIL, "Test TasksSideBar Failed");
			}
		} catch (InterruptedException e) {
			test.log(LogStatus.SKIP, "Test TasksSideBar Skipped");
			e.printStackTrace();
		}
	}
}
