package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopPage extends BasePage {
    @FindBy(xpath = "//span[@class='cart-contents-count fa fa-shopping-bag']")
    private WebElement cart;
    @FindBy(xpath = "//button[@class='menu-toggle']")
    private WebElement menu;
    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    private List<WebElement> addToCartButtons;
    @FindBy(xpath = "//span[contains(text(),'Add to Wish list')]")
    private List<WebElement> addToWishListButtons;
    @FindBy(xpath = "//*[@class='woocommerce-loop-product__title']")
    private List<WebElement> productTitles;
    @FindBy(xpath = "//ul[@id='top-menu']//a[contains(text(),'My Account')]")
    private WebElement myAccount;

    public ShopPage(AppiumDriver driver) {
        super(driver);
    }

    public void openMenu(){
        action.clickButton(menu);
    }
    public void goToMyAccount(){
        action.clickButton(myAccount);
    }
    public void addProductToCart(String name){
        for (int i = 0; i < productTitles.size(); i++) {
            if (action.getText(productTitles.get(i)).equals(name)){
                action.clickButton(addToCartButtons.get(i));
                break;
            }
        }
    }
    public void addProductToWishList(String name){
        for (int i = 0; i < productTitles.size(); i++) {
            if (action.getText(productTitles.get(i)).equals(name)){
                action.clickButton(addToWishListButtons.get(i));
            }
        }
    }
    public void goToCart(){
        action.clickButton(cart);
    }

}

