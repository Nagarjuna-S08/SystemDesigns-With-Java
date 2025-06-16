package EquationOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Term {
    int val;
    ArrayList<Character> variables;
    int[] powers;

    @Override
    public String toString() {
        return "Term{" +
                "val=" + val +
                ", variables=" + variables +
                ", powers=" + Arrays.toString(powers) +
                '}';
    }

    Term(int value, ArrayList<Character> variables,int[] powers){
        this.val = value;
        this.variables = variables;
        this.powers = powers;
    }

    public Term multiple(Term t1) {
        int val = this.val * t1.val;
        Map<Character, Integer> powerMap = new LinkedHashMap<>();

        for (int i = 0; i < this.variables.size(); i++) {
            char var = this.variables.get(i);
            powerMap.put(var, this.powers[i]);
        }

        for (int i = 0; i < t1.variables.size(); i++) {
            char var = t1.variables.get(i);
            int pow = t1.powers[i];
            powerMap.put(var, powerMap.getOrDefault(var, 0) + pow);
        }

        ArrayList<Character> variableList = new ArrayList<>();
        int[] powerArray = new int[10];
        int index = 0;

        for (Map.Entry<Character, Integer> entry : powerMap.entrySet()) {
            variableList.add(entry.getKey());
            powerArray[index++] = entry.getValue();
        }

        Term result = new Term(val, variableList, powerArray);
        sortList(result.variables, result.powers);
        return result;
    }



    private void sortList(ArrayList<Character> variable,int[] power){
        for (int i = 0; i < variable.size() - 1; i++) {
            for (int j = 0; j < variable.size() - i - 1; j++) {
                if (variable.get(j) > variable.get(j + 1)) {
                    char temp = variable.get(j);
                    variable.set(j, variable.get(j + 1));
                    variable.set(j + 1, temp);
                    int tempInt = power[j];
                    power[j] = power[j+1];
                    power[j+1]=tempInt;
                }
            }
        }
    }

//    private combineVariable(Term t1){
//
//    }
}
