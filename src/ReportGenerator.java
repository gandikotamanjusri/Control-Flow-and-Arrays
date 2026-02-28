public class ReportGenerator {

    public static void generateReport(StudentGrade[] students, int count) {
        System.out.println("\n=== PERFORMANCE REPORT ===");
        System.out.println("Total Students: " + count);

        String[] subjects = {"Mathematics", "Science", "English", "History", "Computer"};

        System.out.println("\n📊 SUBJECT AVERAGES:");
        for (int s = 0; s < subjects.length; s++) {
            double avg = GradeCalculator.subjectAverage(students, count, s);
            System.out.printf("• %s: %.2f\n", subjects[s], avg);
        }

        sortByAverage(students, count);

        System.out.println("\n🏆 TOP PERFORMERS:");
        for (int i = 0; i < count; i++) {
            System.out.printf("%d. %s - Average: %.2f\n",
                    i + 1, students[i].getName(), students[i].getAverage());
        }

        int a=0,b=0,c=0,d=0,f=0;

        for (int i = 0; i < count; i++) {
            String grade = GradeCalculator.getGrade(students[i].getAverage());
            switch (grade) {
                case "A" -> a++;
                case "B" -> b++;
                case "C" -> c++;
                case "D" -> d++;
                case "F" -> f++;
            }
        }

        System.out.println("\n📈 GRADE DISTRIBUTION:");
        System.out.println("• A Grade: " + a + " students");
        System.out.println("• B Grade: " + b + " students");
        System.out.println("• C Grade: " + c + " students");
        System.out.println("• D Grade: " + d + " students");
        System.out.println("• F Grade: " + f + " students");
    }

    private static void sortByAverage(StudentGrade[] students, int count) {
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (students[j].getAverage() > students[i].getAverage()) {
                    StudentGrade temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }
}