package com.anything.refactor.if_else_statement_with_paramter.solution.way2;

public class ExpressShipping implements ShippingCostStrategy {
    @Override
    public double calculate(double weight) {
        return weight * 10.0;
    }
}
