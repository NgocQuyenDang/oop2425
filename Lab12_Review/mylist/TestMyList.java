package hus.oop.mylist;

public class TestMyList {
    public static void main(String[] args) {
        /*
         * TODO
         * Chạy demo các hàm test.
         */
        testMyArrayList();
        testMyLinkedList();
    }

    public static void testMyArrayList() {
        /*
         * TODO
         * Tạo ra một list kiểu MyArrayList có các phần tử dữ liệu kiểu Double.
         * Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
         * In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
         */
        System.out.println("ArrayList");
        MyList arrayList = new MyArrayList();
        arrayList.append(1.0);
        arrayList.append(2.5);
        arrayList.append(3.4);
        arrayList.append(4.6);
        arrayList.append(5.9);
        BasicStatistic calculator = new BasicStatistic(arrayList);
        System.out.println("Max: " + calculator.max());
        System.out.println("Min: " + calculator.min());
        System.out.println("Mean: " + calculator.mean());
        System.out.println("Variance: " + calculator.variance());
    }

    public static void testMyLinkedList() {
        /*
         * TODO
         * Tạo ra một list kiểu MyLinkedList có các phần tử dữ liệu kiểu Double.
         * Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
         * In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
         */
        System.out.println("LinkedList");
        MyList linkedList = new MyLinkedList();
        linkedList.append(1.0);
        linkedList.append(2.5);
        linkedList.append(3.4);
        linkedList.append(4.6);
        linkedList.append(5.9);
        BasicStatistic calculator = new BasicStatistic(linkedList);
        System.out.println("Max: " + calculator.max());
        System.out.println("Min: " + calculator.min());
        System.out.println("Mean: " + calculator.mean());
        System.out.println("Variance: " + calculator.variance());
    }
}
