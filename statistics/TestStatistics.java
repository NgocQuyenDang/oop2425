package hus.oop.statistics;

import java.util.Random;

public class TestStatistics {
    public static void main(String[] args) {
        /* TODO

         - Viết các hàm test như yêu cầu và chạy test chương trình.
         - Copy kết quả chạy chương trình và lưu vào file text có tên <Ten_MaSinhVien_Statistics>.txt
         (ví dụ, NguyenVanA_123456S_Statistics.txt).
          - Nén các file source code và file text kết quả chạy chương trình theo định dạng .zip,
         đặt tên là <Ten_MaSinhVien_Statistics>.zip (ví dụ, NguyenVanA_123456_Statistics.zip) và nộp lên classroom.
         */
        testArrayDataSet();
        testListDataSet();
    }

    public static void testArrayDataSet() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên trong đoạn [10, 20], gọi là n.
         - Sinh ra n số thực kiểu double ngẫu nhiên, cho vào tập dữ liệu
         - In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
         - Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu.
         In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
         */
        DataSet array = new ArrayDataSet();
        Random rand = new Random();
        int n = rand.nextInt(10) + 10;
        for (int i = 0; i < n; i++) {
            double num = rand.nextDouble(10) + 10;
            num = Math.round(num * 100.0) / 100.0;
            array.insertAtEnd(num);
        }
        BasicStatistic stats = new BasicStatistic();
        stats.setDataSet(array);
        System.out.println("Array Dataset: ");
        System.out.println(array);

        System.out.println("Array Size: " + array.size());
        System.out.println("Max element : " + stats.max());
        System.out.println("Min element : " + stats.min());
        System.out.println("Mean: " + stats.mean());
        System.out.println("Median: " + stats.median());
        System.out.println("Variance: " + stats.variance());
        array.remove(0);
        System.out.println("Array removed start index: ");
        System.out.println(array);
        System.out.println("Array removed end index: ");
        //int lastIndex = array.size() - 1;
        array.remove(array.size() - 1);
        System.out.println(array);
        System.out.println("Array after removing 2 elements: ");
        System.out.println("Size: " + array.size());
        System.out.println("Max element : " + stats.max());
        System.out.println("Min element : " + stats.min());
        System.out.println("Mean: " + stats.mean());
        System.out.println("Median: " + stats.median());
        System.out.println("Variance: " + stats.variance());
    }

    public static void testListDataSet() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên trong đoạn [10, 20], gọi là n.
         - Sinh ra n số thực kiểu double ngẫu nhiên, cho vào tập dữ liệu
         - In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
         - Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu.
         In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
         */
        Random rand = new Random();
        DataSet list = new ListDataSet();
        int n = rand.nextInt(10) + 10;
        for (int i = 0; i < n; i++) {
            double num = rand.nextDouble(10) + 10;
            num = Math.round(num * 100.0) / 100.0;
            list.insertAtEnd(num);
        }
        BasicStatistic stats2 = new BasicStatistic();
        stats2.setDataSet(list);
        System.out.println("List Dataset: ");
        System.out.println(list);
        System.out.println("List Size: " + list.size());
        System.out.println("Max elements: " + stats2.max());
        System.out.println("Min elements: " + stats2.min());
        System.out.println("Mean: " + stats2.mean());
        System.out.println("Median: " + stats2.median());
        System.out.println("Variance: " + stats2.variance());
        list.remove(0);
        System.out.println("List removed start index: ");
        System.out.println(list);
        System.out.println("List removed end index: ");
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
        System.out.println(list);
        System.out.println("List after removing 2 elements: ");
        System.out.println("Size: " + list.size());
        System.out.println("Max element : " + stats2.max());
        System.out.println("Min element : " + stats2.min());
        System.out.println("Mean: " + stats2.mean());
        System.out.println("Median: " + stats2.median());
        System.out.println("Variance: " + stats2.variance());

    }
}
