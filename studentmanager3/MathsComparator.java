package hus.oop.studentmanager;

public class MathsComparator implements StudentComparator {
    @Override
    public int compare(Student left, Student right) {
        return Double.compare(left.getMathsGrade(), right.getMathsGrade());
    }
}
