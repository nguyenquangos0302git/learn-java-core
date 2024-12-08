package com.anything.refactor.if_else_statement_with_paramter.solution.way2;

public class Main {

    public static void main(String[] args) {

    }

    private static void way2() {
        var calculator = new ShippingCostCalculator();
        var cost = calculator.calculateShippingCost("EXPRESS", 2.5);
        System.out.println("Shipping cost: " + cost);
    }

}
