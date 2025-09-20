import java.util.ArrayList;
import java.util.Scanner;

// Main LMS Class
public class LMS {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Learning Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. View Students");
            System.out.println("5. View Courses");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 : addStudent();
                case 2 : addCourse();
                case 3 : enrollStudent();
                case 4 : viewStudents();
                case 5 : viewCourses();
                case 6 : System.out.println("Exiting...");
                default : System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        Student student = new Student(name);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    static void addCourse() {
        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Instructor Name: ");
        String instructor = sc.nextLine();
        Course course = new Course(name, instructor);
        courses.add(course);
        System.out.println("Course added successfully!");
    }

    static void enrollStudent() {
        if(students.isEmpty() || courses.isEmpty()) {
            System.out.println("No students or courses available for enrollment.");
            return;
        }

        System.out.println("Available Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }
        System.out.print("Select Student (number): ");
        int sIndex = sc.nextInt() - 1;

        System.out.println("Available Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getName());
        }
        System.out.print("Select Course (number): ");
        int cIndex = sc.nextInt() - 1;
        sc.nextLine(); // consume newline

        Student student = students.get(sIndex);
        Course course = courses.get(cIndex);

        student.enroll(course);
        course.addStudent(student);

        System.out.println(student.getName() + " enrolled in " + course.getName());
    }

    static void viewStudents() {
        if(students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }
        System.out.println("Students:");
        for(Student s : students) {
            System.out.println(s);
        }
    }

    static void viewCourses() {
        if(courses.isEmpty()) {
            System.out.println("No courses added yet.");
            return;
        }
        System.out.println("Courses:");
        for(Course c : courses) {
            System.out.println(c);
        }
    }
}
