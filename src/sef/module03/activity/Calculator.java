package sef.module03.activity;

public class Calculator {

    public static void main(String[] args) {

        int a = 101;
        int b = 5;

        int sum = add(a, b);
        int product = multiply(a, b);
        int divide = divide(a,b);
        int diference = diference(a,b);

        // Print the results
        System.out.println("Addition result: " + sum);
        System.out.println("Multiplication result: " + product);
        System.out.println("Divide result: " + divide);
        System.out.println("Diference result: " + diference);
    }

    // Method to add two numbers
    public static int add(int x, int y) {
        return x + y;
    }

    // Method to multiply two numbers
    public static int multiply(int x, int y) {
        return x * y;
    }

    public static  int divide(int x, int y){
        return x/y;
    }

    public static int diference(int x, int y){
        return x-y;
    }
}
