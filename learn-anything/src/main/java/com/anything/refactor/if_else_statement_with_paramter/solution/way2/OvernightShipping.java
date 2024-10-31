package com.anything.refactor.if_else_statement_with_paramter.solution.way2;

public class OvernightShipping implements ShippingCostStrategy {
    @Override
    public double calculate(double weight) {
        return weight * 30.0;
    }
}
