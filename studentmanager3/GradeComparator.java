package hus.oop.studentmanager;

public class GradeComparator implements StudentComparator{
    @Override
    public int compare(Student left, Student right) {
        return Double.compare(left.getAverageGrade(), right.getAverageGrade());
    }

}
