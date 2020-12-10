import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solver extends Thread {
    static private Pattern inputParser = Pattern.compile("(?<name>[a-zA-Z])\\((?<argument>\\d+)\\)");
    private String function;
    private Map<Character, Function> functions;
    
    public Solver(String function, Map<Character, Function> functions){
        this.function = function;
        this.functions = functions;
    }
    public void run(){
        //Cambiarlo a clase InputParser
        Matcher matcher = inputParser.matcher(function);
        Boolean matchFound = matcher.find();
        if (!matchFound){
            System.out.println("Operacion Invalida.");
            System.exit(1);
        }
        String nameFunction = matcher.group("name");
        Function actualFunc = functions.get(nameFunction.charAt(0));

        String actualEquation = actualFunc.getequation();
        

    }

    public static void solve(String input, Map<Character, Function> functions) {
        MutableString solution = new MutableString(input);
        List<String> toResolve = Function.getFunctions(input);

        Function functionToSolve;
        String functionEvaluated;
        String argument;
        for (String function: toResolve) {
            System.out.println(function);
            functionToSolve = functions.get(function.charAt(0));
            argument = function.substring(2, function.length()-1);
            functionEvaluated = functionToSolve.equation.replaceAll(functionToSolve.parameter.toString(), argument);
            solution.replaceAll(function, functionEvaluated, true);
        }
        System.out.println(solution);
    }
}
