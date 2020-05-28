package base;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class BaseTests {
    public static String accessKey = "jJzzxaR3GN2JCoLqEoQT";
    public static String userName = "yanakudryk3";
    public AppiumDriver driver;

    protected ShopPage shopPage;
    protected CartPage cartPage;
    protected CheckOutPage checkOutPage;
    protected OrderReceiptPage orderReceiptPage;
    protected MyAccountPage myAccountPage;
    protected OrdersPage ordersPage;
    protected PayPalPage payPalPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = getIOSDriver();
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        orderReceiptPage = new OrderReceiptPage(driver);
        myAccountPage = new MyAccountPage(driver);
        ordersPage = new OrdersPage(driver);
        payPalPage = new PayPalPage(driver);
        goHome();
    }

    private IOSDriver<IOSElement> getIOSDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "iPhone 11 Pro Max");
        caps.setCapability("os_version", "13");
        caps.setCapability("project", "My First Project");
        caps.setCapability("build", "My First Build");
        caps.setCapability("name", "Bstack-[Java] Sample Test");
        caps.setCapability("browserName", "Safari");

        return new IOSDriver<IOSElement>(new URL("http://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
    }

    private AndroidDriver<AndroidElement> getAndroidDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");
        caps.setCapability("project", "My First Project");
        caps.setCapability("build", "My First Build");
        caps.setCapability("name", "Bstack-[Java] Sample Test");
        caps.setCapability("browserName", "Browser");
        return new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
    }

    @BeforeMethod
    public void goHome(){
        driver.get("http://www.automation.ho.ua/");
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File(
                        "out/screenshots/" +
                                result.getName() +
                                LocalDateTime.now().format(DateTimeFormatter.ofPattern(" dd-MM-yyyy HH_mm_ss")) +
                                ".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
