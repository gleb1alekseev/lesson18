package tests;

import constants.IPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class ProductTests extends BaseTest{
    //loginPage.openPage()
    //loginPage.login(username, password)
    //productPage.addToCart("Product Name")
    //cartPage.openPage()
    //cartPage.getQuantity("Product Name")
    //cartPage.getPrice("Product Name")
    //Assertions

    @Test(description = "QA-6 Test to check the SAUCE_LABS_BACKPACK product is shown on the PRODUCTS_PAGE_URL page")
    public void findBackpackProduct(){
        loginPage.openPage(IPageConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productPage.openPage(IPageConstants.PRODUCTS_PAGE_URL);
        Assert.assertEquals(SAUCE_LABS_BACKPACK, productPage.getProductText(ProductPage.PRODUCT1));
    }

    @Test(description = "QA-7 Test to check that all products are shown on the PRODUCTS_PAGE_URL page")
    public void findAllProductsOnPage(){
        loginPage.openPage(IPageConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productPage.openPage(IPageConstants.PRODUCTS_PAGE_URL);
        Assert.assertEquals(SAUCE_LABS_BACKPACK, productPage.getProductText(ProductPage.PRODUCT1));
        Assert.assertEquals(SAUCE_LABS_BIKE_LIGHT, productPage.getProductText(ProductPage.PRODUCT2));
        Assert.assertEquals(SAUCE_LABS_BOLT_T_SHIRT, productPage.getProductText(ProductPage.PRODUCT3));
        Assert.assertEquals(SAUCE_LABS_FLEECE_JACKET, productPage.getProductText(ProductPage.PRODUCT4));
        Assert.assertEquals(SAUCE_LABS_ONESIE, productPage.getProductText(ProductPage.PRODUCT5));
        Assert.assertEquals(TEST_ALL_THE_THINGS_T_SHIRT_RED, productPage.getProductText(ProductPage.PRODUCT6));
    }

    @Test(description = "QA-8 Test to check the SAUCE_LABS_BACKPACK product is added to cart")
    public void checkAddedProductInCart(){
        loginPage.openPage(IPageConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productPage.openPage(IPageConstants.PRODUCTS_PAGE_URL);
        productPage.getProductText(ProductPage.PRODUCT1);
        productPage.addToCart(ProductPage.ADD_TO_CART_1);
        cartPage.openPage(IPageConstants.CART_PAGE_URL);
        Assert.assertEquals(SAUCE_LABS_BACKPACK, productPage.getProductText(ProductPage.PRODUCT1));
    }
}
