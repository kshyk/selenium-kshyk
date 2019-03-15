package com.kshyk.po.neobux;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class LoginPage extends AbstractPage {
	
	@FindBy(css = "input[placeholder='Username']")
	private WebElement username;
	@FindBy(css = "input[placeholder='Password']")
	private WebElement password;
	@FindBy(id = "botao_login")
	private WebElement send;
	@FindBy(css = "input[id=Kf3]")
	private WebElement captcha;
	private String login, passwd = null;
	
	public LoginPage(final WebDriver driver) {
		super(driver);
	}
	
	public final LoginPage goToMemberLogin() {
		this.driver.get("https://www.neobux.com/m/l/");
		return this;
	}
	
	public final LoginPage fillCredentials() {
		if ((this.login == null) && this.passwd == null) {
			this.initCredentials();
		}
		this.basePage.writeText(this.username, this.login);
		this.basePage.writeText(this.password, this.passwd);
		return this;
	}
	
	public final void send() {
		this.basePage.click(this.send);
	}
	
	public final boolean isCaptchaVisible() {
		return this.captcha.isDisplayed();
	}
	
	public final WebElement getCaptcha() {
		return this.captcha;
	}
	
	private void initCredentials() {
		final var prop = new Properties();
		InputStream inStream = null;
		try {
			inStream = this.getClass().getClassLoader().getResourceAsStream("creds.properties");
			// load a properties file
			assert inStream != null;
			prop.load(inStream);
			// set credential fields
			this.login = prop.getProperty("username");
			this.passwd = prop.getProperty("password");
		}
		catch (final IOException ex) {
			this.basePage.getLogger().error("Cannot read creds.properties file.", ex);
		}
		finally {
			if (inStream != null) {
				try {
					inStream.close();
				}
				catch (final IOException ex) {
					this.basePage.getLogger().error("Cannot close input file stream of creds.properties file.", ex);
				}
			}
		}
	}
}
