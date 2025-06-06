package hus.oop.studentmanager;

public class Student implements StudentComparable {
    private String id;
    private String lastname;
    private String firstname;
    private int yearOfBirth;
    private double mathsGrade;
    private double physicsGrade;
    private double chemistryGrade;

    private Student() {}

    public static class StudentBuilder {
        private String id;
        private String lastname;
        private String firstname;
        private int yearOfBirth;
        private double mathsGrade;
        private double physicsGrade;
        private double chemistryGrade;

        public StudentBuilder(String id) {
            /* TODO */
            this.id = id;
        }

        public StudentBuilder withLastname(String lastname) {
            /* TODO */
            this.lastname = lastname;
            return this;
        }

        public StudentBuilder withFirstname(String firstname) {
            /* TODO */
            this.firstname = firstname;
            return this;
        }

        public StudentBuilder withYearOfBirth(int yearOfBirth) {
            /* TODO */
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public StudentBuilder withMathsGrade(double mathsGrade) {
            /* TODO */
            this.mathsGrade = mathsGrade;
            return this;
        }

        public StudentBuilder withPhysicsGrade(double physicsGrade) {
            /* TODO */
            this.physicsGrade = physicsGrade;
            return this;
        }

        public StudentBuilder withChemistryGrade(double chemistryGrade) {
            /* TODO */
            this.chemistryGrade = chemistryGrade;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.id = this.id;
            student.lastname = this.lastname;
            student.firstname = this.firstname;
            student.yearOfBirth = this.yearOfBirth;
            student.mathsGrade = this.mathsGrade;
            student.physicsGrade = this.physicsGrade;
            student.chemistryGrade = this.chemistryGrade;
            return student;
        }
    }

    public String getId() {
        /* TODO */
        return id;
    }

    public String getLastname() {
        /* TODO */
        return lastname;
    }

    public String getFirstname() {
        /* TODO */
        return firstname;
    }

    public int getYearOfBirth() {
        /* TODO */
        return yearOfBirth;
    }

    public double getMathsGrade() {
        /* TODO */
        return mathsGrade;
    }

    public double getPhysicsGrade() {
        /* TODO */
        return physicsGrade;
    }

    public double getChemistryGrade() {
        /* TODO */
        return chemistryGrade;
    }

    public double getAverageGrade() {
        /* TODO */
        return (mathsGrade + physicsGrade + chemistryGrade) / 3.0;
    }

    @Override
    public int compareTo(Student another) {
        int compare = this.firstname.compareTo(another.firstname);
        if (compare != 0) {
            return compare;
        }
        return this.lastname.compareTo(another.lastname);
    }

    public String toString() {
        return String.format("%s - %s %s, %4d, %.2f, %.2f, %.2f", id, lastname, firstname, yearOfBirth, mathsGrade, physicsGrade, chemistryGrade);
    }
}
