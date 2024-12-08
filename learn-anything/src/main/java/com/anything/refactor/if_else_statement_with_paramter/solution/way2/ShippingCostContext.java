package com.anything.refactor.if_else_statement_with_paramter.solution.way2;

public class ShippingCostContext {
    private ShippingCostStrategy strategy;

    public void setStrategy(ShippingCostStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateShippingCost(double weight) {
        return strategy.calculate(weight);
    }
}
