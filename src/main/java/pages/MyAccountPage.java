package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Orders')]")
    private WebElement orders;
    @FindBy(xpath = "//a[contains(text(),'Wish list')]")
    private WebElement wishList;

    public MyAccountPage(AppiumDriver driver) {
        super(driver);
    }

    public void openOrders(){
        action.clickButton(orders);
    }

    public void openWishList(){
        action.clickButton(wishList);
    }

}
