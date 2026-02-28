public class StudentGrade {
    private String name;
    private double[] marks;

    public StudentGrade(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double[] getMarks() {
        return marks;
    }

    public double getAverage() {
        double sum = 0;
        for (double m : marks) sum += m;
        return sum / marks.length;
    }
}