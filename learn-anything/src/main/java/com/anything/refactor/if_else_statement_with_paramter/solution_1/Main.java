package com.anything.refactor.if_else_statement_with_paramter.solution_1;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, Operation> operations = new HashMap<>();

    static {
        operations.put("add", new AddOperation());
        operations.put("subtract", new SubtractOperation());
        operations.put("multiply", new MultiplyOperation());
        operations.put("divide", new DivideOperation());
    }

    public static void main(String[] args) {
        Operation operation = operations.get("add");

        if (operation == null) {
            throw new RuntimeException("Invalid operation");
        }

        System.out.println(operation.apply(1, 2));
    }

}
