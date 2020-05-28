package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage extends BasePage{

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    private WebElement proceedToCheckOutButton;
    @FindBy(xpath = "//tr[@class='order-total']//span[@class='woocommerce-Price-amount amount']")
    private WebElement totalPrice;
    @FindBy(id = "coupon_code")
    private WebElement couponCode;
    @FindBy(name = "apply_coupon")
    private WebElement applyCouponButton;
    @FindBy(xpath = "//div[@class='woocommerce-message']")
    private WebElement message;
    @FindBy(xpath = "//*[@class='blockUI blockOverlay']")
    private WebElement overlay;
    @FindBy(xpath = "//input[@type='number']")
    private WebElement quantities;
    @FindBy(xpath = "//button[@name='update_cart']")
    private WebElement updateCart;

    public CartPage(AppiumDriver driver) {
        super(driver);

    }

    public void proceedToCheckOut(){
        action.clickButton(proceedToCheckOutButton);
    }

    }

