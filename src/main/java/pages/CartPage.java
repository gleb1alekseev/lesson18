package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

/**
 * The type Cart page.
 */
public class CartPage extends HeaderPage{
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"cart_item\"]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class=\"cart_quantity\"]";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button";
    private static final String CART_ITEM_CONTAINER = "//*[@class='cart_item']";

    /**
     * Instantiates a new Cart page.
     *
     * @param driver the driver
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open cart page cart page.
     *
     * @param url the url
     * @return the cart page
     */
    public CartPage openCartPage(String url) {
        driver.get(url);
        return this;
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

    /**
     * Gets product quantity.
     *
     * @return the product quantity
     */
    public Integer getProductQuantity() {
        return driver.findElements(By.xpath(CART_ITEM_CONTAINER)).size();
    }

    /**
     * Remove product from cart cart page.
     *
     * @param productName the product name
     * @return the cart page
     */
    public CartPage removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        return this;
    }

    /**
     * Is product displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isProductDisplayed(String productName) {
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }

    /**
     * Wait.
     *
     * @param locator the locator
     */
    public void wait(By locator) {
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement foo = fluent.until(driver -> driver.findElement(locator));
        foo.click();
    }
}
