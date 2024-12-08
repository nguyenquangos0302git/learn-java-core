package com.anything.refactor.if_else_statement_with_paramter.solution.way2;

public class InternationalShipping implements ShippingCostStrategy {
    @Override
    public double calculate(double weight) {
        return weight * 50.0;
    }
}
