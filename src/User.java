import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class User {
    public static void logIn() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Enter your email: ");
            String email = br.readLine();
            System.out.print("Enter your password: ");
            String password = br.readLine();
            for (Account a : Reddit.accounts) {
                if (Account.validateEmail(Account.email) && Account.validatePassword(Account.password)) {
                    Reddit.currentAccount = a;
                    System.out.println("Log in successfully.");
                    return;
                }
            }
        }
    }
    public static void logOut() {

    }


}
