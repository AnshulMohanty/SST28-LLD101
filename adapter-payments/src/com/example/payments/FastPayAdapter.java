package com.example.payments;

import java.util.Objects;

/**
 * Adapter for FastPay SDK
 *
 * self note:
 * FastPayClient ka method naam alag hai (payNow)
 * isko PaymentGateway interface ke charge() se map karna hai
 */
public class FastPayAdapter implements PaymentGateway {

    private final FastPayClient client;

    public FastPayAdapter(FastPayClient client) {
        this.client = Objects.requireNonNull(client, "client");
    }

    @Override
    public String charge(String customerId, int amountCents) {

        Objects.requireNonNull(customerId, "customerId");

        // adapter bas call translate kar raha hai
        return client.payNow(customerId, amountCents);
    }
}