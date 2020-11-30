
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Main {
    static private Pattern functionParser = Pattern.compile(
            " *(?<name>[a-zA-Z])\\((?<argument>[a-zA-Z])\\) *= *(?<equation>(?:\\k<argument>|\\d|\\(|\\)|\\+|\\-|\\*|\\/)+) *");
    static private Pattern inputParser = Pattern.compile(
        "(?<name>[a-zA-Z])\\((?<argument>\\d+)\\)");

    public static void main(String args[]) throws FileNotFoundException {
        /*Matcher matcher = functionParser.matcher("f(x)=2*x+3");
        Boolean matchFound = matcher.find();
        if (matchFound) {
            System.out.println(matcher.group("name"));
            System.out.println(matcher.group("argument"));
            System.out.println(matcher.group("equation"));
        }
        else
            System.out.println("0 matches");*/

        //Read Text
        FileReader fileReader = new FileReader("input.txt");
        fileReader.Read();
        System.out.println("Funciones ingresadas!");

        //Get values from Text
        List<String> equations = new ArrayList<String>();
        equations = fileReader.getLines();
        Integer numEquations = Integer.valueOf(equations.get(0));
        
        //Read Input from users
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese operacion");
        String Function = lector.nextLine();

        //Get values from input
        Matcher matcher = inputParser.matcher(Function);
        Boolean matchFound = matcher.find();
        if (matchFound){
            String nameFunction = matcher.group("name");
            Integer argument = Integer.valueOf(matcher.group("argument"));
        }
        else
            System.out.println("Operacion Invalida.");
            System.exit(1);
        lector.close();
        
        MyThread hebra = new MyThread(equations, 1);
        for (Integer i = 1; i < numEquations; i++){
            
        }

        /*for (int i = 0; i < 3; i++){ Creacion de las hebras
            MyThread hebra = new MyThread();
            hebra.start();
        }*/
    }
}