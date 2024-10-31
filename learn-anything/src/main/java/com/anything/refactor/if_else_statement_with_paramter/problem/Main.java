package com.anything.refactor.if_else_statement_with_paramter.problem;

public class Main {

    public static void main(String[] args) {
        String shippingType = "STANDARD";
        double weight = 10.0;

        double shippingCost = new ShippingCostCalculator().calculateShippingCost(shippingType, weight);
        System.out.println("Shipping cost: " + shippingCost);
    }

}
