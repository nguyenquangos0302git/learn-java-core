package com.anything.refactor.if_else_statement_with_paramter.solution_1;

import java.util.function.BiFunction;

@FunctionalInterface
public interface Operation extends BiFunction<Integer, Integer, Integer> {

}
