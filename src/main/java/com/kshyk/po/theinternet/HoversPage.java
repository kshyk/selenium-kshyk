package com.kshyk.po.theinternet;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoversPage extends BasePage {

    @FindBy(xpath = "//*[text()='Hovers']")
    private WebElement title;

    @FindBy(css = ".figcaption h5")
    private List<WebElement> names;

    @FindBy(css = ".figure img")
    private List<WebElement> avatars;

    public HoversPage(final WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAvatars() {
        return avatars;
    }

    public <T> void mouseOverAvatar(final T avatar) {
        mouseOver(avatar);
    }

    public String getVisibleName() {
        return names.stream().filter(WebElement::isDisplayed).findFirst().get().getText();
    }

    public boolean isOpen() {
        return this.title.isDisplayed();
    }
}