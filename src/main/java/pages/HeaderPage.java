package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage{

    public static final By DROPDOWN_MENU = By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    public static final By LOG_OUT_BUTTON = By.xpath("//*[@id=\"logout_sidebar_link\"]");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void selectDropdownMenu(){
        driver.findElement(DROPDOWN_MENU).click();
    }
    public void logOut(){
        driver.findElement(LOG_OUT_BUTTON).click();
    }
}
