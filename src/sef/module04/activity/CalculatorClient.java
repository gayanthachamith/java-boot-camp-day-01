package sef.module04.activity;

public class CalculatorClient {

    public static void main(String[] args) {

        int x = 10;
        int y = 5;
        int[] numbers = {2, 3, 4};
        // Create Calculator object using constant
        Calculator calculator = new Calculator(Calculator.CALC_TYPE_BASIC);

        // Display calculator type
        System.out.println("Calculator Type: " + calculator.getCalculatorType());

        // Add
        int sum = calculator.add(x, y);
        System.out.println("Addition: " + sum);

        // Subtract
        int diff = calculator.subtract(x, y);
        System.out.println("Subtraction: " + diff);

        // Multiply
        int product = calculator.multiply(numbers);
        System.out.println("Multiplication: " + product);

        // Divide
        int division = calculator.divide(x, y);
        System.out.println("Division: " + division);
    }
}
