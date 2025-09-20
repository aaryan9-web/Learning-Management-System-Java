import java.util.ArrayList;

public class Course {
    private String name;
    private String instructor;
    private ArrayList<Student> enrolledStudents;

    public Course(String name, String instructor) {
        this.name = name;
        this.instructor = instructor;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course: ").append(name).append(", Instructor: ").append(instructor).append("\nEnrolled Students: ");
        if(enrolledStudents.isEmpty()) sb.append("None");
        else {
            for(Student s : enrolledStudents) {
                sb.append(s.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
