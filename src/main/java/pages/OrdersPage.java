package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class OrdersPage extends BasePage {
    @FindBy(xpath = "//a[@class='woocommerce-button button view']")
    private List<WebElement> viewButtons;
    @FindBy(xpath = "//td[@class='woocommerce-table__product-name product-name']/a")
    private List<WebElement> productNames;
    @FindBy(xpath = "//th[contains(text(),'Payment method:')]/following-sibling::td")
    private WebElement paymentMethod;
    public OrdersPage(AppiumDriver driver) {
        super(driver);
    }

    public void openTopOrder(){
        action.clickButton(viewButtons.get(0));
    }

    public List<String> getProductNames(){
        List<String> listOfProductNames = new ArrayList<>();
        for (int i = 0; i < productNames.size(); i++) {
            listOfProductNames.add(action.getText(productNames.get(i)));
        }
        return listOfProductNames;
    }

    public String getOrderPayment(){
        return action.getText(paymentMethod);
    }
}
