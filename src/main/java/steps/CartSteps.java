package steps;

import constant.IConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductsPage;

import static constant.IConstants.CART_PAGE_URL;

@Log4j2
public class CartSteps {
    private CartPage cartPage;
    private ProductsPage productsPage;

    public CartSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Add product to cart by productName")
    public CartSteps addProductToCartByName(String productName, String price){
        productsPage.openPage(IConstants.PRODUCTS_PAGE_URL);
        productsPage.addProductToCart(productName);
        cartPage.openPage(CART_PAGE_URL);
        log.info("Cart page is opened " + CART_PAGE_URL);
        return this;
    }

    @Step("Check quantity on the cart page")
    public void checkQuantity() {
        cartPage.openPage(CART_PAGE_URL);
        log.info("Cart page is opened " + CART_PAGE_URL);
    }

    @Step("Remove product from cart page")
    public void removeItemFromCart(String productName) {
        cartPage.openCartPage(CART_PAGE_URL);
        log.info("Cart page is opened " + CART_PAGE_URL);
        cartPage.removeProductFromCart(productName);
        log.info(productName + " was removed");
    }
}
