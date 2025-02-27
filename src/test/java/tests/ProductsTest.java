package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends Preconditions {
    //loginPage.openPage()
    //loginPage.login(username, password)
    //productPage.addToCart("Product Name")
    //cartPage.openPage()
    //cartPage.getQuantity("Product Name")
    //cartPage.getPrice("Product Name")
    //Assertions

    @Test(description = "QA-6 Test to check the SAUCE_LABS_BACKPACK product is shown on the PRODUCTS_PAGE_URL page")
    public void findBackpackProduct() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        loginPage
                .waitForPageOpened()
                .login(userIncorrectFields);
        productsPage.openPage(IConstants.PRODUCTS_PAGE_URL);
        String expectedResult = "Sauce Labs Bike Light";
        Assert.assertEquals(SAUCE_LABS_BIKE_LIGHT, expectedResult);
    }

    @Test(description = "QA-8 Test to check the SAUCE_LABS_BACKPACK product is added to cart")
    public void checkAddedProductInCart() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        loginPage
                .waitForPageOpened()
                .login(userIncorrectFields);
        productsPage.openPage(IConstants.PRODUCTS_PAGE_URL);
        productsPage.getProductText(SAUCE_LABS_BACKPACK);
        productsPage.addProductToCart(SAUCE_LABS_BACKPACK);
        cartPage.openPage(IConstants.CART_PAGE_URL);
        String expectedResult = "Sauce Labs Backpack";
        Assert.assertEquals(SAUCE_LABS_BACKPACK, expectedResult);
    }

    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userSuccess);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
        productSteps.loginAndAddProductToCart(userSuccess, SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }
}

