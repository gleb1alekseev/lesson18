package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The type Header page.
 */
public class HeaderPage extends BasePage{
    /**
     * The constant DROPDOWN_MENU.
     */
    public static final By DROPDOWN_MENU = By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    /**
     * The constant LOG_OUT_BUTTON.
     */
    public static final By LOG_OUT_BUTTON = By.xpath("//*[@id=\"logout_sidebar_link\"]");
    /**
     * The constant CART_BUTTON.
     */
    public static final By CART_BUTTON = By.xpath("");

    /**
     * Instantiates a new Header page.
     *
     * @param driver the driver
     */
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Select dropdown menu header page.
     *
     * @return the header page
     */
    public HeaderPage selectDropdownMenu() {
        driver.findElement(DROPDOWN_MENU).click();
        return this;
    }

    /**
     * Log out login page.
     *
     * @return the login page
     */
    public LoginPage logOut() {
        driver.findElement(LOG_OUT_BUTTON).click();
        return new LoginPage(driver);
    }

    /**
     * Click cart button header page.
     *
     * @return the header page
     */
    public HeaderPage clickCartButton() {
        driver.findElement(CART_BUTTON).click();
        return this;
    }
}