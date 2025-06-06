package hus.oop.studentmanager;

public class ChemistryComparator implements StudentComparator{
    @Override
    public int compare(Student left, Student right) {
        return Double.compare(left.getChemistryGrade(), right.getChemistryGrade());
    }
}
