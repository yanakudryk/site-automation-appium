package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayPalPage extends BasePage {
    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@id='btnLogin']")
    private WebElement loginButton;
    @FindBy(xpath = "//input[@id='confirmButtonTop']")
    private WebElement payNowButton;

    public PayPalPage(AppiumDriver driver) {
        super(driver);
    }

    public void loginToPayPal(String email, String password){
        action.inputText(this.email,email);
        action.inputText(this.password, password);
        action.clickButton(loginButton);
    }
    public void clickPayNow(){
        action.clickButton(payNowButton);
    }
}
