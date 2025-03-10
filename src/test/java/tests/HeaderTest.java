package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

    @Test(description = "QA-9 Test log out from product page")
    public void logoutFromProductPage(){
        headerSteps.logoutFromProductPage(ITestConstants.USERNAME, ITestConstants.PASSWORD);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL + "/");
    }
}