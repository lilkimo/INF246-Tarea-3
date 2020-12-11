import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        /*for (Map.Entry<Character, Function> entry : functions.entrySet())
        System.out.println(entry.getKey() + ": " + entry.getValue().toString());*/
        //Mostrar el diccionario
        /*
        for (Map.Entry<Character, Function> entry : functions.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        */
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
        //System.out.println(Function.getFunctions("f(1+2+3)+g(4)"));
        //System.out.println(Function.getFunctions("g(1)*h(1)+1054"));

        //Ejemplo de uso de un MutableString
        /*
        MutableString a = new MutableString("f(x)+4");
        MutableString b = a;
        a.replaceAll("f\\(x\\)", "2");
        System.out.println(a);
        System.out.println(b);
        */

        //Lee el input
        /*
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese operacion");
        String operation = lector.nextLine();
        lector.close();

        SolverThread hebra = new SolverThread(operation, functions);
        hebra.start();
        try {
            hebra.join();
            System.out.println(functions);
        } catch (Exception e) {
            //TODO: handle exception
        }
        /*
        Boolean matchFound = matcher.find();
        if (matchFound) {
            System.out.println(matcher.group("name"));
            System.out.println(matcher.group("argument"));
            System.out.println(matcher.group("equation"));
        }
        else
            System.out.println("0 matches");
        */
        /*
        Equation equation = new Equation("(4+5*2/2)+(4/5-10*2)/2");
        System.out.println(equation);
        System.out.println(equation.solve());
        System.out.println(equation.solve());
        
        Solver hebra = new Solver(function, functions);
        */
    }
}
