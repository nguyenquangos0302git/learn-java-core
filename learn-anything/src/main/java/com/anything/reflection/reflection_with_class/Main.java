package com.anything.reflection.reflection_with_class;

import java.util.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;
        Map<String, Integer> mapObj = new HashMap<>();
        Class<?> hashMapClass = mapObj.getClass();
        Class<?> squareClass = Class.forName("com.anything.reflection.reflection_with_class.Main$Square");
        var circle = new Drawable() {
            @Override
            public int getNumberOfCorners() {
                return 0;
            }
        };
        printClassInfo(stringClass, hashMapClass, squareClass, Collection.class, boolean.class, int[][].class, Color.class, circle.getClass());
    }

    private static void printClassInfo(Class<?> ...classes) {
        for (Class<?> clazz : classes) {
            System.out.println(String.format("class name: %s, class package name: %s",
                    clazz.getSimpleName(),
                    clazz.getPackageName()));

            Class<?>[] implementedInterfaces = clazz.getInterfaces();

            for (Class<?> implementedInterface : implementedInterfaces) {
                System.out.println(String.format("class %s implements : %s",
                        clazz.getSimpleName(),
                        implementedInterface.getSimpleName()));
            }

            System.out.println("Is array : " + clazz.isArray());
            System.out.println("Is primitive : " + clazz.isPrimitive());
            System.out.println("Is enum : " + clazz.isEnum());
            System.out.println("Is interface : " + clazz.isInterface());
            System.out.println("Is anonymous : " + clazz.isAnonymousClass());

            System.out.println();
            System.out.println();

        }
    }

    private static class Square implements Drawable {

        @Override
        public int getNumberOfCorners() {
            return 0;
        }
    }

    private static interface Drawable {
        int getNumberOfCorners();
    }

    private enum Color {
        RED,
        BLUE,
        GREEN
    }

}
