package hus.oop.studentmanager;

public class PhysicsComparator implements StudentComparator {
    @Override
    public int compare(Student left, Student right) {
        return Double.compare(left.getPhysicsGrade(), right.getPhysicsGrade());
    }
}
