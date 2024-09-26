import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDriver {

    static void process(String regexString, String target) {
        // Creating a pattern
        Pattern pattern = Pattern.compile(regexString);
        System.out.println("\n==== Pattern `" + pattern.pattern() + "` =====");
        // Creating a matcher for the input
        Matcher matcher = pattern.matcher(target);
        // Checking for a match and find
        System.out.println("Pattern matched for target `" + target
                + "`: " + (matcher.matches() ? "Yes" : "No"));
        System.out.println("Pattern found in target `" + target
                + "`: " + (matcher.find() ? "Yes" : "No"));
        System.out.println("=============================\n");
    }

    // Main driver method
    public static void main(String[] args) {
        process("^([ab]?|c?)$", "ac");
        //process("[a-zA-Z]*", "hello!");
    }
}
