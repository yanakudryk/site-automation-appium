package pages;

import entities.BillingDetails;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CheckOutPage extends BasePage {

    @FindBy(xpath = "//input[@id='billing_first_name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='billing_last_name']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='billing_company']")
    private WebElement company;
    @FindBy(xpath = "//select[@id='billing_country']")
    private WebElement country;
    @FindBy(xpath = "//input[@id='billing_address_1']")
    private WebElement address_1;
    @FindBy(xpath = "//input[@id='billing_address_2']")
    private WebElement address_2;
    @FindBy(xpath = "//input[@id='billing_city']")
    private WebElement city;
    @FindBy(xpath = "//select[@id='billing_state']")
    private WebElement state;
    @FindBy(xpath = "//input[@id='billing_postcode']")
    private WebElement postcode;
    @FindBy(xpath = "//input[@id='billing_phone']")
    private WebElement phone;
    @FindBy(xpath = "//input[@id='billing_email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='account_password']")
    private WebElement password;
    @FindBy(xpath = "//ul[@class='wc_payment_methods payment_methods methods']//input")
    private List<WebElement> paymentRadioButton;
    @FindBy(xpath = "//button[text()='Place order']")
    private WebElement placeOrderButton;
    @FindBy(xpath = "//button[text()='Proceed to PayPal']")
    private WebElement proceedToPayPalButton;
    @FindBy(xpath = "//*[@class='blockUI blockOverlay']")
    private WebElement overlay;

    @FindBy(xpath = "//div[@class='woocommerce-privacy-policy-text']")
    private WebElement policy;

    public CheckOutPage(AppiumDriver driver) {
        super(driver);
    }
    public void fillBillingDetails(BillingDetails billingDetails) {
        action.inputText(firstName, billingDetails.firstName());
        action.inputText(lastName, billingDetails.lastName());
        action.inputText(company, billingDetails.company());
        action.selectElementFromDropDown(country, billingDetails.country());
        action.inputText(address_1, billingDetails.address_1());
        action.inputText(address_2, billingDetails.address_2());
        action.inputText(city, billingDetails.city());
        action.selectElementFromDropDown(state, billingDetails.state());
        action.inputText(postcode, billingDetails.postcode());
        action.inputText(phone, billingDetails.phone());
        action.inputText(email, billingDetails.email());
        action.inputText(password, billingDetails.password());
        action.selectRadioButton(paymentRadioButton, billingDetails.payment());
    }

    public void placeOrder(){
        action.clickButton(placeOrderButton);
    }

    public void proceedToPayPal(){
        action.clickButton(proceedToPayPalButton);
    }
}
