package sef.module03.activity;

public class NumToWordsUsingMethod {

    public static void main(String[] args) {

        int number = 5;
        printWord(number);
    }

    // Method to print the word value of a number
    public static void printWord(int number) {

        switch (number) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            default:
                System.out.println("Number not supported");
        }
    }
}
