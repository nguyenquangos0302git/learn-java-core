package com.anything.refactor.if_else_statement_with_paramter.solution.way1;

public class ShippingCostCalculator {
    public double calculateShippingCost(ShippingType shippingType, double weight) {
        return shippingType.getCost(weight);
    }
}
