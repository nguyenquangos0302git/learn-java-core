package com.anything.refactor.if_else_statement_with_paramter.solution.way1;

public class Main {

    public static void main(String[] args) {

    }

    private static void way1() {
        var calculator = new ShippingCostCalculator();
        var cost = calculator.calculateShippingCost(ShippingType.EXPRESS, 2.5);
        System.out.println("Shipping cost: " + cost);
    }

}
