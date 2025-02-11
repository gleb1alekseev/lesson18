package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends HeaderPage {
    private static final String PRODUCT_ITEM_BY_NAME = "//*[text()='%s']";
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='inventory_item']";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";

    public String getProductText(String product){
        return driver.findElement(By.xpath(String.format(PRODUCT_ITEM_BY_NAME, product))).getText();
    }

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }
}
