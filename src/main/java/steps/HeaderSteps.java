package steps;

import constant.IConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.HeaderPage;
import pages.LoginPage;
import pages.ProductsPage;

@Log4j2
public class HeaderSteps {
    private HeaderPage headerPage;
    private ProductsPage productsPage;

    public HeaderSteps(WebDriver driver) {
        headerPage = new HeaderPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Log out from product page")
    public HeaderSteps logoutFromProductPage(String username, String password) {
        productsPage.openPage(IConstants.PRODUCTS_PAGE_URL);
        headerPage
                .selectDropdownMenu()
                .logOut();
        log.info("LogOut from: " + IConstants.PRODUCTS_PAGE_URL + " page to " + IConstants.LOGIN_PAGE_URL + " page");
        return this;
    }
}