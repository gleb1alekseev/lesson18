package steps;

import constant.IConstants;
import entity.User;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

@Log4j2
public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    @Step("Login and wait for page opened")
    public LoginSteps loginAndWaitForPageOpened(String username, String password){
        log.info("Open login page: " + IConstants.LOGIN_PAGE_URL);
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        log.info("Log In with username: " + username);
        loginPage
                .waitForPageOpened()
                .login(username, password);
        return this;
    }

    @Step("Login and wait for page opened")
    public LoginSteps loginAndWaitForPageOpened(User user){
        log.info("Open login page: " + IConstants.LOGIN_PAGE_URL);
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        log.info("Log In in with user: " + user.getUsername());
        loginPage
                .waitForPageOpened()
                .login(user);
        return this;
    }
}
