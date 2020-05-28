package entities;

public record BillingDetails(
        String firstName,
        String lastName,
        String company,
        String country,
        String address_1,
        String address_2,
        String city,
        String state,
        String postcode,
        String phone,
        String email,
        String password,
        String payment) { }

