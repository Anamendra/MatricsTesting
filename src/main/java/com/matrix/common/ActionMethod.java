package com.matrix.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class ActionMethod {

	protected WebDriver driver;

	public void needToWait(int waitInSec) {
		try {
			Thread.sleep(waitInSec * 1000);
		} catch (Exception e) {
		}
	}
	
	public void needToImplicitWait(int waitInSec) {
		try {
			driver.manage().timeouts().implicitlyWait(waitInSec * 1000, TimeUnit.SECONDS);
		} catch (Exception e) {
		}
	}

	public void pageLoad() {
		try {
			driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		} catch (Exception e) {

		}

	}

	public void implicitlyWait() {
		try {
			driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);

		} catch (Exception e) {

		}

	}

}
