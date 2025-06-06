package hus.oop.midterm.students;

public class StudentStatistics {
    private MyList students;

    /**
     * Khởi tạo dữ liệu cho StudentManager.
     */
    public StudentStatistics(MyList data) {
        /* TODO */
        this.students = data;
    }

    /**
     * Lấy ra danh sách các sinh viên được sắp xếp theo thứ tự phụ thuộc vào tên và họ.
     * Chú ý, không thay đổi thứ tự sinh viên trong danh sách gốc.
     * @param order
     * @return danh sách các sinh viên đã được sắp xếp
     */
    public MyList sortByFullname(MyList list, boolean order) {
        /*
         TODO

         - Sửa lại lớp Student để sử dụng MyComparable để thực hiện việc so sánh các Student theo tên và họ.
           Thứ tự đầu tiên phụ thuộc vào tên, nếu tên bằng nhau thì thứ tự phụ thuộc vào họ.

         - Sử dụng tiêu chí so sánh trong MyComparable, viết code để sắp xếp danh sách các sinh viên theo thứ tự
           phụ thuộc tham số order. Nếu order là true thì sắp xệp theo thứ tự tăng dần. Nếu order là false thì
           sắp xếp theo thứ tự giảm dần.

         - Trả ra danh sách sinh viên mới đã được sắp thứ tự.
         */
        MyList result;
        if (list instanceof MyLinkedList) {
            result = copyLinkedList();
        } else {
            result = copyArrayList();
        }

        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = 0; j < result.size() - i - 1; j++) {
                Student s1 = (Student) result.get(j);
                Student s2 = (Student) result.get(j + 1);
                int compare = s1.compareTo(s2);

                if (order && compare > 0 || (!order && compare < 0)) {
                    result.set(s2, j);
                    result.set(s1, j + 1);
                }
            }
        }
        return result;
    }

    /**
     * Lấy ra danh sách các sinh viên được sắp xếp theo average.
     * Chú ý, không thay đổi thứ tự sinh viên trong danh sách gốc.
     * @param order
     * @return
     */
    public MyList sortByAverage(MyList list, boolean order) {
        /*
         TODO

         - Thêm lớp AverageComparison sử dụng StudentComparator để có thể so sánh các sinh viên theo average.

         - Viết code sử dụng AverageComparison để sắp xếp sinh viên theo thứ tự phụ thuộc tham số order.
           Nếu order là true thì sắp xệp theo thứ tự tăng dần. Nếu order là false thì sắp xếp theo thứ tự giảm dần.

         - Trả ra danh sách các sinh viên mới đã được sắp xếp.
         */

        MyList result;
        if (list instanceof MyLinkedList) {
            result = copyLinkedList();
        } else {
            result = copyArrayList();
        }

        StudentComparator comparator = new AverageComparison();
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = 0; j < result.size() - 1 - i; j++) {
                Student s1 = (Student) result.get(j);
                Student s2 = (Student) result.get(j + 1);
                int compare = comparator.compare(s1, s2);

                if (order && compare > 0 || (!order && compare < 0)) {
                    result.set(s2, j);
                    result.set(s1, j + 1);
                }
            }
        }
        return result;
    }

    public MyList copyArrayList() {
        MyList result = new MyArrayList();
        MyIterator iterator = students.iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
        }
        return result;
    }

    public MyList copyLinkedList() {
        MyList result = new MyLinkedList();
        MyIterator iterator = students.iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
        }
        return result;
    }
}
