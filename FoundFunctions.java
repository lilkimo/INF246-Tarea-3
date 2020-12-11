import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoundFunctions {

    private String equation;
    private List<String> listOfFunctions;
    private Integer cantFunctions;
    private List<Character> abecedario = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z');

    public FoundFunctions(String equation){
        this.equation = equation;
        this.listOfFunctions = new ArrayList<String>();
        this.cantFunctions = 0;
    }

    public Integer getCantFunctions() {
        return cantFunctions;
    }
    
    public String getEquation() {
        return equation;
    }

    public List<String> getListOfFunctions() {
        return listOfFunctions;
    }

    public void parseFunctions(){
        for (int i = 0; i < equation.length(); i++){
            if (abecedario.contains(equation.charAt(i))){
                List<Character> array = Arrays.asList(equation.charAt(i), equation.charAt(i+1), equation.charAt(i+2),equation.charAt(i+3));
                StringBuilder sb = new StringBuilder();
                for (Character s : array) {
                    sb.append(s);
                }
                listOfFunctions.add(sb.toString());
                cantFunctions ++;
            }
        }
    }
    /*public static void main(String[] args) {
        String prueba = "g(1)*h(1)+1054";
        FoundFunctions foundFunctions = new FoundFunctions(prueba);
        foundFunctions.parseFunctions();
        System.out.println(foundFunctions.getListOfFunctions());
    }*/


}
