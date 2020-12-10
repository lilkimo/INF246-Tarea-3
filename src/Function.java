import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {
    static public Pattern functionGetter = Pattern.compile("(?<name>[a-zA-Z])\\((?<argument>(?: |[a-zA-z]|\\d|\\(|\\)|\\+|\\-|\\*|\\/)*)\\)");
    
    public Character parameter;
    public String equation;

    public Function(Character parameter, String equation) {
        this.parameter = parameter;
        this.equation = equation;
    }

    public String toString() {
        return parameter + ", " + equation;
    }

    static public List<String> getFunctions(String equation) {
        Matcher matcher = functionGetter.matcher(equation);
        Integer start = 0;
        List<String> toResolve = new ArrayList<>();
        while (matcher.find(start)) {
            toResolve.add(Equation.firstBalancedParenthesis(matcher.group()));
            start = matcher.start() + 1;
        }
        return toResolve;
    }
}
