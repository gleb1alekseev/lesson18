package pages;

import constants.IPageConstants;
import org.openqa.selenium.WebDriver;

public abstract class BasePage implements IPageConstants {
    WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(String url){
        driver.get(url);
//        return null;
    }
}
