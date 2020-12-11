import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MutableString {
    private StringBuilder content;

    public MutableString(String content) {
        this.content = new StringBuilder(content);
    }

    public void replaceAll(String regex, String replacement) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        
        Integer start = 0;
        while (matcher.find(start)) {
            content.replace(matcher.start(), matcher.end(), replacement);
            start = matcher.start() + replacement.length();
        }
    }

    public void replaceAll(String regex, String replacement, Boolean literal) {
        Pattern pattern;
        if (literal)
            pattern = Pattern.compile(regex, Pattern.LITERAL);
        else
            pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        
        Integer start = 0;
        while (matcher.find(start)) {
            content.replace(matcher.start(), matcher.end(), replacement);
            start = matcher.start() + replacement.length();
        }
    }

    public char charAt(int index) {
        return content.charAt(index);
    }

    public int length() {
        return content.length();
    }

    public String substring(int beginIndex, int endIndex) {
        return content.substring(beginIndex, endIndex);
    }

    public String toString() {
        return content.toString();
    }
}
