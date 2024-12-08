package com.anything.reflection.reflection_with_annotation.database;

import com.anything.reflection.reflection_with_annotation.annotations.InitializerClass;
import com.anything.reflection.reflection_with_annotation.annotations.InitializerMethod;
import com.anything.reflection.reflection_with_annotation.annotations.RetryOperation;

import java.io.IOException;

@InitializerClass
public class DatabaseConnection {

    private int failCounter = 5;

    @RetryOperation(
            numberOfRetries = 10,
            retryException = IOException.class,
            durationBetweenRetriesMs = 1000,
            failureMessage = "Connection to database 1 failed after retries"
    )
    @InitializerMethod
    public void connectToDatabase1() throws IOException {
        System.out.println("Connecting to database 1");
        if (failCounter > 0) {
            failCounter--;
            throw new IOException("Connected failed");
        }
        System.out.println("Connecting to database 1 succeeded");
    }

    @InitializerMethod
    public void connectToDatabase2() {
        System.out.println("Connecting to database 2");
    }
}
