import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Problema1 {
    static private Pattern functionParser = Pattern.compile(" *(?<name>[a-zA-Z])\\((?<argument>[a-zA-Z])\\) *= *(?<equation>(?:[a-zA-z]|\\k<argument>|\\d|\\(|\\)|\\+|\\-|\\*|\\/)(?: |[a-zA-z]|\\k<argument>|\\d|\\(|\\)|\\+|\\-|\\*|\\/)*)");
    static private Map<Character, Function> functions = new HashMap<>();
    public static void main(String args[]) throws Exception {
        functions.clear();
        
        Matcher matcher;
        EquationReader equationReader = new EquationReader("input.txt");
        equationReader.Read();
        for (String line: equationReader.getLines()) {
            matcher = functionParser.matcher(line);
            if (matcher.find())
                functions.put(matcher.group("name").charAt(0), new Function(matcher.group("argument").charAt(0), matcher.group("equation").replaceAll("\s+", "")));
            else {
                throw new Exception("Function \"" + line + "\" cannot be parsed");
            }
        }
        System.out.println(Solver.solve("f(1)", functions));
        /*
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese operacion (-1 para Salir del programa): ");
        String operation = lector.nextLine();

        while(true){
            System.out.println(Solver.solve(operation, functions));
            System.out.println("Ingrese operacion (-1 para Salir del programa): ");
            operation = lector.nextLine();
            if (operation.equals("-1")){
                lector.close();
                break;
            }
        }
        */
        //System.out.println(Function.getFunctions("g(1)*h(1)+1054"));
    }
}
