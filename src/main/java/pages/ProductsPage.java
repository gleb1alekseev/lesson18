package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The type Products page.
 */
public class ProductsPage extends HeaderPage {
    private static final String PRODUCT_ITEM_BY_NAME = "//*[text()='%s']";
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"inventory_item\"]";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";

    /**
     * Instantiates a new Products page.
     *
     * @param driver the driver
     */
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets product text.
     *
     * @param product the product
     * @return the product text
     */
    public String getProductText(String product) {
        return driver.findElement(By.xpath(String.format(PRODUCT_ITEM, product))).getText();
    }

    /**
     * Add product to cart products page.
     *
     * @param productNames the product names
     * @return the products page
     */
    public ProductsPage addProductToCart(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        }
        return this;
    }

    /**
     * Is add to cart button displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isAddToCartButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * Is remove button displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isRemoveButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * Gets product price.
     *
     * @param productName the product name
     * @return the product price
     */
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }
}
