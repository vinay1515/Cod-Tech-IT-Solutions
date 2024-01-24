import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private Map<String, Integer> subjectMarks;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjectMarks = new HashMap<>();
    }

    public void addSubjectMark(String subject, int mark) {
        subjectMarks.put(subject, mark);
    }

    public double calculateOverallPercentage() {
        if (subjectMarks.isEmpty()) {
            return 0.0;
        }

        int totalMarks = subjectMarks.values().stream().mapToInt(Integer::intValue).sum();
        return (double) totalMarks / subjectMarks.size();
    }

    public String calculateGrade() {
        double percentage = calculateOverallPercentage();

        if(percentage>=90) {
            return "O" + "OutStanding";
        }
        if(percentage>=80 && percentage<90) {
            return "A+  +  Excellent";
        }
        if (percentage>=70 && percentage<80) {
            return "A + Very Good";
        }
        if (percentage>=60 && percentage<70) {
            return "B+ + Good";
        }
        if (percentage>=50 && percentage<60) {
            return "B + Average";
        }
        if (percentage>=40 && percentage<60) {
            return "C + Pass";
        }
        else {
            return "F + Fail";
        }
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

class StudentGradeManagementSystem {
    private List<Student> students;

    public StudentGradeManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(int rollNumber, String subject, int newMark) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.addSubjectMark(subject, newMark);
                break;
            }
        }
    }

    public void deleteStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public void displayStudentInfo(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Overall Percentage: " + student.calculateOverallPercentage());
                System.out.println("Grade: " + student.calculateGrade());
                break;
            }
        }
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Overall Percentage: " + student.calculateOverallPercentage());
            System.out.println("Grade: " + student.calculateGrade());
            System.out.println("------------");
        }
    }
}
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentGradeManagementSystem gradeManagementSystem = new StudentGradeManagementSystem();

        // Adding sample students
        gradeManagementSystem.addStudent(new Student("vinay kumar", 1901));
        gradeManagementSystem.addStudent(new Student("Deepa pawaar", 1902));

        // Adding sample marks
        gradeManagementSystem.updateStudent(1901, "Math", 85);
        gradeManagementSystem.updateStudent(1901, "physics", 95);
        gradeManagementSystem.updateStudent(1901, "English", 90);
        gradeManagementSystem.updateStudent(1901, "chemistry", 76);
        gradeManagementSystem.updateStudent(1902, "Math", 95);
        gradeManagementSystem.updateStudent(1902, "physics", 85);
        gradeManagementSystem.updateStudent(1902, "English", 97);
        gradeManagementSystem.updateStudent(1902, "chemistry", 79);

        // Displaying student information
        gradeManagementSystem.displayAllStudents();

        // Adding a new student
        Student newStudent = new Student("Shiva", 1903);
        newStudent.addSubjectMark("Math", 92);
        newStudent.addSubjectMark("English", 95);
        newStudent.addSubjectMark("physics", 65);
        newStudent.addSubjectMark("Chemistry", 55);
        gradeManagementSystem.addStudent(newStudent);

        // Displaying all students after addition
        gradeManagementSystem.displayAllStudents();

        // Updating marks
        gradeManagementSystem.updateStudent(1901, "Math", 58);

        // Displaying updated information
        gradeManagementSystem.displayStudentInfo(1901);

        // Deleting a student
        gradeManagementSystem.deleteStudent(1903);

        // Displaying all students after deletion
        gradeManagementSystem.displayAllStudents();

        scanner.close();
    }
}
