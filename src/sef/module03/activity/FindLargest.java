package sef.module03.activity;

public class FindLargest {

    public static void main(String[] args) {

        // Given numbers
        int num1 = 45;
        int num2 = 300;
        int result;

        // Find the largest number using if-else
        if (num1 > num2) {
            result = num1;
        } else {
            result = num2;
        }
        System.out.println("Largest number is: " +result);
    }
}
