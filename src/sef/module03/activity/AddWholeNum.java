package sef.module03.activity;

public class AddWholeNum {

    public static void main(String[] args) {

        int sum = 0;

        // Add all whole numbers from 1 to 50
        for (int i = 1; i <= 50; i++) {
            sum += i;
        }

        // Print the result
        System.out.println("Sum of whole numbers from 1 to 50: " + sum);
    }
}
