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
}
