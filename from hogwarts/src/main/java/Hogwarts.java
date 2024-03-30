import java.util.ArrayList;


/* Serving as a central management system for Hogwarts School of Witchcraft and Wizardry,
 the Hogwarts class facilitates various actions for teachers, students, and administrators.*/
public class Hogwarts {
    public static ArrayList<Teacher> teachers = new ArrayList<>();
    public static ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static Account currentAccount;
    public static boolean debug = false;
    public static String prefix = "-->";
    public static void log(String s) {
        if (Hogwarts.debug) System.out.println(prefix + s);
    }
    public static void Init() {
        Hogwarts.log("init start");
        System.out.println("\r\ninitialising...\r\n");

        Hogwarts.log(Integer.toString(Hogwarts.teachers.size()));
        Teacher t1 = Teacher.create("Ali");
        Hogwarts.log(Integer.toString(Hogwarts.teachers.size()));
        Teacher t2 = Teacher.create("Hassan");
        Hogwarts.log(Integer.toString(Hogwarts.teachers.size()));
        Teacher t3 = Teacher.create("John");
        Hogwarts.log(Integer.toString(Hogwarts.teachers.size()));

        Student s1 = Student.create("Alice");
        Hogwarts.log(Integer.toString(Hogwarts.students.size()));
        Student s2 = Student.create("Bob");
        Hogwarts.log(Integer.toString(Hogwarts.students.size()));
        Student s3 = Student.create("Charlie");
        Hogwarts.log(Integer.toString(Hogwarts.students.size()));
        Student s4 = Student.create("Dan");
        Hogwarts.log(Integer.toString(Hogwarts.students.size()));
        Student s5 = Student.create("Erfan");
        Hogwarts.log(Integer.toString(Hogwarts.students.size()));
        Student s6 = Student.create("Farid");
        Hogwarts.log(Integer.toString(Hogwarts.students.size()));

        Course c1 = Course.create("C++");
        Course c2 = Course.create("Python");
        Course c3 = Course.create("Java");

        c1.setTeacher(t1);
        c2.setTeacher(t2);
        c3.setTeacher(t2);

        c1.enroll(s1);
        c1.enroll(s2);
        c1.enroll(s3);
        c2.enroll(s1);
        c2.enroll(s2);

        Account a1 = new Account("a", "1");

        Score x1 = new Score(s1, 1);
        Score x2 = new Score(s2, 2);
        Score x3 = new Score(s3, 3);

        Score x4 = new Score(s1, 4);
        Score x5 = new Score(s2, 5);
        Score x6 = new Score(s3, 6);

        Score x7 = new Score(s4, 7);
        Score x8 = new Score(s5, 8);
        Score x9 = new Score(s6, 9);

        c1.scores.add(x1);
        c1.scores.add(x2);
        c1.scores.add(x3);

        c2.scores.add(x4);
        c2.scores.add(x5);
        c2.scores.add(x6);

        c3.scores.add(x7);
        c3.scores.add(x8);
        c3.scores.add(x9);
    }
    public void viewAllTeachers() {
        for (Teacher t : Hogwarts.teachers) t.show("");
    }
    public void viewAllStudents() {
        for (Student s : Hogwarts.students) s.show();
    }
    public void viewAllCourses() {
        for (Course c : Hogwarts.courses) c.show();
    }

    //TODO: Rating teachers and leaving comments for them.
    //TODO: Requesting courses and submitting scores for students.
    //TODO :Requesting courses as a teacher.
    //TODO: Rating teachers and leaving comments for them as a student.
}
