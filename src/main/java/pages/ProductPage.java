package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends HeaderPage {

    public static final By ADD_TO_CART_SAUCE_LABS_BACKPACK = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(){
        driver.findElement(ADD_TO_CART_SAUCE_LABS_BACKPACK).click();
    }
}
