import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Problema1 {
    static private Pattern functionParser = Pattern.compile(" *(?<name>[a-zA-Z])\\((?<argument>[a-zA-Z])\\) *= *(?<equation>(?:[a-zA-z]|\\k<argument>|\\.|\\d|\\(|\\)|\\+|\\-|\\*|\\/)(?: |[a-zA-z]|\\k<argument>|\\.|\\d|\\(|\\)|\\+|\\-|\\*|\\/)*)");
    static private Map<Character, Function> functions = new HashMap<>();
    public static void main(String args[]) throws Exception {
        System.out.println("\u001b[7m Problema 1 \033[0m");

        Matcher matcher;
        EquationReader equationReader = new EquationReader("input.txt");
        equationReader.Read();
        for (String line: equationReader.getLines()) {
            matcher = functionParser.matcher(line);
            if (matcher.find())
                functions.put(matcher.group("name").charAt(0), new Function(matcher.group("argument").charAt(0), matcher.group("equation").replaceAll("\\s+", "")));
            else {
                throw new Exception("Function \"" + line + "\" cannot be parsed");
            }
        }

        Scanner lector = new Scanner(System.in);
        while(true) {
            System.out.print("Ingrese operacion (ENTER para salir): \n>");
            String operation = lector.nextLine();
            if (operation.equals("")){
                lector.close();
                break;
            }
            System.out.println(Solver.solve(operation, functions));
        }
    }
}
