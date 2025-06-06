package hus.oop.midterm.students;

public class TestMyList {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_MyList>.txt
           (ví dụ, NguyenVanA_123456_MyList.txt)
         - Nộp kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        testMyArrayList();
        testMyLinkedList();
    }

    public static void testMyArrayList() {
        /*
         TODO

         - Tạo ra một list kiểu MyArrayList có ít nhất 10 Student.

         - Sử dụng StudentStatistics để
             + Sắp xếp và in ra danh sách các Student theo thứ tự tăng dần theo tên và họ.
             + Sắp xếp và in ra danh sách các Student theo thứ tự giảm dần theo tên và họ.
             + Sắp xếp và in ra danh sách các Student theo thứ tự tăng dần về average.
             + Sắp xếp và in ra danh sách các Student theo thứ tự giảm dần về average.
         */
        MyList students = new MyArrayList();
        students.append(new Student("An", "Nguyen", 5.6));
        students.append(new Student("Nam", "Nguyen", 7.6));
        students.append(new Student("Son", "Le", 3.5));
        students.append(new Student("Hoan", "Nguyen", 5.6));
        students.append(new Student("Khanh", "Nguyen", 5.6));
        students.append(new Student("Khang", "Nguyen", 5.7));
        students.append(new Student("Giang", "Le", 5.8));
        students.append(new Student("Han", "Pham", 5.9));
        students.append(new Student("Minh", "Pham", 7.0));
        students.append(new Student("Yen", "Mai", 7.1));
        testIterator(students);

        StudentStatistics stats = new StudentStatistics(students);

        System.out.println("Sorted by name ascending: ");
        MyList result = stats.sortByFullname(students, true);
        testIterator(result);

        System.out.println("Sorted by name descending: ");
        MyList result1 = stats.sortByFullname(students, false);
        testIterator(result1);

        System.out.println("Sorted by average ascending: ");
        MyList result2 = stats.sortByAverage(students, true);
        testIterator(result2);

        System.out.println("Sorted by average descending: ");
        MyList result3 = stats.sortByAverage(students, false);
        testIterator(result3);


    }

    public static void testMyLinkedList() {
        /*
         TODO

         - Tạo ra một list kiểu MyLinkedList có ít nhất 10 Student.

         - Sử dụng StudentStatistics để
             + Sắp xếp và in ra danh sách các Student theo thứ tự tăng dần theo tên và họ.
             + Sắp xếp và in ra danh sách các Student theo thứ tự giảm dần theo tên và họ.
             + Sắp xếp và in ra danh sách các Student theo thứ tự tăng dần về average.
             + Sắp xếp và in ra danh sách các Student theo thứ tự giảm dần về average.
         */
        MyList students = new MyLinkedList();
        students.append(new Student("An", "Nguyen", 5.6));
        students.append(new Student("Nam", "Nguyen", 7.6));
        students.append(new Student("Son", "Le", 3.5));
        students.append(new Student("Hoan", "Nguyen", 5.6));
        students.append(new Student("Khanh", "Nguyen", 5.6));
        students.append(new Student("Khang", "Nguyen", 5.7));
        students.append(new Student("Giang", "Le", 5.8));
        students.append(new Student("Han", "Pham", 5.9));
        students.append(new Student("Minh", "Pham", 7.0));
        students.append(new Student("Yen", "Mai", 7.1));

        StudentStatistics stats = new StudentStatistics(students);
        System.out.println("Sorted by name ascending: ");
        MyList result = stats.sortByFullname(students, true);
        testIterator(result);

        System.out.println("Sorted by name descending: ");
        MyList result1 = stats.sortByFullname(students, false);
        testIterator(result1);

        System.out.println("Sorted by average ascending: ");
        MyList result2 = stats.sortByAverage(students, true);
        testIterator(result2);

        System.out.println("Sorted by average descending: ");

        MyList result3 = stats.sortByAverage(students, false);
        testIterator(result3);

    }

    public static void testIterator(MyList myList) {
        /*
         TODO

         Sử dụng iterator duyệt qua tất cả các phần tử trong danh sách myList và in ra thông tin về phần tử đó.
         */
        MyList list = new MyArrayList();
        MyIterator iterator = myList.iterator();
        while (iterator.hasNext()) {
            Student student = (Student) iterator.next();
            System.out.println(student);
        }
        System.out.println();
    }
}
