package sef.module03.activity;

public class PrintNumWithWhile {

    public static void main(String[] args) {

        int number = 2;

        // Print all even numbers less than 100
        while (number < 100) {
            System.out.println(number);
            number += 2;
        }
    }
}
