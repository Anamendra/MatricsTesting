package com.matrix.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage  extends BaseSetUp{

	LoginPage login = new LoginPage();
	DashboardPage dashboard = new DashboardPage();

	// Page factory
	@FindBy(xpath = "//span[contains(text(),'Task')]")
	private WebElement taskTitle;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	private WebElement addTaskBtn;
	
	@FindBy(xpath = "//input[@id='edit-title-0-value']")
	private WebElement addTaskTitleTextField;
	
	@FindBy(xpath = "//input[@id='edit-field-date-0-value-date']")
	private WebElement addTaskDateAdded;
	
	@FindBy(xpath = "//input[@id='edit-field-date-required-0-value-date']")
	private WebElement addTaskDateRequired;
	
	@FindBy(xpath = "//input[@id='edit-field-assigned-to-0-target-id']")
	private WebElement addTaskAssignedTo;
	
	@FindBy(xpath = "//input[@id='edit-submit']")
	private WebElement addTaskSaveBtn;
	
	// Intialize page factory
		public TaskPage() {
			PageFactory.initElements(driver, this);
		}

		// To check the verify tasks page title
		public boolean isTaskPageTitlePresent() throws InterruptedException {
			login.validUserCredentials();
			dashboard.clickOnTasks();
			needToWait(3);
			return taskTitle.isDisplayed();
		}
		
		// To check the verify add task
			public void addTask() throws InterruptedException {
					login.validUserCredentials();
					dashboard.clickOnTasks();
					needToWait(3);
					addTaskBtn.click();
					needToWait(3);
				}
}
