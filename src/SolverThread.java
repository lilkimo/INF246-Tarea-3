import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolverThread extends Thread {
    static private Pattern inputParser = Pattern.compile("(?<name>[a-zA-Z])\\((?<argument>\\d+)\\)");
    private String operation;
    private Map<Character, Function> functions;

    public SolverThread(String operation, Map<Character, Function> functions) {
        this.operation = operation;
        this.functions = functions;
    }

    public void run() {
        // Cambiarlo a clase InputParser
        Matcher matcher = inputParser.matcher(operation);
        Boolean matchFound = matcher.find();
        if (!matchFound) {
            System.out.println("Operacion Invalida.");
            System.exit(1);
        }
        Character nameFunctionInput = matcher.group("name").charAt(0);
        Character parameterFunctionInput = matcher.group("argument").charAt(0);

        Function actualFunc = functions.get(nameFunctionInput); // obtengo el parametro x y cuerpo g(x)*h(x) de la funcion f

        String actualEquation = actualFunc.getequation();// Cambio el parametro de la funcion a 1
        String evaluatedEquation = actualEquation.replace(actualFunc.getparameter(), parameterFunctionInput);
        actualFunc.setEquation(evaluatedEquation);
        functions.replace(nameFunctionInput, actualFunc);

        actualEquation = actualFunc.getequation();
        FoundFunctions foundFunctions = new FoundFunctions(actualEquation);
        foundFunctions.parseFunctions();
        if (foundFunctions.getCantFunctions() == 0) {// Si no hay funciones en la ecuacion
            try {
                Equation objEquation = new Equation(actualEquation);
                String solvedEquation = String.valueOf(objEquation.solve());
                actualFunc.setEquation(solvedEquation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        else {// Si hay funciones en la ecuacion
            List<String> listOfFunctions = foundFunctions.getListOfFunctions();
            for (int i = 0; i < listOfFunctions.size(); i++) {
                SolverThread hebra = new SolverThread(listOfFunctions.get(i), functions);
                hebra.start();
                try {
                    hebra.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //Actualizo el valor de la ecuacion, una vez por funcion anidada
                String functionEvaluated = functions.get(listOfFunctions.get(i).charAt(0)).getequation();
                actualEquation = actualFunc.getequation();
                evaluatedEquation = actualEquation.replace(listOfFunctions.get(i), functionEvaluated);
                actualFunc.setEquation(evaluatedEquation);
            }
            //Resuelvo la ecuacion resultante
            try {
                Equation objEquation = new Equation(actualEquation);
                String solvedEquation = String.valueOf(objEquation.solve());
                actualFunc.setEquation(solvedEquation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
