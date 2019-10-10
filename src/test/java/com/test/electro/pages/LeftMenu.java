package com.test.electro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftMenu extends PageObject {

    @FindBy(xpath = "//ul[@data-autotest-id='subItems']/li")
    public List<WebElement> leftMenu;

    public LeftMenu(WebDriver driver) {
        super(driver);
    }

    public void clickCategoryBy(String name)
    {
        leftMenu.stream().filter(t -> t.getText().equals(name)).findFirst().get().click();
    }
}
