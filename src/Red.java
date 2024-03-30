import java.util.ArrayList;


/* Serving as a central management system for Hogwarts School of Witchcraft and Wizardry,
 the Hogwarts class facilitates various actions for teachers, students, and administrators.*/
public class Red {
    //public static ArrayList<Teacher> teachers = new ArrayList<>();
    //public static ArrayList<Course> courses = new ArrayList<>();
    //public static ArrayList<Student> students = new ArrayList<>();
    //public static ArrayList<Account> accounts = new ArrayList<>();
    //public static Account currentAccount;
    public static boolean debug = false;
    public static String prefix = "-->";
    public static void log(String s) {
        if (debug) System.out.println(prefix + s);
    }
    public static void Init() {
        log("Init start.");
        System.out.println("\r\nInitialising...\r\n");
    }
}
