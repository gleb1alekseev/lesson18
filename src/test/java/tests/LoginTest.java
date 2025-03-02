package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class LoginTest extends Preconditions {
    public static final String EMPTY_FIELD_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMPTY_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    @Test(description = "QA-1 Test login on site with empty username field")
    public void loginAndWaitForPageOpened(){
        loginSteps.loginAndWaitForPageOpened(userEmptyFields);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "QA-2 Test login on site with empty password field")
    public void loginWithEmptyPasswordTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, "");
        loginPage
                .waitForPageOpened()
                .login(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "QA-3 Test login on site with empty username and password fields")
    public void loginWithEmptyFieldsTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login("", "");
        loginPage
                .waitForPageOpened()
                .login(userEmptyFields);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "QA-4 Test login on site with incorrect data in username and password fields")
    public void loginWithIncorrectUsernameTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login("sgffdg", "fdrdgf");
        loginPage
                .waitForPageOpened()
                .login(userIncorrectFields);
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_IN_FIELDS);
    }

    @Test(description = "QA-5 Test login on site with correct data in username and password fields")
    public void loginWithCorrectUsernameTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        loginPage
                .waitForPageOpened()
                .login(userIncorrectFields);
        Assert.assertEquals(driver.getCurrentUrl(), PRODUCTS_PAGE_URL);
    }

    @Test(description = "QA-5 Test login on site with correct data in username and password fields")
    public void successLogin(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(
                System.getProperty("username"),
                System.getProperty("password"));
        Assert.assertEquals(driver.getCurrentUrl(), PRODUCTS_PAGE_URL);
    }
}
