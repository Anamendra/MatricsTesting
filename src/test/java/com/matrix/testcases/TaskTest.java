package com.matrix.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.matrix.pages.DashboardPage;
import com.matrix.pages.TaskPage;
import com.relevantcodes.extentreports.LogStatus;

public class TaskTest extends TaskPage{

	TaskPage taskPage;

	public TaskTest() {
		super(); // Need to create constructor to initialize properties file
	}

	@Test(priority = 1)
	public void tc_tasks_001_checkTasksUrl() {
		taskPage = new TaskPage();

		try {
			Assert.assertTrue(taskPage.isTaskPageTitlePresent());

			if (driver.findElement(By.xpath("//span[contains(text(),'Task')]")) != null) {
				test.log(LogStatus.PASS, "Test isTasksTitlePresent Passed");
			} else {
				test.log(LogStatus.FAIL, "Test isTasksTitlePresent Failed");
			}
		} catch (InterruptedException e) {
			test.log(LogStatus.SKIP, "Test isTasksTitlePresent Skipped");
			e.printStackTrace();
		}
	}

}
