package pages;

import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import utils.ActionWithWebElements;

public class BasePage {
    public AppiumDriver driver;
    public ActionWithWebElements action;
    public Logger logger;

    public BasePage(AppiumDriver driver){

        this.driver = driver;
        action = new ActionWithWebElements(driver);
        PageFactory.initElements(driver, this);
        logger = Logger.getLogger(getClass());
    }
}
