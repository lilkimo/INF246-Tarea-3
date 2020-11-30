import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Problema1 {
    static private Pattern functionParser = Pattern.compile(" *(?<name>[a-zA-Z])\\((?<argument>[a-zA-Z])\\) *= *(?<equation>(?:\\k<argument>|\\d|\\(|\\)|\\+|\\-|\\*|\\/)+) *");
    public static void main(String args[]) throws Exception {
        /*
        Matcher matcher = functionParser.matcher("f(x)=2*x+3");
        Boolean matchFound = matcher.find();
        if (matchFound) {
            System.out.println(matcher.group("name"));
            System.out.println(matcher.group("argument"));
            System.out.println(matcher.group("equation"));
        }
        else
            System.out.println("0 matches");
        */
        Equation equation = new Equation("(4+5*2/2)+(4/5-10*2)/2");
        System.out.println(equation);
        System.out.println(equation.solve());
        System.out.println(equation.solve());
    }
}
