import java.util.ArrayList;
import java.util.UUID;


/* Representing specific courses offered at Hogwarts School of Witchcraft and Wizardry,
 the Course class is capable of setting course information.*/
public class Course {
    private String _title; // Store the title of the course.
    private ArrayList<Student> _students = new ArrayList<>(); // Maintain a list of students enrolled in the course (students).
    private UUID courseId; // Assign a unique identifier to each course (courseID), represented by a UUID.
    public ArrayList<Score> scores = new ArrayList<>();
    public Teacher _teacher; // Track the teacher assigned to teach the course (teacher).
    Course(UUID pID, String title) {
        Hogwarts.log("course constructor start");
        courseId = pID;
        _title = title;
        Hogwarts.courses.add(this);
        Hogwarts.log("course " + courseId.toString() + " " + _title + " constructed.");
    }
    public static Course create(String title) {
        Hogwarts.log("create start");
        return new Course(UUID.randomUUID(), title);
    }
    public UUID getCourseId() {
        Hogwarts.log("getCourseId start");
        return courseId;
    }
    public String getTitle() {
        Hogwarts.log("getTitle start");
        return _title;
    }
    public void setTitle(String title) {
        Hogwarts.log("course.setTitle start");
        this._title = title;
    }
    public Teacher getTeacher() {
        Hogwarts.log("getTeacher start");
        return _teacher;
    }
    public void setTeacher(Teacher _teacher) {
        Hogwarts.log("setTeacher start");
        _teacher.addCourse(this);
        this._teacher = _teacher;
    }
    public void enroll(Student pStudent) {
        Hogwarts.log("enroll start");
        _students.add(pStudent);
        pStudent.addCourse(this);
    }
    public ArrayList<Student> getEnrolledStudents() {
        Hogwarts.log("getEnrolledStudents start");
        return _students;
    }
    public void showStudents( ) {
        Hogwarts.log("showStudents start");
        showStudents("\t\t");
    }
    public void showStudents(String prefix) {
        Hogwarts.log("showStudents start");
        for (Student s : _students) {
            s.show(prefix);
        }
    }
    public void show() {
        Hogwarts.log("show start");
        System.out.println("\r\ncourseId: " + this.courseId.toString());
        System.out.println("title: " + this.getTitle());
        Hogwarts.log("show end");
    }
    /*public static Course retrieveByUuid(UUID Id) {
        for (Course c : Hogwarts.courses) {
            if (Id.equals(c.courseId)) {
                return c;
            }
        }
        return null;
    }*/
    public void showScore() {
        this.show();
        for (Score s : this.scores) {
            System.out.print(s.student.studentFullName);
            System.out.print(" ");
            System.out.println(s.result);
        }
    }
}
