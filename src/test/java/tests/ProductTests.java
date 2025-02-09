package tests;

import constants.IPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        WebElement productName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        Assert.assertEquals(SAUCE_LABS_BACKPACK, productName.getText());
    }

    @Test(description = "QA-7 Test to check that all products are shown on the PRODUCTS_PAGE_URL page")
    public void findAllProductsOnPage(){
        loginPage.openPage(IPageConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productPage.openPage(IPageConstants.PRODUCTS_PAGE_URL);
        WebElement productName1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        WebElement productName2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
        WebElement productName3 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        WebElement productName4 = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
        WebElement productName5 = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));
        WebElement productName6 = driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
        Assert.assertEquals(SAUCE_LABS_BACKPACK, productName1.getText());
        Assert.assertEquals(SAUCE_LABS_BIKE_LIGHT, productName2.getText());
        Assert.assertEquals(SAUCE_LABS_BOLT_T_SHIRT, productName3.getText());
        Assert.assertEquals(SAUCE_LABS_FLEECE_JACKET, productName4.getText());
        Assert.assertEquals(SAUCE_LABS_ONESIE, productName5.getText());
        Assert.assertEquals(TEST_ALL_THE_THINGS_T_SHIRT_RED, productName6.getText());
    }

    @Test(description = "QA-8 Test to check the SAUCE_LABS_BACKPACK product is added to cart")
    public void checkAddedProductInCart(){
        loginPage.openPage(IPageConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productPage.openPage(IPageConstants.PRODUCTS_PAGE_URL);
        productPage.addToCart();
        cartPage.openPage(IPageConstants.CART_PAGE_URL);
        WebElement productName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        Assert.assertEquals(SAUCE_LABS_BACKPACK, productName.getText());
    }
}
