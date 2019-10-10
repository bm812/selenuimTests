package com.test.electro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class Products extends PageObject {

    @FindBy(xpath = "//div[@data-id]//div[@class='n-snippet-cell2__title']")
    public List<WebElement> searchedProductsNames;

    @FindBy(xpath = "//div[@class='price']")
    public List<WebElement> searchedProductsPrice;

    @FindBy(xpath = "//a[contains(text(),'по цене')]/..")
    public WebElement sortByPrice;

    public Products(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfProducts()
    {
        return searchedProductsNames.size();
    }

    public String getNameOfProduct(int index)
    {
        return searchedProductsNames.get(index).getText();
    }

    public List<String> getPriceOfProducts()
    {
        return searchedProductsPrice.stream().map(t -> t.getText()
                .replace(" \u20BD", "")
                .replace(" ", ""))
                .collect(Collectors.toList());
    }

    public void sortByPrice()
    {
        sortByPrice.click();
    }
}
