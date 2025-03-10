package steps;

import entity.User;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static constant.IConstants.LOGIN_PAGE_URL;

@Log4j2
public class ProductSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Login and add product to cart")
    public ProductSteps loginAndAddProductToCart(String username, String password, String productName) {
        log.info("Open login page: " + LOGIN_PAGE_URL);
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(username, password);
        log.info("Add product to cart: " + productName);
        productsPage.addProductToCart(productName);
        return this;
    }

    @Step("Login and add product to cart")
    public ProductSteps loginAndAddProductToCart(User user, String productName) {
        log.info("Open login page: " + LOGIN_PAGE_URL);
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(user);
        log.info("Add product to cart: " + productName);
        productsPage.addProductToCart(productName);
        return this;
    }
}