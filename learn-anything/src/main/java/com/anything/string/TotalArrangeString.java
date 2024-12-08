package com.anything.string;

public class TotalArrangeString {

    // Helper method to swap characters at position i and j in char array
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Recursive method to generate permutations
    public static void generatePermutations(char[] arr, int currentIndex) {
        // Base case: if currentIndex is the last index, print the current permutation
        if (currentIndex == arr.length - 1) {
            System.out.println(String.valueOf(arr));
            return;
        }

        // Recursive case: swap the current index with each index and generate further permutations
        for (int i = currentIndex; i < arr.length; i++) {
            swap(arr, currentIndex, i);
            generatePermutations(arr, currentIndex + 1);
            swap(arr, currentIndex, i); // backtrack to the original configuration
        }
    }

}
