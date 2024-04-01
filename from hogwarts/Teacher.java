import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;


/* Teachers should be able to manage courses, score students,
 and access valuable information to enhance their teaching experience on the platform.*/
public class Teacher {
    private ArrayList<Course> _courses = new ArrayList<>();
    private UUID _teacherId;
    private String _fullName;
    public double teacherScore;
    Teacher(UUID pID, String pFullName) {
        Hogwarts.log("teacher constructor start");
        _teacherId = pID;
        _fullName = pFullName;
        Hogwarts.teachers.add(this);
        Hogwarts.log("teacher " + _teacherId.toString() + " " + _fullName + " constructed.");
    }
    public static Teacher create(String pFullName) {
        Hogwarts.log("create start");
        return new Teacher(UUID.randomUUID(), pFullName);
    }
    public String getFullName() {
        Hogwarts.log("getFullName start");
        return _fullName;
    }
    public UUID getTeacherId() {
        Hogwarts.log("getTeacherId start");
        return _teacherId;
    }



    //TODO: Sign Up: Teachers can sign up by following these steps:
    //      Request an account by contacting the assistant.
    //      Upon receiving access, provide necessary information to complete the sign-up process.

    // Take Courses: Teachers can explore and enroll in courses they wish to teach, displayed on their dashboard.
    public void takeCourse(Course pCourse) {
        Hogwarts.log("takeCourse start");
        _courses.add(pCourse);
        pCourse.setTeacher(this);
        Hogwarts.log("takeCourse end");
    }


    //TODO: Score Students: Teachers can evaluate students by navigating to the scoring section on their dashboard,
    //                      selecting the appropriate course, and entering scores for each student.
    public void showScore() throws IOException {
        for (Course c : this._courses) {
            c.showScore();
        }
    }
    public void addCourse(Course c) {
        _courses.add(c);
    }
    public static void showScoreForAllTeachers() throws IOException {
        for (Teacher t : Hogwarts.teachers) {
            t.show("");
            t.showScore();
        }
    }
    public void addScore(Course c) throws IOException {
        System.out.println("Enter student fullName: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fullName = reader.readLine();
        for (Student s : ) {
            if (s.studentFullName.equals(fullName)) {
                s.
            }
        }
    }

    // View Courses List: Access a comprehensive list of courses they teach for an overview of current teaching assignments.
    public ArrayList<Course> getCourses() {
        Hogwarts.log("getCourses start");
        return _courses;
    }


    // View Course's List of Students: Check the list of students enrolled in specific courses to monitor their progress.
    //!This function is implemented in course.
    public void showStudentsOf(Course pCourse) {
        Hogwarts.log("showStudentsOf start");
        pCourse.showStudents();
        Hogwarts.log("showStudentsOf end");
    }
    public void show(String prefix) {
        Hogwarts.log("show start");
        System.out.println("\r\n"+prefix+"teacherID: " + _teacherId.toString());
        System.out.println(prefix+"fullName: " + _fullName);
    }

    //TODO: Show Teacher’s Score on the Menu: Conveniently monitor their teaching performance by checking their score displayed on the menu.



}
