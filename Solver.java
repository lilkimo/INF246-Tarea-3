import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<Solver> solving = new ArrayList<Solver>();
        MutableString functionEvaluated = new MutableString(Function.evaluate(functions.get(input.charAt(0)), input.substring(2, input.length() - 1)));

        for (String function : Function.getFunctions(functionEvaluated.toString())) {
            Solver thread = new Solver(functionEvaluated, function, functions);
            thread.start();
            solving.add(thread);

        }

        for (Solver inSolving : solving) {
            try {
                inSolving.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        try {
            Equation result = new Equation(functionEvaluated.toString());
            solution.replaceAll(input, '(' + result.solve().toString() + ')', true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Float solve(String input, Map<Character, Function> functions) {
        MutableString solution = new MutableString(input);
        List<Solver> solving = new ArrayList<>();

        for (String function: Function.getFunctions(input)) {
            Solver thread = new Solver(solution, function, functions);
            thread.start();
            solving.add(thread);
        }

        for (Solver inSolving: solving){
            try {
                inSolving.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            Equation result = new Equation(solution.toString());
            return result.solve();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}