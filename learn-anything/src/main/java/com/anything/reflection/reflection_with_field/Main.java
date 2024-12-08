package com.anything.reflection.reflection_with_field;

import java.lang.reflect.Field;

public class Main {

    public static void main(String [] args) throws IllegalAccessException {
        Movie movie = new Movie("Lord of the Rings", 2001, 12.99, true, Category.ADVENTURE);
        printDeclaredFieldsInfo(Movie.class, movie);
    }

    public static void printDeclaredFieldsInfo(Class<?> clazz) {
        Field [] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(String.format("Field name: %s type: %s", field.getName(), field.getType().getName()));
            System.out.println(String.format("Is synthetic field: %s", field.isSynthetic()));

            System.out.println();
        }
    }

    public static <T> void printDeclaredFieldsInfo(Class<T> clazz, T instance) throws IllegalAccessException {
        Field [] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(String.format("Field name: %s type: %s", field.getName(), field.getType().getName()));
            System.out.println(String.format("Is synthetic field: %s", field.isSynthetic()));
            System.out.println(String.format("Field value is: %s", field.get(instance)));

            System.out.println();
        }
    }

    public static class Movie extends Product {
        public static final double MINIMUM_PRICE = 10.99;
        private boolean isReleased;
        private Category category;
        private double actualPrice;

        public Movie(String name, int year, double price, boolean isReleased, Category category) {
            super(name, year);
            this.isReleased = isReleased;
            this.category = category;
            this.actualPrice = Math.max(price, MINIMUM_PRICE);
        }

        public class MovieStart {
            private double timeWatched;

            public MovieStart(double timeWatched) {
                this.timeWatched = timeWatched;
            }

            public double getRevenue() {
                return timeWatched = actualPrice;
            }
        }

    }

    public static class Product {
        protected String name;
        protected int year;
        protected double actualPrice;

        public Product(String name, int year){
            this.name = name;
            this.year = year;
        }

    }

    public enum Category {
        ADVENTURE,
        ACTION,
        COMEDY
    }

}
