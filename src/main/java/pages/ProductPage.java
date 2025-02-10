package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends HeaderPage {
    public static final By PRODUCT1 = By.xpath("//div[text()='Sauce Labs Backpack']");
    public static final By PRODUCT2 = By.xpath("//div[text()='Sauce Labs Bike Light']");
    public static final By PRODUCT3 = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
    public static final By PRODUCT4 = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    public static final By PRODUCT5 = By.xpath("//div[text()='Sauce Labs Onesie']");
    public static final By PRODUCT6 = By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']");

    public String getProductText(By product){
        return driver.findElement(product).getText();
    }

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public static final By ADD_TO_CART_1 = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    public static final By ADD_TO_CART_2 = By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
    public static final By ADD_TO_CART_3 = By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");
    public static final By ADD_TO_CART_4 = By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]");
    public static final By ADD_TO_CART_5 = By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]");
    public static final By ADD_TO_CART_6 = By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]");

    public void addToCart(By addToCartButton){
        driver.findElement(addToCartButton).click();
    }
}
