package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderReceiptPage extends BasePage {
    @FindBy(xpath = "//*[@class='woocommerce-order-overview__payment-method method']/strong")
    private WebElement paymentMethod;
    @FindBy(xpath = "//*[@class='woocommerce-order-overview__total total']/strong")
    private WebElement totalPrice;

    public OrderReceiptPage(AppiumDriver driver) {
        super(driver);
    }

    public String getPaymentMethod(){
        return action.getText(paymentMethod);
    }
}
