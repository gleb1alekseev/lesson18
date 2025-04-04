package tests;

import constant.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.CartSteps;
import steps.HeaderSteps;
import steps.LoginSteps;
import steps.ProductSteps;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest implements IConstants, ITestConstants {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    HeaderPage headerPage;
    LoginPageFactory loginPageFactory;
    ProductSteps productSteps;
    LoginSteps loginSteps;
    HeaderSteps headerSteps;
    CartSteps cartSteps;
    /**
     * This is initialization of pages
     */
    @BeforeMethod
    public void initTest(ITestContext iTestContext) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
        PageFactory.initElements(driver, this);
        iTestContext.setAttribute("driver", driver);
    }

    public void initPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
        productSteps = new ProductSteps(driver);
        loginSteps = new LoginSteps(driver);
        headerSteps = new HeaderSteps(driver);
        cartSteps = new CartSteps(driver);
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}