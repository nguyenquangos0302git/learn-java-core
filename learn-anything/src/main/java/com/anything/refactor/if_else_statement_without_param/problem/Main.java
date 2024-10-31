package com.anything.refactor.if_else_statement_without_param.problem;

public class Main {

    public static void main(String[] args) {
        processPayment("CREDIT_CARD");
    }

    private static void processPayment(String paymentMethod) {
        if ("CREDIT_CARD".equals(paymentMethod)) {
            processCreditCardPayment();
        } else if ("PAYPAL".equals(paymentMethod)) {
            processPaypalPayment();
        } else if ("BANK_TRANSFER".equals(paymentMethod)) {
            processBankTransferPayment();
        } else {
            processDefaultPayment();
        }
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
