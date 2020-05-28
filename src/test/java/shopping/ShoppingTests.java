package shopping;

import base.BaseTests;
import com.github.javafaker.Faker;
import entities.BillingDetails;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

import static constants.Constants.*;
import static constants.PayPalCredentials.PAY_PAL_EMAIL_PERSONAL;
import static constants.PayPalCredentials.PAY_PAL_PASSWORD_PERSONAL;


public class ShoppingTests extends BaseTests {

    @Test
    public void testShoppingWithCheckPaymentsPM() {
        Faker usFaker = new Faker(new Locale("en-US"));
        BillingDetails billDet =
                new BillingDetails(
                        usFaker.name().firstName(),
                        usFaker.name().lastName(),
                        usFaker.company().name(),
                        COUNTRY,
                        usFaker.address().streetAddress(),
                        usFaker.address().streetAddressNumber(),
                        usFaker.address().city(),
                        usFaker.address().state(),
                        usFaker.address().zipCode(),
                        usFaker.phoneNumber().cellPhone(),
                        usFaker.name().username().concat(MAIL_DOMAIN),
                        PASSWORD,
                        PAYMENT_METHOD_CHECK.get("Check payments"));

        shopPage.addProductToCart(PRODUCT_NAME);
        shopPage.goToCart();
        cartPage.proceedToCheckOut();
        checkOutPage.fillBillingDetails(billDet);
        checkOutPage.placeOrder();
        Assert.assertEquals(orderReceiptPage.getPaymentMethod(),"Check payments","Incorrect payment method");
        shopPage.openMenu();
        shopPage.goToMyAccount();
        myAccountPage.openOrders();
        ordersPage.openTopOrder();
        Assert.assertEquals(ordersPage.getOrderPayment(),"Check payments","Incorrect payment method");
        Assert.assertTrue(ordersPage.getProductNames().contains(PRODUCT_NAME), "There is no product name in the order.");
    }

    @Test
    public void testShoppingWithPayPalPM(){
        Faker usFaker = new Faker(new Locale("en-US"));
        BillingDetails billDet =
                new BillingDetails(
                        usFaker.name().firstName(),
                        usFaker.name().lastName(),
                        usFaker.company().name(),
                        COUNTRY,
                        usFaker.address().streetAddress(),
                        usFaker.address().streetAddressNumber(),
                        usFaker.address().city(),
                        usFaker.address().state(),
                        usFaker.address().zipCode(),
                        usFaker.phoneNumber().cellPhone(),
                        usFaker.name().username().concat(MAIL_DOMAIN),
                        PASSWORD,
                        PAYMENT_METHOD_PAY_PAL.get("PayPal"));

        shopPage.addProductToCart(PRODUCT_NAME_1);
        shopPage.goToCart();
        cartPage.proceedToCheckOut();
        checkOutPage.fillBillingDetails(billDet);
        checkOutPage.proceedToPayPal();
        payPalPage.loginToPayPal(PAY_PAL_EMAIL_PERSONAL, PAY_PAL_PASSWORD_PERSONAL);
        payPalPage.clickPayNow();
        Assert.assertEquals(orderReceiptPage.getPaymentMethod(),"PayPal","Incorrect payment method");
    }
}
