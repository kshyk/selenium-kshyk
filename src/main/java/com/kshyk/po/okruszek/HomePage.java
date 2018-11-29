package com.kshyk.po.okruszek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class HomePage {
	
	private final WebDriver driver;
	private final BasePage basePage;
	@FindBy(css = ".click-crumb")
	private WebElement crumb;
	
	
	public HomePage(final WebDriver driver) {
		this.basePage = new BasePage(driver);
		this.driver = driver;
	}
	
	public final HomePage goToOkruszek() {
		this.driver.get("http://www.okruszek.org.pl/");
		return this;
	}
	
	public final void clickOnCrumb() {
		this.basePage.mouseOverAndClick(this.crumb);
	}
}