package com.test.electro.tests;

import org.junit.Test;
import java.util.Arrays;

public class ElectronicaTests extends BasicTest {
    StepsForTests step = new StepsForTests();

    @Test
    public void test_1(){
        step.selectTopCategory("Электроника");
        step.selectLeftCategory("Смартфоны");
        step.setPrice("", "20000");
        step.setProductTypes(Arrays.asList("Apple", "Samsung"));
        step.checkNumberOfProducts(48);
        step.searchAndCheck();
    }

    @Test
    public void test_2(){
        step.selectTopCategory("Электроника");
        step.selectLeftCategory("Наушники и Bluetooth-гарнитуры");
        step.setPrice("5000", "");
        step.setProductTypes(Arrays.asList("Beats"));
        step.checkNumberOfProducts(48);
        step.searchAndCheck();
    }

    @Test
    public void test_3(){
//        step.selectTopCategory("Электроника");
//        step.selectLeftCategory("Смартфоны");
        step.sortByPriceAndCheck();
    }
}
