package hus.oop.candidatemanager;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private MyList studentList;

    private StudentManager() {
        studentList = new MyLinkedList();
    }

    public static StudentManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public MyList getStudentList() {
        return this.studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     *
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        studentList.append(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     *
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        studentList.insert(student, index);
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     *
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        studentList.remove(index);
    }

    /**
     * Lấy ra sinh viên ở vị trí index
     *
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        Student student = (Student) studentList.get(index);
        return student;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán tăng dần.
     *
     * @return
     */
    public MyList sortMathsGradeIncreasing() {
        /* TODO */
        MyList result = new MyLinkedList();
        for (int i = 0; i < studentList.size(); i++) {
            result.append(studentList.get(i));
        }

        for (int i = 0; i < result.size() - 1; i++) {
            int flag = 0;
            for (int j = 0; j < result.size() - 1 - i; j++) {
                Student current = (Student) result.get(j);
                Student next = (Student) result.get(j + 1);
                if (current.getMathsGrade() > next.getMathsGrade()) {
                    result.set(next, j);
                    result.set(current, j + 1);
                    flag = 1;
                }
                if (flag == 0) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán giảm dần.
     *
     * @return
     */
    public MyList sortMathsGradeDecreasing() {
        /* TODO */
        MyList result = new MyLinkedList();
        for (int i = 0; i < studentList.size(); i++) {
            result.append(studentList.get(i));
        }

        for (int i = 0; i < result.size() - 1; i++) {
            int flag = 0;
            for (int j = 0; j < result.size() - 1 - i; j++) {
                Student current = (Student) result.get(j);
                Student next = (Student) result.get(j + 1);
                if (current.getMathsGrade() < next.getMathsGrade()) {
                    result.set(next, j);
                    result.set(current, j + 1);
                    flag = 1;
                }
                if (flag == 0) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình tăng dần.
     *
     * @return
     */
    public MyList sortAverageGradeIncreasing() {
        /* TODO */
        MyList result = new MyLinkedList();
        for (int i = 0; i < studentList.size(); i++) {
            result.append(studentList.get(i));
        }

        for (int i = 0; i < result.size() - 1; i++) {
            int flag = 0;
            for (int j = 0; j < result.size() - 1 - i; j++) {
                Student current = (Student) result.get(j);
                Student next = (Student) result.get(j + 1);
                if (current.getAverageGrade() > next.getAverageGrade()) {
                    result.set(next, j);
                    result.set(current, j + 1);
                    flag = 1;
                }
                if (flag == 0) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình giảm dần.
     *
     * @return
     */
    public MyList sortAverageGradeDecreasing() {
        /* TODO */
        MyList result = new MyLinkedList();
        for (int i = 0; i < studentList.size(); i++) {
            result.append(studentList.get(i));
        }

        for (int i = 0; i < result.size() - 1; i++) {
            int flag = 0;
            for (int j = 0; j < result.size() - 1 - i; j++) {
                Student current = (Student) result.get(j);
                Student next = (Student) result.get(j + 1);
                if (current.getAverageGrade() < next.getAverageGrade()) {
                    result.set(next, j);
                    result.set(current, j + 1);
                    flag = 1;
                }
                if (flag == 0) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán cao nhất.
     *
     * @param howMany
     * @return
     */
    public MyList filterStudentsHighestMathsGrade(int howMany) {
        /* TODO */
        MyList mathGrades = this.sortMathsGradeDecreasing();
        MyList result = new MyLinkedList();
        for (int i = 0; i < howMany; i++) {
            result.append(mathGrades.get(i));
        }
        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán thấp nhất.
     *
     * @param howMany
     * @return
     */
    public MyList filterStudentsLowestMathsGrade(int howMany) {
        /* TODO */
        MyList mathGrades = this.sortMathsGradeDecreasing();
        MyList result = new MyLinkedList();
        for (int i = 0; i < howMany; i++) {
            result.append(mathGrades.get(i));
        }
        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình cao nhất.
     *
     * @param howMany
     * @return
     */
    public MyList filterStudentsHighestAverageGrade(int howMany) {
        /* TODO */
        MyList averageGrades = this.sortAverageGradeDecreasing();
        MyList result = new MyLinkedList();
        for (int i = 0; i < howMany; i++) {
            result.append(averageGrades.get(i));
        }
        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình thấp nhất.
     *
     * @param howMany
     * @return
     */
    public MyList filterStudentsLowestAverageGrade(int howMany) {
        /* TODO */
        MyList averageGrades = this.sortAverageGradeIncreasing();
        MyList result = new MyLinkedList();
        for (int i = 0; i < howMany; i++) {
            result.append(averageGrades.get(i));
        }
        return result;
    }

    public static String idOfStudentsToString(MyList studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        MyIterator it = studentList.iterator();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(MyList studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        MyIterator it = studentList.iterator();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
