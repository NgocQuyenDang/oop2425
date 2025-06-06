package hus.oop.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SquareMatrix {
    private int[][] data;

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong khoảng [1, 100]
     * @param size
     */
    public SquareMatrix(int size) {
        initRandom(size);
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong khoảng [1, 100]
     * @param size
     */
    private void initRandom(int size) {
        /* TODO */
        Random random = new Random();
        this.data = new int[size][size];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = random.nextInt(6) + 5;
            }
        }
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public int[] principalDiagonal() {
        /* TODO */
        int[] diagonal = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if ( i == j) {
                    diagonal[i] = data[i][j];
                }
            }
        }
        return diagonal;
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public int[] secondaryDiagonal() {
        /* TODO */
        int[] diagonal = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if ((i + j) == (data.length - 1)) {
                    diagonal[i] = data[i][j];
                }
            }
        }
        return diagonal;
    }

    /**
     * Phương thức lấy ra các số là số nguyên tố trong ma trận.
     * @return các số nguyên tố trong ma trận.
     */
    public int[] primes() {
        /* TODO */
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (isPrime(data[i][j])) {
                    primes.add(data[i][j]);
                }
            }
        }

        int[] result = new int[primes.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = primes.get(i);
        }
        return result;
    }

    public static boolean isPrime(int number) {
        if ( number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Phương thức sắp xếp các phần tử của ma trận theo thứ tự tăng dần.
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự tăng dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public SquareMatrix getSortedMatrix() {
        /* TODO */
        int size = data.length;
        int[] temp = new int[size * size];
        int k = 0;
        SquareMatrix sorted = new SquareMatrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp[k++] = data[i][j];
            }
        }
        Arrays.sort(temp);
        k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sorted.set(i, j, temp[k++]);
            }
        }
        return sorted;
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     * @param row
     * @param col
     * @return
     */
    public int get(int row, int col) {
        /* TODO */
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, int value) {
        /* TODO */
        this.data[row][col] = value;
    }

    /**
     * Phương thức cộng ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public SquareMatrix add(SquareMatrix that) {
        /* TODO */
        int rows = this.data.length;
        int cols = this.data[0].length;
        SquareMatrix sum = new SquareMatrix(rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum.set(i,j, this.get(i, j) + that.get(i, j));
            }
        }
        return sum;
    }

    /**
     * Phương thức trừ ma trận hiện tại cho một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public SquareMatrix minus(SquareMatrix that) {
        /* TODO */
        int rows = this.data.length;
        int cols = this.data[0].length;
        SquareMatrix difference = new SquareMatrix(rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                difference.set(i,j, this.get(i, j) - that.get(i, j));
            }
        }
        return difference;
    }

    /**
     * Phương thức nhân ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận nhân của ma trận hiện tại với ma trận truyền vào.
     */
    public SquareMatrix multiply(SquareMatrix that) {
        /* TODO */
        int rows = this.data.length;
        int cols = rows;
        SquareMatrix multiply = new SquareMatrix(rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < rows; k++) {
                    multiply.set(i,j, this.get(i, k) * that.get(k, j));
                }
            }
        }
        return multiply;
    }

    /**
     * Phương thức nhân ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public SquareMatrix scaled(int value) {
        /* TODO */
        int size =  this.data.length;
        SquareMatrix scaled = new SquareMatrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                scaled.set(i, j, this.get(i, j) * value);
            }
        }
        return scaled;
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public SquareMatrix transpose() {
        /* TODO */
        int size = this.data.length;
        SquareMatrix transpose = new SquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transpose.set(j, i, this.get(i, j));
            }
        }
        return transpose;
    }

    /**
     * Mô tả ma trận theo định dạng biểu diễn ma trận, ví dụ
     *   1 2 3
     *   4 5 6
     *   7 8 9
     * @return một chuỗi mô tả ma trận.
     */
    @Override
    public String toString() {
        /* TODO */
        String s = "";
        for (int  i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                s = s + data[i][j] + " ";
            }
            s = s + '\n';
        }
        return s;
    }
}
