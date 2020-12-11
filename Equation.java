import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Equation {
    private static final Map<Character, Integer> precedence;
    static {
        Map<Character, Integer> _precedence = new HashMap<>();
        _precedence.put('*', 2);
        _precedence.put('/', 2);
        _precedence.put('+', 1);
        _precedence.put('-', 1);
        precedence = Collections.unmodifiableMap(_precedence);
    }
    private static final Set<Character> operators = Set.of('*', '/', '+', '-');

    private String[] stringOperands = {null, null};
    private Equation[] operands = {null, null};
    private Character operator = null;
    private Float value = null;

    public Equation(String equation) throws Exception {
        if (equation.charAt(0) == '(' && equation.charAt(equation.length() - 1) == ')') {
            String withoutParenthesis = equation.substring(1, equation.length() - 1);
            if (haveBalancedParenthesis(withoutParenthesis))
                equation = withoutParenthesis;
        }
        
        Integer openParenthesis = 0;
        String lastValidSlice = new String();
        Integer lastValidSliceIndex = -1;

        Character character;
        String currentSlice = new String();
        for (Integer i = 0; i < equation.length(); i++) {
            character = equation.charAt(i);
            if (character == '(') {
                openParenthesis += 1;
            }
            else if (character == ')') {
                openParenthesis -= 1;
                if (openParenthesis < 0)
                    throw new Exception("Invalid Equation (Unbalanced parenthesis)");
            }
            else if (openParenthesis == 0 && operators.contains(character)) {
                if (getOperator() != null && precedence.get(character) > precedence.get(getOperator()))
                    continue;
                
                setOperator(character);
                lastValidSlice = currentSlice;
                lastValidSliceIndex = i+1;
            }
            currentSlice += character;
        }
        if (openParenthesis < 0)
            throw new Exception("Invalid Equation (Unbalanced parenthesis)");
        
        if (lastValidSliceIndex == -1) {
            value = Float.parseFloat(currentSlice);
        }
        else {
            setOperand(lastValidSlice, 0);
            setOperand(equation.substring(lastValidSliceIndex, equation.length()), 1);
        }
    }

    public static Boolean haveBalancedParenthesis(String equation) {
        Integer openParenthesis = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '(') {
                openParenthesis += 1;
            }
            else if (equation.charAt(i) == ')') {
                openParenthesis -= 1;
                if (openParenthesis < 0)
                    return false;
            }
        }
        if (openParenthesis == 0)
            return true;
        return false;
    }

    public static String firstBalancedParenthesis(String equation) {
        Integer openParenthesis = 0;
        Boolean haveParenthesis = false;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '(') {
                haveParenthesis = true;
                openParenthesis += 1;
            }
            else if (equation.charAt(i) == ')') {
                openParenthesis -= 1;
                if (openParenthesis < 0)
                    return null;
            }
            if (openParenthesis == 0 && haveParenthesis)
                return equation.substring(0, i+1);
        }
        return null;
    }

    public static Boolean haveOperators(String equation) {
        for (Integer i = 0; i < equation.length(); i++)
            if (operators.contains(equation.charAt(i)))
                return true;
        return false;
    }
    
    public void setOperand(String operand, Integer index) throws Exception {
        if (operand.charAt(0) == '(' && operand.charAt(operand.length() - 1) == ')') {
            String withoutParenthesis = operand.substring(1, operand.length() - 1);
            if (haveBalancedParenthesis(withoutParenthesis)) {
                operands[index] = new Equation(withoutParenthesis);
                stringOperands[index] = withoutParenthesis;
                return;
            }
        }
        operands[index] = new Equation(operand);
        stringOperands[index] = operand;
    }

    public Equation getOperand(Integer index) {
        return operands[index];
    }

    public void setOperator(Character operator) {
        this.operator = operator;
    }

    public Character getOperator() {
        return operator;
    }

    public Float solve() {
        if (value == null) {
            switch (operator) {
                case '*':
                    value = getOperand(0).solve() * getOperand(1).solve();
                    break;
                case '/':
                    value = getOperand(0).solve() / getOperand(1).solve();
                    break;
                case '+':
                    value = getOperand(0).solve() + getOperand(1).solve();
                    break;
                case '-':
                    value = getOperand(0).solve() - getOperand(1).solve();
                    break;
            }
        }
        return value;
    }

    public String toString() {
        if (value != null)
            return value.toString();
        
        String equation = new String();
        equation += operator;
        equation += "; ";
        equation += stringOperands[0];
        equation += ", ";
        equation += stringOperands[1];
        return equation;
    }
}
