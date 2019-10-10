package com.test.electro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopBar extends PageObject {

    @FindBy(xpath = "//input[@id='header-search']")
    public WebElement inputField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findBtn;

    @FindBy(xpath = "//div[contains(@class,'n-w-tab n-w-tab_type_navigation-menu')]")
    public List<WebElement> horizontalMenu;

    public TopBar(WebDriver driver) {
        super(driver);
    }

    public void clickCategoryBy(String name)
    {
        horizontalMenu.stream().filter(t -> t.getText().equals(name)).findFirst().get().click();
    }

    public void searchBy(String text)
    {
        inputField.sendKeys(text);
        findBtn.click();
    }
}
