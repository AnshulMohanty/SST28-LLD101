package com.example.payments;

import java.util.Objects;

/**
 * Adapter for SafeCash SDK
 *
 * self note:
 * SafeCash ka flow different hai:
 * createPayment() -> confirm()
 */
public class SafeCashAdapter implements PaymentGateway {

    private final SafeCashClient client;

    public SafeCashAdapter(SafeCashClient client) {
        this.client = Objects.requireNonNull(client, "client");
    }

    @Override
    public String charge(String customerId, int amountCents) {

        Objects.requireNonNull(customerId, "customerId");

        // SafeCash pehle payment object banata hai
        SafeCashPayment payment =
                client.createPayment(amountCents, customerId);

        // fir confirm karke transaction id milti hai
        return payment.confirm();
    }
}