import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Solver extends Thread {
    private MutableString solution;
    private String input;
    private Map<Character, Function> functions;

    public Solver(MutableString solution, String input, Map<Character, Function> functions) {
        this.solution = solution;
        this.input = input;
        this.functions = functions;
    }
    public void run() {
        List<String> toResolve = Function.getFunctions(input);
        List<Solver> MyThreads = new ArrayList<Solver>();
        Function functionToSolve;
        String functionEvaluated;
        String argument;
        for (String function : toResolve) {
            functionToSolve = functions.get(function.charAt(0));
            argument = function.substring(2, function.length() - 1);
            functionEvaluated = functionToSolve.equation.replaceAll(functionToSolve.parameter.toString(), argument);

            solution.replaceAll(function, '(' + functionEvaluated + ')', true);
            System.out.println(solution);
            Solver thread = new Solver(solution, functionEvaluated, functions);
            thread.start();
            MyThreads.add(thread);
        }
        for (Solver mythread : MyThreads){
            try {
                mythread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Float solve(String input, Map<Character, Function> functions) {
        MutableString solution = new MutableString(input);
        List<String> toResolve = Function.getFunctions(input);
        List<Solver> MyThreads = new ArrayList<Solver>();
        Function functionToSolve;
        String functionEvaluated;
        String argument;
        for (String function : toResolve) {
            functionToSolve = functions.get(function.charAt(0));
            argument = function.substring(2, function.length() - 1);
            functionEvaluated = functionToSolve.equation.replaceAll(functionToSolve.parameter.toString(), argument);

            solution.replaceAll(function, '(' + functionEvaluated + ')', true);
            System.out.println(solution);
            // Crear una nueva hebra con input = function Evaluated
            Solver thread = new Solver(solution, functionEvaluated, functions);
            thread.start();
            MyThreads.add(thread);
        }
        for (Solver mythread : MyThreads){
            try {
                mythread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Esperar a que las hebras creadas terminen.
        try {
            Equation result = new Equation(solution.toString());
            return result.solve();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
