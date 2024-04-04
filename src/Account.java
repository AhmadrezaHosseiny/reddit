import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Account {
    public String username;
    public String email;
    public String password;
    Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public static Account logIn(String email, String password) {
        for (Account a : Reddit.accounts) {
            if (a.email.equals(email) && a.password.equals(password)) {
                return a;
            }
        }
        return null;
    }
    public boolean validateEmail() {
        String regex = "\\b[\\w.\\-_]+@\\w+\\.\\S+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.email);

        return matcher.find();
    }
    public boolean validatePassword() {
        return !password.isEmpty();
    }




}
