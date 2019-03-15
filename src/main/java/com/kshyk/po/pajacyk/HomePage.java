package com.kshyk.po.pajacyk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class HomePage extends AbstractPage {
	
	@FindBy(className = "paj-click")
	private WebElement greenBellyBefore;
	@FindBy(className = "paj-click2")
	private WebElement yellowBellyHover;
	
	public HomePage(final WebDriver driver) {
		super(driver);
	}
	
	public final HomePage goToPajacyk() {
		this.driver.get("https://www.pajacyk.pl/#index");
		return this;
	}
	
	public final void clickOnBelly() {
		this.basePage.mouseOver(this.greenBellyBefore);
		this.basePage.click(this.yellowBellyHover);
	}
}
