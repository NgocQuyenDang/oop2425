package hus.oop.midterm.students;

public class AverageComparison implements StudentComparator {
    @Override
    public int compare(Student left, Student right) {
        return Double.compare(left.getAverage(), right.getAverage());
    }
}
