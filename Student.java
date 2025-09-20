import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enroll(Course course) {
        enrolledCourses.add(course);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student: ").append(name).append("\nEnrolled Courses: ");
        if(enrolledCourses.isEmpty()) sb.append("None");
        else {
            for(Course c : enrolledCourses) {
                sb.append(c.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2); // remove last comma
        }
        return sb.toString();
    }
}
