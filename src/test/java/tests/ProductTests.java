package tests;

import constants.IPageConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductTests extends BaseTest {
    //loginPage.openPage()
    //loginPage.login(username, password)
    //productPage.addToCart("Product Name")
    //cartPage.openPage()
    //cartPage.getQuantity("Product Name")
    //cartPage.getPrice("Product Name")
    //Assertions

    @Test(description = "QA-6 Test to check the SAUCE_LABS_BACKPACK product is shown on the PRODUCTS_PAGE_URL page")
    public void findBackpackProduct() {
        loginPage.openPage(IPageConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productPage.openPage(IPageConstants.PRODUCTS_PAGE_URL);
        Assert.assertEquals(SAUCE_LABS_BACKPACK, productPage.getProductText(SAUCE_LABS_BACKPACK));
    }

    @Test(description = "QA-7 Test to check that all products are shown on the PRODUCTS_PAGE_URL page")
    public void findAllProductsOnPage() {
        loginPage.openPage(IPageConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productPage.openPage(IPageConstants.PRODUCTS_PAGE_URL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productPage.getProductText(ITestConstants.SAUCE_LABS_BACKPACK), ITestConstants.SAUCE_LABS_BACKPACK);
        softAssert.assertEquals(productPage.getProductText(ITestConstants.SAUCE_LABS_BIKE_LIGHT), ITestConstants.SAUCE_LABS_BIKE_LIGHT);
        softAssert.assertEquals(productPage.getProductText(ITestConstants.SAUCE_LABS_BOLT_T_SHIRT), ITestConstants.SAUCE_LABS_BOLT_T_SHIRT);
        softAssert.assertEquals(productPage.getProductText(ITestConstants.SAUCE_LABS_FLEECE_JACKET), ITestConstants.SAUCE_LABS_FLEECE_JACKET);
        softAssert.assertEquals(productPage.getProductText(ITestConstants.SAUCE_LABS_ONESIE), ITestConstants.SAUCE_LABS_ONESIE);
        softAssert.assertEquals(productPage.getProductText(ITestConstants.TEST_ALL_THE_THINGS_T_SHIRT_RED), ITestConstants.TEST_ALL_THE_THINGS_T_SHIRT_RED);
        softAssert.assertAll();
    }

    @Test(description = "QA-8 Test to check the SAUCE_LABS_BACKPACK product is added to cart")
    public void checkAddedProductInCart() {
        loginPage.openPage(IPageConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productPage.openPage(IPageConstants.PRODUCTS_PAGE_URL);
        productPage.getProductText(SAUCE_LABS_BACKPACK);
        productPage.addProductToCart(SAUCE_LABS_BACKPACK);
        cartPage.openPage(IPageConstants.CART_PAGE_URL);
        Assert.assertEquals(SAUCE_LABS_BACKPACK, productPage.getProductText(SAUCE_LABS_BACKPACK));
    }
}
