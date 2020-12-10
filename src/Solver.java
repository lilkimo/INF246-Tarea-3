import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.security.ec.point.ProjectivePoint.Mutable;


public class Solver extends Thread {
    private MutableString solution;
    private String input;
    private Map<Character, Function> functions;
    
    public Solver(MutableString solution, String input, Map<Character, Function> functions){
        this.solution = solution;
        this.input = input;
        this.functions = functions;
    }

    public void run(){
        List<String> toResolve = Function.getFunctions(input);
        
        Function functionToSolve;
        String functionEvaluated;
        String argument;
        for (String function: toResolve) {
            functionToSolve = functions.get(function.charAt(0));
            argument = function.substring(2, function.length()-1);
            functionEvaluated = functionToSolve.equation.replaceAll(functionToSolve.parameter.toString(), argument);
            
            solution.replaceAll(function, '(' + functionEvaluated + ')', true);
            // Crear una nueva hebra con input = functionEvaluated
        }
        //Esperar a que las hebras creadas terminen.
    }

    public static String solve(String input, Map<Character, Function> functions) {
        MutableString solution = new MutableString(input);
        List<String> toResolve = Function.getFunctions(input);

        Function functionToSolve;
        String functionEvaluated;
        String argument;
        for (String function: toResolve) {
            functionToSolve = functions.get(function.charAt(0));
            argument = function.substring(2, function.length()-1);
            functionEvaluated = functionToSolve.equation.replaceAll(functionToSolve.parameter.toString(), argument);

            solution.replaceAll(function, '(' + functionEvaluated + ')', true);
            //Crear una nueva hebra con input = function Evaluated
        }
        //Esperar a que las hebras creadas terminen.
        return solution.toString();
    }
}
