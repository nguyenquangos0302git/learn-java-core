package com.anything.refactor.if_else_statement_with_paramter.solution.way3;

import com.anything.refactor.if_else_statement_with_paramter.solution.way2.ShippingCostCalculator;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, Double> shippingCosts = new HashMap<>();

    static {
        shippingCosts.put("STANDARD", 5.0);
        shippingCosts.put("EXPRESS", 10.0);
        shippingCosts.put("SAME_DAY", 20.0);
        shippingCosts.put("INTERNATIONAL", 50.0);
        shippingCosts.put("OVERNIGHT", 30.0);
    }

    public double calculateShippingCost(String shippingType, double weight) {
        return shippingCosts.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(shippingType))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(0.0)
                * weight;
    }

    public static void main(String[] args) {
        Main calculator = new Main();

        double weight = 10.0;

        String shippingType1 = "STANDARD";
        double cost1 = calculator.calculateShippingCost(shippingType1, weight);
        System.out.println("Shipping cost for " + shippingType1 + ": " + cost1);

        String shippingType2 = "EXPRESS";
        double cost2 = calculator.calculateShippingCost(shippingType2, weight);
        System.out.println("Shipping cost for " + shippingType2 + ": " + cost2);

        String shippingType3 = "SAME_DAY";
        double cost3 = calculator.calculateShippingCost(shippingType3, weight);
        System.out.println("Shipping cost for " + shippingType3 + ": " + cost3);

        String shippingType4 = "INTERNATIONAL";
        double cost4 = calculator.calculateShippingCost(shippingType4, weight);
        System.out.println("Shipping cost for " + shippingType4 + ": " + cost4);

        String shippingType5 = "OVERNIGHT";
        double cost5 = calculator.calculateShippingCost(shippingType5, weight);
        System.out.println("Shipping cost for " + shippingType5 + ": " + cost5);

        String invalidType = "INVALID";
        double invalidCost = calculator.calculateShippingCost(invalidType, weight);
        System.out.println("Shipping cost for " + invalidType + ": " + invalidCost);
    }

}
