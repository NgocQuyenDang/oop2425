package hus.oop.matrix;

import java.util.Arrays;

public class SquareMatrixTestDrive {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - In ra các số nguyên tố có trong 2 ma trận.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */
        SquareMatrix matrix1 = new SquareMatrix(3);
        SquareMatrix matrix2 = new SquareMatrix(3);

        System.out.println("Matrix 1: ");
        System.out.println(matrix1.toString());
        System.out.println("Matrix 2: ");
        System.out.println(matrix2.toString());
        System.out.println("Matrix 1 transpose: ");
        System.out.println(matrix1.transpose().toString());
        System.out.println("Matrix 2 transpose: ");
        System.out.println(matrix2.transpose().toString());
        System.out.println("Sum of 2 matrices: ");
        System.out.println(matrix1.add(matrix2).toString());
        System.out.println("Matrix 1 minus Matrix 2: ");
        System.out.println(matrix1.minus(matrix2).toString());
        System.out.println("Production of 2 matrices: ");
        System.out.println(matrix1.multiply(matrix2).toString());
        System.out.println("Prime numbers in 2 matrices: ");
        System.out.println("Matrix 1: ");
        System.out.println(Arrays.toString(matrix1.primes()));
        System.out.println("Matrix 2: ");
        System.out.println(Arrays.toString(matrix2.primes()));
    }
}
