package com.anything.reflection.reflection_with_method.database;

public class DatabaseClient {
    public boolean storeData(String data) {
        System.out.println(String.format("Data : %s was successfully stored in the database", data));
        return true;
    }
}
