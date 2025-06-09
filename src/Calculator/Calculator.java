package Calculator;

import java.util.Scanner;

public class Calculator {

    public  static Scanner sc;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder expression = new StringBuilder();

        while (true) {
            System.out.println("\n======= CALCULATOR =======");
            System.out.println("Expression: " + expression.toString());
            System.out.print("Enter number/operator (C to clear, E to exit): ");
            String input = sc.next();

            if (input.equalsIgnoreCase("E")) {
                System.out.println("Exiting Calculator. Goodbye!");
                break;
            } else if (input.equalsIgnoreCase("C")) {
                expression.setLength(0);
            } else if (input.equals("=")) {
                try {
                    double result = CalculatorUtils.evaluate(expression.toString());
                    System.out.println("Result: " + result);
                    expression.setLength(0);
                    expression.append(result); // for continued calculation
                } catch (Exception e) {
                    System.out.println("Invalid Expression! " + e.getMessage());
                    expression.setLength(0);
                }
            } else {
                expression.append(input);
            }
        }

        sc.close();
    }
}
