package com.anything.recursive;

public class PrintWithoutLoop {

    public static void print(int number) {
        if (number > 100) {
            return;
        }
        System.out.println(number);
        print(number + 1);
    }

}
