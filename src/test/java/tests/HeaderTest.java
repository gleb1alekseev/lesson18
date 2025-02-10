package tests;

import constants.IPageConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

    @Test(description = "QA-9 Test log out from product page")
    public void logoutFromProductPage(){
        loginPage.openPage(IPageConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productPage.openPage(IPageConstants.PRODUCTS_PAGE_URL);
        headerPage.selectDropdownMenu();
        headerPage.logOut();
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL + "/");
    }
}
