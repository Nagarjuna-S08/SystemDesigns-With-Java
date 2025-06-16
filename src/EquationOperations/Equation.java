package EquationOperations;

import java.util.ArrayList;

public class Equation {
    ArrayList<Term> terms;

    Equation(){
        terms = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Equation{" +
                "terms=" + terms +
                '}';
    }


    public Equation multiply(Equation e1) {
        Equation result = new Equation();
        for (Term term1 : this.terms) {
            for (Term term2 : e1.terms) {
                Term combinedTerm = term1.multiple(term2);
                result.terms.add(combinedTerm);
            }
        }
        return result;
    }

    public static Equation parse(String s){

        Equation obj = new Equation();
        int num = 0,i=0,sign=1;
        char[] array = s.toCharArray();

        String str;
        int[] power;
        ArrayList<Character> variable;

        if(array[i]=='-'){
            sign*=-1;
            i++;
        }

        while (i < array.length){
            if( array[i]=='+' || array[i]=='-' ){
                if(array[i]=='-'){
                    sign*=-1;
                }
            }
            else if( ((int)array[i]) > 96 ){
                int endIndex = findRemaining(i,array);

                power = splitPower(array,i,endIndex);
                variable = splitVariable(array,i,endIndex);

                Term t = new Term(num*sign,variable,power);
                obj.terms.add(t);

                sign=1;
                num = 0;
                i = endIndex-1;
            }
            else{
                num = num * 10 + (array[i]-'0');
            }
            i++;
        }

        return obj;
    }

    private static int[] splitPower(char[] arr, int str, int end){
        int i=str;
        int[] number = new int[10];
        int index=0;
        while (i<end){
            int power = 1;
            if( i+1<end && Character.isDigit(arr[i+1])){
                power = arr[i+1]-'0';
                i++;
            }
            number[index]=power;
            index++;
            i++;
        }
        return number;
    }

    private static ArrayList<Character> splitVariable(char[] arr, int str, int end){
        int i=str;
        ArrayList<Character> variable = new ArrayList<>();
        while (i<end){
            if( (int)arr[i] >=65 && (int)arr[i]<=122 ){
                variable.add(arr[i]);
            }
            i++;
        }

        return variable;
    }

    private static int findRemaining(int index,char[] arr){
        int i=index;

        while (i < arr.length){
            if( (int)arr[i] >= 48 ){
                i++;
                continue;
            }
            break;
        }

        return i;
    }
}
