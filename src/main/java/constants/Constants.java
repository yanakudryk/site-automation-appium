package constants;

import java.util.Map;

public interface Constants {
    String COUNTRY = "United States (US)";
    String PASSWORD = "123asdQQ!!!098upd";
    String INVALID_PASSWORD = "123asdQQ!!!098upd1";
    String FIRST_NAME = "Jane";
    String LAST_NAME = "Doe";
    String MAIL_DOMAIN = "@email.com";

    String COUPON_CODE = "2020SALE";
    Double COUPON_DISCOUNT = 20.00;

    Map<String, String> PAYMENT_METHOD_CHECK = Map.of("Check payments", "cheque" );
    Map<String, String> PAYMENT_METHOD_PAY_PAL = Map.of("PayPal", "paypal");
    String PRODUCT_NAME = "Angels and Demons";
    String PRODUCT_NAME_1 = "A Brief History Of Time: From Big Bang To Black Holes";
    Double PRODUCT_PRICE = 25.00;
    String PRODUCT_CATEGORY = "Fiction";
    String PRODUCT_DESCRIPTION =
            "В Швейцарии, в международном исследовательском" +
                    " центре обнаружен жестоко убитым выдающийся" +
                    " ученый-физик, недавно совершивший открытие," +
                    " способное изменить взгляды человечества на" +
                    " божественность сотворения мира.";
    String PRODUCT_QUANTITY = "1";
    String PRODUCT_REVIEW_COMMENT =
            "On the other hand, we denounce with righteous " +
                    "indignation and dislike men who are so" +
                    " beguiled and demoralized by the charms" +
                    " of pleasure of the moment.";
    Integer PRODUCT_REVIEW_STARS = 4;

}
