import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Reddit {
    public static boolean debug = false;
    public static String prefix = "-->";
    public static Account currentAccount;
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<Subreddit> subreddits = new ArrayList<>();

    public static void show(String s) {
        if (debug) System.out.println(prefix + s);
    }

    public static void init() {
        System.out.println("\r\nInitialising...\r\n");
        Account a1 = new Account("u1", "e1@.com", "p1");
        Reddit.accounts.add(a1);
    }

    public static void createAccount() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean valid = false;
        boolean duplicate = false;
        while (!valid) {
            System.out.print("Enter your username: ");//todo check amd repeat if bad input
            String username = br.readLine();
            System.out.print("Enter your email: ");
            String email = br.readLine();
            System.out.print("Enter your password: ");
            String password = br.readLine();
            Account a = new Account(username, email, password);
            if (!a.validateEmail()) {
                System.out.println("Your email is not valid.");
                continue;
            }
            if (!a.validatePassword()) {
                System.out.println("Your password is not valid.");
                continue;
            }
            for (Account b : Reddit.accounts) {
                if (b.email.equals(a.email)) {
                    System.out.println("Your email has been duplicated twice.");
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                duplicate = false;
                continue;
            }
            else {
                Reddit.accounts.add(a);
                System.out.println("\r\nAccount created successfully.");
                System.out.println(a.username);
                System.out.println(a.email);
                System.out.println(a.password);
                System.out.println();
                valid = true;
            }
        }
    }
    public static void logIn() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter your email: ");
            String email = br.readLine();
            System.out.print("Enter your password: ");
            String password = br.readLine();
            Account a = Account.logIn(email, password);
            if (a != null) {
                Reddit.currentAccount = a;
                System.out.println();
                System.out.println("Log in successfully.");
                System.out.println();
                System.out.println(a.username);
                System.out.println(a.email);
                System.out.println(a.password);
                System.out.println();
                valid = true;
            }
            System.out.println();
            System.out.println("Log in unsuccessfully.");
            System.out.println();
        }
    }
    public static void logOut() throws IOException {
        currentAccount.username = null;
        currentAccount.email = null;
        currentAccount.password = null;
        System.out.println("Log out successfully.");
        Reddit.logIn();
    }
    public static void edit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter your username: ");
            String username = br.readLine();
            System.out.print("Enter your email: ");
            String email = br.readLine();
            System.out.print("Enter your password: ");
            String password = br.readLine();
            Account a = new Account(username, email, password);
            if (a.validateEmail() && a.validatePassword()) {
                Reddit.currentAccount.username = a.username;
                Reddit.currentAccount.email = a.email;
                Reddit.currentAccount.password = a.password;
                System.out.println("Account edited successfully.");
                System.out.println(a.username);
                System.out.println(a.email);
                System.out.println(a.password);
                System.out.println();
                valid = true;
            }
            else {
                System.out.println("Account edited unsuccessfully.");
            }
        }
    }
    public static void join() {
        // todo show subreddit list select one to join
    }
    public static void viewAllPosts() {
        for (Post p : Subreddit.posts) {
            //p.showPostText();
        }
    }







}
