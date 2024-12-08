package com.anything.reflection.reflection_with_field;

import java.lang.reflect.Array;

public class Main2 {

    public static void main(String[] args) {
        int [] oneDimensionArray = {1, 2};
        double [][] twoDimensionArray = {{1, 2}, {3, 4}};
        inspectArrayObject(twoDimensionArray);
        inspectArrayValue(twoDimensionArray);
    }

    public static void inspectArrayValue(Object arrayObject) {
        int arrLength = Array.getLength(arrayObject);

        System.out.print("[");
        for (int i = 0; i < arrLength; i++) {
            Object element = Array.get(arrayObject, i);

            if (element.getClass().isArray()) {
                inspectArrayValue(element);
            } else {
                System.out.print(element);
            }

            if (i != arrLength - 1) {
                System.out.print(", ");
            }
        }

        System.out.print("]");
    }

    public static void inspectArrayObject(Object arrayObject) {
        Class<?> clazz = arrayObject.getClass();
        System.out.println(String.format("Is array : %s", clazz.isArray()));
        Class<?> arrayComponentType = clazz.getComponentType();
        System.out.println(String.format("This is an array of type : %s", arrayComponentType.getTypeName()));
    }

}
