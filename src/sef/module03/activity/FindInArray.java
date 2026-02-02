package sef.module03.activity;

public class FindInArray {

    public static void main(String[] args) {

        int[] numbers = {45, 12, 78, -3, 26, 9};

        // Assume the first element is the smallest
        int smallest = numbers[0];

        // Find the smallest number in the array
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }
        }

        // Print the result
        System.out.println("Smallest number in the array: " + smallest);
    }
}
