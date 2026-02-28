import java.util.Scanner;

public class GradeManagementSystem {

    static final int MAX_STUDENTS = 100;
    static final int SUBJECT_COUNT = 5;

    static StudentGrade[] students = new StudentGrade[MAX_STUDENTS];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== GRADE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student Marks");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Averages");
            System.out.println("4. Find Top Performers");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> calculateAverages();
                case 4 -> ReportGenerator.generateReport(students, count);
                case 5 -> ReportGenerator.generateReport(students, count);
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        sc.nextLine();
        System.out.print("\nEnter Student Name: ");
        String name = sc.nextLine();

        double[] marks = new double[SUBJECT_COUNT];
        String[] subjects = {"Mathematics", "Science", "English", "History", "Computer"};

        System.out.println("\nEnter marks for 5 subjects (out of 100):");
        for (int i = 0; i < SUBJECT_COUNT; i++) {
            System.out.print(subjects[i] + ": ");
            double mark = sc.nextDouble();

            while (mark < 0 || mark > 100) {
                System.out.print("Enter valid mark (0-100): ");
                mark = sc.nextDouble();
            }
            marks[i] = mark;
        }

        students[count++] = new StudentGrade(name, marks);
        System.out.println("✅ Student marks added successfully!");
    }

    static void viewStudents() {
        System.out.println("\n=== ALL STUDENTS ===");
        System.out.printf("%-20s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "Student Name", "Math", "Science", "English", "History", "Computer", "Average");

        System.out.println("----------------------------------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            double avg = students[i].getAverage();
            double[] m = students[i].getMarks();
            System.out.printf("%-20s %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f\n",
                    students[i].getName(), m[0], m[1], m[2], m[3], m[4], avg);
        }
    }

    static void calculateAverages() {
        System.out.println("\n=== STUDENT AVERAGES ===");
        for (int i = 0; i < count; i++) {
            double avg = students[i].getAverage();
            String grade = GradeCalculator.getGrade(avg);
            System.out.printf("%-15s : Average = %.2f, Grade = %s\n",
                    students[i].getName(), avg, grade);
        }
    }
}