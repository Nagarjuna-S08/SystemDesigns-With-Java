package Calculator;

import java.util.*;

public class CalculatorUtils {

    public static double evaluate(String expr) {
        List<String> postfix = infixToPostfix(expr);
        return evaluatePostfix(postfix);
    }

    public static List<String> infixToPostfix(String expr) {
        List<String> output = new ArrayList<>();
        Stack<Character> ops = new Stack<>();
        int i = 0;

        while (i < expr.length()) {
            char ch = expr.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder num = new StringBuilder();
                while (i < expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
                    num.append(expr.charAt(i));
                    i++;
                }
                output.add(num.toString());
                continue;
            }

            if (isOperator(ch)) {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch)) {
                    output.add(String.valueOf(ops.pop()));
                }
                ops.push(ch);
            }

            i++;
        }

        while (!ops.isEmpty()) {
            output.add(String.valueOf(ops.pop()));
        }

        return output;
    }

    public static double evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();
        for (String token : postfix) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperator(a, b, token);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static double applyOperator(double a, double b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Divide by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    public static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static int precedence(char op) {
        return (op == '+' || op == '-') ? 1 : 2;
    }


}
