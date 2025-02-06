import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MainPage {

    WebDriver driver = new ChromeDriver();

    private final WebElement userName = driver.findElement(By.id("user-name"));
    private final WebElement password = driver.findElement(By.name("password"));
    private final WebElement loginButton = driver.findElement(By.className("submit-button"));
    private final WebElement listOfUserName = driver.findElement(By.tagName("h4"));
    private final WebElement linkText = driver.findElement(By.linkText("Sauce Labs Backpack"));
    private final WebElement partialLinkText = driver.findElement(By.partialLinkText("Labs Backpack"));
    private final WebElement addToCartButton = driver.findElement(By.xpath("//*[@data-test=\"add-to-cart-sauce-labs-backpack\"]"));
    private final WebElement productName = driver.findElement(By.xpath(""));
    private final WebElement partialText = driver.findElement(By.xpath("//*[contains(text(), \"Light\")]"));
    private final WebElement productNamePartial = driver.findElement(By.xpath("//*[contains(text(), \"Light\")]"));
    private final List<WebElement> priceList = driver.findElements(By.xpath("//*[contains(@data-test, 'price')]"));
    private final WebElement up = driver.findElement(By.xpath("//*[@class='login_wrapper-inner']//descendant::div"));
    private final WebElement down = driver.findElement(By.xpath("//*[@class='login_wrapper-inner']//parent::div"));
    //input[@id='password']/preceding-sibling::input[1]
    //*[@class='login_wrapper-inner']/following-sibling::di v
    //*[@data-test='password' and contains(@id, 'password')]
    //*[@data-test='password' and contains(@id, 'password') and contains(@name, 'password')]
    //img[@class="inventory_item_img"]/@src
}