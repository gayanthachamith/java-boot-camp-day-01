package sef.module04.activity;

public class Calculator {

    private String calculatorType;
    public static final String CALC_TYPE_BASIC = "Basic";

    // Parameterized constructor
    public Calculator(String calculatorType) {
        this.calculatorType = calculatorType;
    }

    // Getter for CalculatorType
    public String getCalculatorType() {
        return calculatorType;
    }

    // Setter for CalculatorType
    public void setCalculatorType(String calculatorType) {
        this.calculatorType = calculatorType;
    }

    // Add
    public int add(int x, int y) {
        return x + y; // add x and y and return the sum
    }

    // Subtract
    public int subtract(int x, int y) {
        int diff = x - y; // subtract y from x
        return diff;
    }

    // Multiply
    public int multiply(int[] numbers) {
        int temp = 1;

        for (int i = 0; i < numbers.length; i++) {
            temp = temp * numbers[i];
        }

        return temp;
    }

    // Divide
    public int divide(int x, int y) {
        int divValue = 0;

        if (y != 0) {
            divValue = x / y;
        } else {
            System.out.println("Error: Division by zero");
        }

        return divValue;
    }
}
