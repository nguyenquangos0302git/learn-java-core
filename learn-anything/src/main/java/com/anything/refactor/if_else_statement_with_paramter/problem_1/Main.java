package com.anything.refactor.if_else_statement_with_paramter.problem_1;

public class Main {

    public static void main(String[] args) {
        System.out.println(operation(1, 2 , "add"));
    }

    public static int operation(int a, int b, String operator) {
        if (operator.equals("add")) {
            return a + b;
        } else if (operator.equals("subtract")) {
            return a - b;
        } else if (operator.equals("multiply")) {
            return a * b;
        } else if (operator.equals("divide")) {
            return a / b;
        } else {
            throw new UnsupportedOperationException("Invalid operation");
        }
    }

}
