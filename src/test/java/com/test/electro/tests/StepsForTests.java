package com.test.electro.tests;

import com.test.electro.pages.LeftMenu;
import com.test.electro.pages.Products;
import com.test.electro.pages.RightMenu;
import com.test.electro.pages.TopBar;

import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;

public class StepsForTests extends BasicTest {

    public void selectTopCategory(String value)
    {
        TopBar topBarPage = new TopBar(driver);
        topBarPage.clickCategoryBy(value);
    }

    public void selectLeftCategory(String value)
    {
        LeftMenu left = new LeftMenu(driver);
        left.clickCategoryBy(value);
    }

    public void setPrice(String min, String max)
    {
        RightMenu right = new RightMenu(driver);
        if(min != null && !min.isEmpty())
            right.setMinPrice(min);
        if(max != null && !max.isEmpty())
            right.setMaxPrice(max);
    }

    public void setProductTypes(List<String> productTypes)
    {
        RightMenu right = new RightMenu(driver);
        right.selectProductTypes(productTypes);
    }

    public void checkNumberOfProducts(int expected)
    {
        Products products = new Products(driver);
        int numProd = products.getNumberOfProducts();
        assertTrue(String.format("Number of products is %s. Actual is %s", expected, numProd), numProd == expected);
    }

    public void searchAndCheck()
    {
        Products products = new Products(driver);
        String firstProduct = products.getNameOfProduct(0);
        TopBar topBarPage = new TopBar(driver);
        topBarPage.searchBy(firstProduct);
        products = new Products(driver);
        String findProduct = products.getNameOfProduct(0);
        assertTrue("Found product name equals to search value", findProduct.equals(firstProduct));
    }

    public void sortByPriceAndCheck()
    {
        Products products = new Products(driver);
        products.sortByPrice();
        List<String> priceList = products.getPriceOfProducts();
        assertTrue("Products were sorted by price", isSorted(priceList));
    }

    private boolean isSorted(List<String> list)
    {
        List<Integer> listInt = list.stream().map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 0; i < listInt.size() - 1; i++)
        {
            if (listInt.get(i) > listInt.get(i+1))
                return false;
        }
        return true;
    }
}
