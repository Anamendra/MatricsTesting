package com.matrix.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseSetUp {

	// Page factory
		@FindBy(id = "edit-name")
		WebElement username;

		@FindBy(id = "edit-pass")
		WebElement password;

		@FindBy(id = "edit-submit")
		WebElement loginBtn;

		@FindBy(xpath = "/html[1]/body[1]/section[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/label[1]/span[1]")
		WebElement rememberMeCheckbox;
		
		@FindBy(xpath = "//a[text()='Contact Us']")
		WebElement contactUs;
		
		@FindBy(xpath = "//a[text()='Back To login page']")
		WebElement backToLogin;
		
		@FindBy(xpath = "//a[text()='Forgot Password?']")
		WebElement forgetPass;
		
		@FindBy(xpath = "//input[@id='edit-name']")
		WebElement inputForResetPass;
		
		@FindBy(id = "edit-submit")
		WebElement forgotSubmitButton;
		
		
		@FindBy(xpath = "//h2[text()='Status message']")
		WebElement resetPassSentMSg;
		
		// Intialize page factory
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}

		// Actions
		public void validUserCredentials() throws InterruptedException {
			needToImplicitWait(2);
			username.sendKeys(prop.getProperty("username"));
			password.sendKeys(prop.getProperty("password"));
			// needToImplicitWait(5);
			loginBtn.click();
			needToImplicitWait(5);
		}

		public void invalidUserCredentials() throws InterruptedException {
			needToImplicitWait(2);
			username.sendKeys(prop.getProperty("invalidUser"));
			password.sendKeys(prop.getProperty("invalidPass"));
			loginBtn.click();
			needToImplicitWait(3);
		}

		public void validUserNameWithoutPassword() throws InterruptedException {
			needToImplicitWait(2);
			username.sendKeys(prop.getProperty("username"));
			loginBtn.click();
			needToImplicitWait(2);
		}

		public void validUserPasswordOnly() throws InterruptedException {
			needToImplicitWait(2);
			password.sendKeys(prop.getProperty("password"));
			loginBtn.click();
			needToImplicitWait(2);
		}

		public void withoutAnyInput() throws InterruptedException {
			needToImplicitWait(2);
			loginBtn.click();
			needToImplicitWait(5);
		}

	    public void clickOnContactUs() throws InterruptedException {
			needToImplicitWait(2);
			contactUs.click();
			needToImplicitWait(5);
		}

		public void clickOnBackToLogin() throws InterruptedException {
			needToImplicitWait(2);
			backToLogin.click();
			needToImplicitWait(5);
		}

		
		public void clickOnForgotPassLink() throws InterruptedException {
			needToImplicitWait(2);
			forgetPass.click();
			inputForResetPass.sendKeys("MatTest@mailinator.com");
			forgotSubmitButton.click();
			needToImplicitWait(5);
		
		}
		
//		 This function is used for Verify the presence of ResetPassSentMSg 

		public boolean isResetPassSentMSgPresent() {
			return resetPassSentMSg.isDisplayed();
		}


}
