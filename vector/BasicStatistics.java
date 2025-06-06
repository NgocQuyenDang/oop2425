package hus.oop.midterm.vector;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicStatistics {
    private MyVector[] vectors;

    public static void main(String[] args) {
        /*
         TODO

         Thực hiện các yêu cầu sau.

         I. Test chức năng vector
           - Viết các hàm testArrayVector để test các chứ năng của array vector, như thêm vào tọa độ, xóa bớt số trục tọa độ,
             sửa giá trị tọa độ, cộng các vector, nhân vector với giá trị vô hướng, nhân vô hướng 2 vector, ...
           - Viết các hàm testListVector để test các chứ năng của list vector, như thêm vào tọa độ, xóa bớt số trục tọa độ,
             sửa giá trị tọa độ, cộng các vector, nhân vector với giá trị vô hướng, nhân vô hướng 2 vector, ...

         II. Thực hiện thống kê đơn giản với các vector
           - Tạo ra ít nhất 10 vector và cho vào mảng vectors để quản lý. Trong đó có ít nhất 2 nhóm các vector
             có chuẩn bằng nhau.
           - Tìm và in ra thông tin chuẩn nhó nhất, chuẩn lớn nhất của các vector.
           - In ra các vector có chuẩn sắp xếp theo thứ tự tăng dần, giản dần.
           - In ra các vector có chuẩn nằm trong một đoạn [a, b] cho trước.
           - In ra rank của các vector theo thứ tự trong mảng vectors.

         III. Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
              (ví dụ NguyenVanA_123456_Vector.txt) và nộp cùng source code.
         */
        testArrayVector();
        testListVector();
        doSimpleStatic();
    }

    public static void testArrayVector() {
        /* TODO */
        MyArrayVector vector = new MyArrayVector();
        vector.insert(4).insert(3).insert(2);
        vector.set(1, 0);
        System.out.println("Vector 1: " + vector.toString());
        MyArrayVector vector2 = new MyArrayVector();
        vector2.insert(2).insert(3).insert(2);
        System.out.println("Vector 2: " + vector2.toString());
        vector.add(vector2);
        System.out.println("Vector 1 + Vector 2: " +  vector.toString());
        vector.minus(vector2);
        System.out.println("Vector 1 - Vector 2: " +  vector.toString());
        vector.scale(2);
        System.out.println("Vector 1 multiply 2 : " + vector.toString());
        MyArrayVector vector3 = new MyArrayVector();
        vector3 = vector.dot(vector2);
        System.out.println("Vector 3: " + vector3.toString());
    }

    public static void testListVector() {
        /* TODO */
        MyListVector vector = new MyListVector();
        vector.insert(4).insert(3).insert(2);
        vector.set(0, 1);
        System.out.println("Vector 1: " + vector.toString());
        MyListVector vector2 = new MyListVector();
        vector2.insert(2).insert(3).insert(2);
        System.out.println("Vector 2: " + vector2.toString());
        vector.add(vector2);
        System.out.println("Vector 1 + Vector 2: " +  vector.toString());
        vector.minus(vector2);
        System.out.println("Vector 1 - Vector 2: " +  vector.toString());
        vector.scale(2);
        System.out.println("Vector 1 multiply 2 : " + vector.toString());
        MyListVector vector3 = new MyListVector();
        vector3 = vector.dot(vector2);
        System.out.println("Vector 3: " + vector3.toString());
    }

    public static void doSimpleStatic() {
        /* TODO */
        BasicStatistics stats = new BasicStatistics();
        stats.vectors = new MyVector[] {
                new MyArrayVector().insert(3).insert(4).insert(2),
                new MyArrayVector().insert(0).insert(5).insert(6),
                new MyListVector().insert(6).insert(8).insert(7),
                new MyListVector().insert(1).insert(2).insert(3),
                new MyArrayVector().insert(2).insert(2).insert(4),
                new MyArrayVector().insert(6).insert(8).insert(7),
                new MyListVector().insert(3).insert(4).insert(5),
                new MyListVector().insert(9).insert(12).insert(7),
                new MyArrayVector().insert(1).insert(1).insert(3),
                new MyListVector().insert(1).insert(2).insert(3)
        };
        System.out.println("Max norm : " + stats.normMax());
        System.out.println("Min norm: " + stats.normMin());
        System.out.println("Vectors sorted ascending: ");
        for (MyVector v : stats.sortNorm(true)) {
            System.out.println(v.toString() + " : " + v.norm());
        }

        System.out.println("Vectors sorted descending: ");
        for (MyVector v : stats.sortNorm(false)) {
            System.out.println(v.toString() + " : " + v.norm());
        }

        System.out.println("Vectors have norm from 5 to 10");
        for (MyVector v : stats.filter(5, 10)) {
            System.out.println(v.toString() + " : " + v.norm());
        }

        System.out.println("Rank of vectors: ");
        System.out.println(Arrays.toString(stats.rank()));

    }

    /**
     * Lấy giá trị chuẩn lớn nhất trong các vector.
     * @return chuẩn lớn nhất.
     */
    public double normMax() {
        /* TODO */
        double max = Double.NEGATIVE_INFINITY;
        for (MyVector v : vectors) {
            max = Math.max(v.norm(), max);
        }
        return max;
    }

    /**
     * Lấy giá trị chuẩn nhỏ nhất trong các vector.
     * @return chuẩn nhỏ nhất.
     */
    public double normMin() {
        /* TODO */
        double min = Double.POSITIVE_INFINITY;
        for (MyVector v : vectors) {
            min = Math.min(v.norm(), min);
        }
        return min;
    }

    /**
     * Lấy ra mảng các vector được sắp xếp theo thứ tự của chuẩn.
     * Nếu order là true thì mảng đầu ra là các vector có chuẩn tăng dần.
     * Nếu order là false thì mảng đầu ra là các vector có chuẩn giảm dần.
     * @return mảng các vector theo thứ tự mảng tăng dần.
     */
    public MyVector[] sortNorm(boolean order) {
        /* TODO */
        MyVector[] result = Arrays.copyOf(vectors, vectors.length);
        int n = result.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n- i - 1; j++) {
                double norm1 = result[j].norm();
                double norm2 = result[j+1].norm();

                if (order && norm1 > norm2 || (!order && norm1 < norm2)) {
                    MyVector temp =  result[j];
                    result [j] = result[j+1];
                    result[j+1] = temp;
                }
            }
        }
        return result;

    }

    /**
     * Lọc ra mảng các vector có chuẩn năm trong đoạn [from, to].
     * @param from
     * @param to
     * @return các vector có chuẩn nằm trong đoạn [from, to]
     */
    public MyVector[] filter(int from, int to) {
        /* TODO */
        List<MyVector> list = new ArrayList<MyVector>();
        for (MyVector v : vectors) {
            if (v.norm() >= from && v.norm() <= to) {
                list.add(v);
            }
        }
        return list.toArray(new MyVector[0]);
    }

    /**
     * Lấy ra thông tin rank của các vector trong mảng theo chuẩn.
     * Rank được tính theo quy luật sau, ví dụ
     *   - tập [3 1 4] có rank [2.0 1.0 3.0]
     *   - tập [3 1 3 5] có các rank [2.5 1.0 4.0] (các phần tử có giá trị bằng nhau có rank
     *     được tính bằng trung bình các chỉ số của các phần tử trong tập dữ liệu, chỉ sổ bắt
     *     đầu là 1)
     * @return
     */
    public double[] rank() {
        /* TODO */
        int n = vectors.length;

        double[] R = new double[n];

        for (int i = 0; i < n; i++) {
            int r = 1, s = 1;

            for (int j = 0; j < n; j++) {
                if (j != i && vectors[j].norm() < vectors[i].norm() ) {
                    r += 1;
                }

                if (j != i && vectors[j].norm() == vectors[i].norm()) {
                    s += 1;
                }
                R[i] = r + (double) (s - 1) / (double) 2;
            }
        }
        return R;
    }
}
