package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HeaderPage extends BasePage{

    public static final By DROPDOWN_MENU = By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    public static final By LOG_OUT_BUTTON = By.xpath("//*[@id=\"logout_sidebar_link\"]");
    public static final By CART_BUTTON = By.xpath("");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public HeaderPage selectDropdownMenu() {
        log.info("Dropdown Menu is selected");
        driver.findElement(DROPDOWN_MENU).click();
        return this;
    }

    public LoginPage logOut() {
        log.info("Logout completed");
        driver.findElement(LOG_OUT_BUTTON).click();
        return new LoginPage(driver);
    }

    public HeaderPage clickCartButton() {
        log.info("Click on the cart button");
        driver.findElement(CART_BUTTON).click();
        return this;
    }
}