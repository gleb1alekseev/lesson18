package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductsPage extends HeaderPage {
    private static final String PRODUCT_ITEM_BY_NAME = "//*[text()='%s']";
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"inventory_item\"]";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductText(String product) {
        log.info("Error message was found: " + getProductText(product));
        return driver.findElement(By.xpath(String.format(PRODUCT_ITEM, product))).getText();
    }

    public ProductsPage addProductToCart(String... productNames) {
        for (String productName : productNames) {
            log.info("Add product to cart: " + productName);
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        }
        return this;
    }

    public boolean isAddToCartButtonDisplayed(String productName) {
        log.info("The Add To Cart button was displayed for product: " + getProductText(productName));
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).isDisplayed();
    }

    public boolean isRemoveButtonDisplayed(String productName) {
        log.info("The Remove button was displayed for product: " + getProductText(productName));
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).isDisplayed();
    }

    public String getProductPrice(String productName) {
        log.info("Price for product: " + getProductText(productName));
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }
}
