public class GradeCalculator {

    public static String getGrade(double avg) {
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    public static double subjectAverage(StudentGrade[] students, int count, int subjectIndex) {
        double sum = 0;
        for (int i = 0; i < count; i++)
            sum += students[i].getMarks()[subjectIndex];
        return sum / count;
    }
}