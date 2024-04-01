import java.util.ArrayList;
public class Reddit {
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static boolean debug = false;
    public static String prefix = "-->";
    public static Account currentAccount;
    public static void show(String s) {
        if (debug) System.out.println(prefix + s);
    }
    public static void init() {
        show("Init started.");
        System.out.println("\r\nInitialising...\r\n");
    }
}
