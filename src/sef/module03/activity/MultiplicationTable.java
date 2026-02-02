package sef.module03.activity;

public class MultiplicationTable {

    public static void main(String[] args) {

        // Print multiplication tables from 1 to 10
        for (int i = 1; i <= 10; i++) {
            System.out.println("Multiplication Table of " + i);

            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }

            System.out.println(); // blank line between tables
        }
    }
}
