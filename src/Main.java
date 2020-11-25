import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    static private Pattern equationParser = Pattern.compile(" *(?<function>[a-zA-Z])\\((?<argument>[a-zA-Z])\\) *= *(?<equation>(?:\\k<argument>|\\d|\\(|\\)|\\+|\\-|\\*|\\/)+) *");
    public static void main(String args[]) {
        Matcher matcher = equationParser.matcher("f(x)=2*x+3");
        Boolean matchFound = matcher.find();
        if (matchFound) {
            System.out.println(matcher.group("function"));
            System.out.println(matcher.group("argument"));
            System.out.println(matcher.group("equation"));
        }
        else
            System.out.println("0 matches");
    }
}
