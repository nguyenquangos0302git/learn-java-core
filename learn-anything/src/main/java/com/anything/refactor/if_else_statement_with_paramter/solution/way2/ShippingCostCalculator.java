package com.anything.refactor.if_else_statement_with_paramter.solution.way2;

import java.util.HashMap;
import java.util.Map;

public class ShippingCostCalculator {
//    public double calculateShippingCost(String shippingType, double weight) {
//        ShippingCostStrategy strategy = ShippingCostFactory.getStrategy(shippingType);
//        return strategy.calculate(weight);
//    }
    private static final Map<String, ShippingCostStrategy> strategies = new HashMap<>();

    static {
        strategies.put("STANDARD", new StandardShipping());
        strategies.put("EXPRESS", new ExpressShipping());
        strategies.put("SAME_DAY", new SameDayShipping());
        strategies.put("INTERNATIONAL", new InternationalShipping());
        strategies.put("OVERNIGHT", new OvernightShipping());
    }

    private final ShippingCostContext context = new ShippingCostContext();

    public double calculateShippingCost(String shippingType, double weight) {
        ShippingCostStrategy strategy = strategies.get(shippingType);
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid shipping type: " + shippingType);
        }
        context.setStrategy(strategy);
        return context.calculateShippingCost(weight);
    }

}
