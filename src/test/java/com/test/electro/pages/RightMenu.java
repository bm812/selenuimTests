package com.test.electro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RightMenu extends PageObject {

    @FindBy(xpath = "//div[@data-zone-name='search-filters-aside']//input[@id='glpricefrom']")
    public WebElement priceMin;

    @FindBy(xpath = "//div[@data-zone-name='search-filters-aside']//input[@id='glpriceto']")
    public WebElement priceMax;

    @FindBy(xpath = "//div[@data-zone-name='search-filter']//fieldset[@data-autotest-id='7893318']//label/div")
    public List<WebElement> prodTypes;

    public RightMenu(WebDriver driver) {
        super(driver);
    }

    public void setMinPrice(String value)
    {
        priceMin.sendKeys(value);
    }

    public void setMaxPrice(String value)
    {
        priceMax.sendKeys(value);
    }

    public void selectProductTypes(List<String> products)
    {
        products.forEach(prod -> prodTypes.stream().filter(t -> t.getText().equals(prod)).findFirst().get().click());
    }
}
