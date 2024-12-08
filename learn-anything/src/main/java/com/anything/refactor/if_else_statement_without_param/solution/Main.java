package com.anything.refactor.if_else_statement_without_param.solution;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, Runnable> paymentMethods = new HashMap<>();

    static {
        paymentMethods.put("CREDIT_CARD", Main::processCreditCardPayment);
        paymentMethods.put("PAYPAL", Main::processPaypalPayment);
        paymentMethods.put("BANK_TRANSFER", Main::processBankTransferPayment);
        paymentMethods.put("DEFAULT", Main::processDefaultPayment);
    }

    public static void main(String[] args) {
        processPayment("CREDIT_CARD");
    }

    private static void processPayment(String paymentMethod) {
        Runnable action = paymentMethods.get(paymentMethod);
        action.run();
    }

    private static void processDefaultPayment() {
        System.out.println("default payment");
    }

    private static void processBankTransferPayment() {
        System.out.println("bank transfer payment");
    }

    private static void processPaypalPayment() {
        System.out.println("paypal payment");
    }

    private static void processCreditCardPayment() {
        System.out.println("credit card payment");
    }

}
