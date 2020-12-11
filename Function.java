
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {
    static public Pattern functionGetter = Pattern.compile("(?<name>[a-zA-Z])\\((?<argument>(?: |[a-zA-z]|\\.|\\d|\\(|\\)|\\+|\\-|\\*|\\/)*)\\)");
    
    public Character parameter;
    public String equation;

    public Function(Character parameter, String equation) {
        this.parameter = parameter;
        this.equation = equation;
    }

    public String toString() {
        return parameter + ", " + equation;
    }

    public static List<String> getFunctions(String equation) {
        Matcher matcher = functionGetter.matcher(equation);
        Integer start = 0;
        List<String> toResolve = new ArrayList<>();
        while (matcher.find(start)) {
            toResolve.add(Equation.firstBalancedParenthesis(matcher.group()));
            start = matcher.start() + 1;
        }
        return toResolve;
    }

    public static String evaluate(Function function, String argument) {        
        String result = Equation.removeParenthesis(function.equation);
        argument = Equation.removeParenthesis(argument);
        if (Equation.haveOperators(argument) && Equation.haveOperators(result)) {
            result = result.replaceAll(Pattern.quote("(" + function.parameter + ")"), '(' + argument + ')');
            result = result.replaceAll(Pattern.quote(function.parameter.toString()), '(' + argument + ')');
        }
        else
            result = result.replaceAll(Pattern.quote(function.parameter.toString()), argument);
        return result;
    }

    public Character getparameter() {
        return parameter;
    }

    public void setParameter(Character parameter) {
        this.parameter = parameter;
    }
    
    public String getequation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }
}
