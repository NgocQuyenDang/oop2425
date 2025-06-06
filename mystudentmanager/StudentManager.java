package hus.oop.mystudentmanager;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private MyList studentList;

    private StudentManager() {
        /* TODO */
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
        /* TODO */
        return studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        studentList.insertAtEnd(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        studentList.insertAtPosition(student, index);
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        studentList.remove(index);
    }

    /**
     * Bỏ sinh viên như tham số truyền vào.
     * @param student
     */
    public void remove(Student student) {
        /* TODO */
        MyIterator iterator = studentList.iterator();
        int index = 0;

        while (iterator.hasNext()) {
            Student current = (Student) iterator.next();
            if (current == student) {
                studentList.remove(index);
                break;
            }
            index++;
        }
    }

    /**
     * Lấy ra sinh viên ở vị trí index
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        return (Student) studentList.get(index);
    }

    /**
     * Lọc ra những sinh viên có điểm trung bình trên 15 điểm.
     * @return
     */
    public MyList filterStudentsByAverageGrade() {
        /* TODO */
        MyIterator iterator = studentList.iterator();
        MyList result = new MyLinkedList();

        while (iterator.hasNext()) {
            Student current = (Student) iterator.next();
            if( current.getAverageGrade() > 5) {
                result.insertAtEnd(current);
            }
        }
        return result;
    }

    /**
     * Lọc ra những sinh viên có điểm toán trên 5 điểm.
     * @return
     */
    public MyList filterStudentsByMathGrade() {
        /* TODO */
        MyIterator iterator = studentList.iterator();
        MyList result = new MyLinkedList();

        while (iterator.hasNext()) {
            Student current = (Student) iterator.next();
            if( current.getMathsGrade() > 5) {
                result.insertAtEnd(current);
            }
        }
        return result;
    }
}
