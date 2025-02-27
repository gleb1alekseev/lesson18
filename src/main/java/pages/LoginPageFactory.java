package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The type Login page factory.
 */
@Getter
public class LoginPageFactory extends BasePage {

    /**
     * The Username input.
     */
    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;

    /**
     * The Password input.
     */
    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;

    /**
     * The Login button.
     */
    @FindBy(id = "login-button")
    WebElement loginButton;

    /**
     * The Error message.
     */
    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMessage;

    /**
     * The Add button.
     */
    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addButton;

    /**
     * The Delete button.
     */
    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteButton;

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
     * Instantiates a new Login page factory.
     *
     * @param driver the driver
     */
    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    /**
     * Login.
     *
     * @param username the username
     * @param password the password
     */
    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    /**
     * Gets error message text.
     *
     * @return the error message text
     */
    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    /**
     * Wait for page opened.
     */
    public void waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }
}