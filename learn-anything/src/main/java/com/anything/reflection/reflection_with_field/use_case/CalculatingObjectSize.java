package com.anything.reflection.reflection_with_field.use_case;

import com.anything.reflection.reflection_with_field.data.AccountSummary;

import java.lang.reflect.Field;

public class CalculatingObjectSize {

    private static final long HEADER_SIZE = 12;
    private static final long REFERENCE_SIZE = 4;

    public static void main(String[] args) throws IllegalAccessException {
        AccountSummary accountSummary = new AccountSummary("John", "Smith", (short) 20, 100_000);
        System.out.println(sizeOfObject(accountSummary));
    }

    public static long sizeOfObject(Object input) throws IllegalAccessException {
        /**
         * Complete your code here
         */
        Field[] fields = input.getClass().getDeclaredFields();

        long totalSize = HEADER_SIZE + REFERENCE_SIZE;
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            if (field.isSynthetic()) {
                continue;
            }
            if (field.getType().isPrimitive()) {
                totalSize += sizeOfPrimitiveType(field.getType());
            } else if (field.getType().equals(String.class)) {
                totalSize += sizeOfString(field.get(input).toString());
            }
        }

        return totalSize;
    }

    private static long sizeOfPrimitiveType(Class<?> primitiveType) {
        if (primitiveType.equals(int.class)) {
            return 4;
        } else if (primitiveType.equals(long.class)) {
            return 8;
        } else if (primitiveType.equals(float.class)) {
            return 4;
        } else if (primitiveType.equals(double.class)) {
            return 8;
        } else if (primitiveType.equals(byte.class)) {
            return 1;
        } else if (primitiveType.equals(short.class)) {
            return 2;
        }
        throw new IllegalArgumentException(String.format("Type: %s is not supported", primitiveType));
    }

    private static long sizeOfString(String inputString) {
        int stringBytesSize = inputString.getBytes().length;
        return HEADER_SIZE + REFERENCE_SIZE + stringBytesSize;
    }

}

