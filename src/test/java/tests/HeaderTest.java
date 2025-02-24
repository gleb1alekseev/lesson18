package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

    @Test(description = "QA-9 Test log out from product page")
    public void logoutFromProductPage(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openPage(IConstants.PRODUCTS_PAGE_URL);
        headerPage.selectDropdownMenu();
        headerPage.logOut();
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL + "/");
    }
}
