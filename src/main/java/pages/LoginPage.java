package pages;

import entity.User;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The type Login page.
 */
@Log4j2
public class LoginPage extends BasePage {
    /**
     * The constant USERNAME_INPUT.
     */
    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    /**
     * The constant PASSWORD_INPUT.
     */
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    /**
     * The constant LOGIN_BUTTON.
     */
    public static final By LOGIN_BUTTON = By.id("login-button");
    /**
     * The constant ERROR_MESSAGE.
     */
    public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");
    /**
     * The constant EMPTY_FIELD_USERNAME_ERROR.
     */
    public static final String EMPTY_FIELD_USERNAME_ERROR = "Epic sadface: Username is required";
    /**
     * The constant EMPTY_FIELD_PASSWORD_ERROR.
     */
    public static final String EMPTY_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    /**
     * The constant INCORRECT_DATA_IN_FIELDS.
     */
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    /**
     * Instantiates a new Login page.
     *
     * @param driver the driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Login products page.
     *
     * @param user the user
     * @return the products page
     */
    public ProductsPage login(User user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user.getUsername());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        log.info(String.format("User Registered with data: username is %s", user.getUsername()));
        return new ProductsPage(driver);
    }

    /**
     * Login products page.
     *
     * @param username the username
     * @param password the password
     * @return the products page
     */
    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    /**
     * Gets error message text.
     *
     * @return the error message text
     */
    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    /**
     * Wait for page opened login page.
     *
     * @return the login page
     */
    public LoginPage waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }
}
