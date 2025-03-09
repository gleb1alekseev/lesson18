package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest extends Preconditions{
    @DataProvider(name = "products")
    public Object[][] productsAndPrices() {
        return new Object[][] {
                {SAUCE_LABS_BACKPACK, "$29.99"},
                {SAUCE_LABS_BOLT_T_SHIRT, "$15.99"},
                {SAUCE_LABS_BIKE_LIGHT, "$9.99"},
                {SAUCE_LABS_FLEECE_JACKET, "$49.99"},
                {SAUCE_LABS_ONESIE, "$7.99"},
                {TEST_ALL_THE_THINGS_T_SHIRT_RED, "$15.99"},
        };
    }

    @Test(dataProvider = "products")
    public void addProductToCartTest(String productName, String price){
        loginSteps.loginAndWaitForPageOpened(ITestConstants.USERNAME, ITestConstants.PASSWORD);
        cartSteps.addProductToCartByName(productName, price);
        Assert.assertEquals(cartPage.getProductPrice(productName), price);
    }

    @Test(retryAnalyzer = Retry.class)
    public void checkQuantityTest() {
        productSteps.loginAndAddProductToCart(userSuccess, SAUCE_LABS_BOLT_T_SHIRT);
        cartSteps.checkQuantity();
        Assert.assertEquals(cartPage.getProductQuantity(), 2);
    }

    @Test
    public void removeItemFromCartTest() {
        productSteps.loginAndAddProductToCart(userSuccess, SAUCE_LABS_BOLT_T_SHIRT);
        cartSteps.removeItemFromCart(SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertFalse(cartPage.isProductDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }
}
