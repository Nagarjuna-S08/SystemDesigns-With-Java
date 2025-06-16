package EquationOperations;

public class Main {
    public static void main(String[] args) {
        Equation e = Equation.parse("2xy3+3y");
        System.out.println(e);
        Equation e1 = Equation.parse("2x+4y3+1z+3j2");
        System.out.println(e1);
        System.out.println(e.multiply(e1));
    }
}
