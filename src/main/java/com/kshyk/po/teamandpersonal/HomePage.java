package com.kshyk.po.teamandpersonal;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

// TODO: 07.03.19 - extract all the same fields, methods, etc. to AbstractPage
public class HomePage {
	
	private final BasePage basePage;
	private final WebDriver driver;
	@FindBy(css = ".site-content")
	private WebElement siteContent;
	
	public HomePage(final WebDriver driver) {
		this.basePage = new BasePage(driver);
		this.driver = driver;
	}
	
	public final void open() {
		this.driver.get("https://teamandpersonal.pl/");
	}
	
	public WebElement getSiteContent() {
		return this.siteContent;
	}
	
	public final void waitForHomePage() {
		this.basePage.getWaitShort()
				.until(visibilityOf(this.siteContent));
	}
}
