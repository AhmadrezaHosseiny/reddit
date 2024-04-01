import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Account {
    public static String email;
    public static String password;
    public static String extractUrl(String s) {
        String regex = "\\b(https?)://\\S+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            return matcher.group();
        }
        else {
            return null;
        }
    }
    public static boolean validateEmail(String s) {
        String regex = "\\b[\\w.\\-_]+@\\w+\\.\\S+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        return matcher.find();
    }
    public static boolean validatePassword(String s) {
        return s.equals(password);
    }




}
