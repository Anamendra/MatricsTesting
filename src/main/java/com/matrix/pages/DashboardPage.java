package com.matrix.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage extends BaseSetUp {

	LoginPage login = new LoginPage();

	// Page factory
	@FindBy(xpath = "//h1[contains(text(),'Your personalised dashboard')]")
	private WebElement dashboardTitle;

	@FindBy(xpath = "//a[contains(text(),'Training Matrix')]")
	private WebElement trainingMatrix;

	@FindBy(xpath = ".menu-item:nth-child(num)")
	private WebElement trainingManagementSideBar;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	private WebElement tasksSideBar;

	// Intialize page factory
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	// To check the verify dashboard title
	public boolean isDashboardTitlePresent() throws InterruptedException {
		login.validUserCredentials();
		needToWait(3);
		return dashboardTitle.isDisplayed();

	}

	public void clickTrainingMatrix() throws InterruptedException {

		trainingMatrix.click();
		needToWait(3);
	}

	public void clickOnSideBar(int num) throws InterruptedException {
		needToWait(3);
		driver.findElement(By.cssSelector(".menu-item:nth-child(num)".replace("num", num + ""))).click();
		needToWait(3);
	}
	
	public void clickOnTasks() throws InterruptedException {
//		login.validUserCredentials();    //This line is for running single testcase.
		tasksSideBar.click();
		needToWait(3);
	}


}
