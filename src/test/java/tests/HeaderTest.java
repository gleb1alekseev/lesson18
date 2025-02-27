package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class HeaderTest extends BaseTest {

    @Test(description = "QA-9 Test log out from product page")
    public void logoutFromProductPage() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .openPage(IConstants.PRODUCTS_PAGE_URL);
        headerPage
                .selectDropdownMenu()
                .logOut();
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL + "/");
    }
}
