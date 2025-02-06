package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void checkProductNameAndPriceInCart() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement usernameElement = driver.findElement(By.id("user-name"));
        usernameElement.sendKeys("standard_user");
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();

        WebElement addToCard = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        addToCard.click();
        WebElement card = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        card.click();

        WebElement productName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        WebElement productPrice = driver.findElement(By.cssSelector("div[data-test='inventory-item-price']"));
        Assert.assertEquals(productName.getText(), "Sauce Labs Backpack");
        Assert.assertEquals(productPrice.getText(), "$29.99");
    }
}
