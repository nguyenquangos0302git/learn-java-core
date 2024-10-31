package com.anything.refactor.if_else_statement_with_paramter.problem;

public class ShippingCostCalculator {
    public double calculateShippingCost(String shippingType, double weight) {
        if (shippingType.equals("STANDARD")) {
            return weight * 5.0;
        } else if (shippingType.equals("EXPRESS")) {
            return weight * 10.0;
        } else if (shippingType.equals("SAME_DAY")) {
            return weight * 20.0;
        } else if (shippingType.equals("INTERNATIONAL")) {
            return weight * 50.0;
        } else if (shippingType.equals("OVERNIGHT")) {
            return weight * 30.0;
        }
        return 0;
    }
}
