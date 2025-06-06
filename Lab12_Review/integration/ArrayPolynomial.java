package hus.oop.integration;

import java.lang.reflect.Array;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        /* TODO */
        this.coefficents = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + "out of bounds: " + size);
        }

        return coefficents[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        return coefficents;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial append(double coefficient) {
        /* TODO */
        if (size == coefficents.length) {
            enlarge();
        }
        coefficents[size] = coefficient;
        size++;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + "out of bounds: " + size);
        }

        if (size == coefficents.length) {
            enlarge();
        }

        for (int i = size - 1; i >= index; i--) {
            coefficents[i + 1] = coefficents[i];
        }
        coefficents[index] = coefficient;
        size++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + "out of bounds: " + size);
        }

        coefficents[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        int deg = size - 1;
        while (deg > 0 && coefficents[deg] == 0){
            deg--;
        }
        return deg;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0.0;
        for (int i = 0; i < size; i++) {
            result += coefficents[i] * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        double[] derivedCoeffs = differentiate();
        ArrayPolynomial result = new ArrayPolynomial();
        for (double elm : derivedCoeffs) {
            result.append(elm);
        }
        return result;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        /* TODO */
        int maxSize = Math.max(this.size, another.size);
        ArrayPolynomial result = new ArrayPolynomial();
        for (int i = 0; i < maxSize; i++) {
            double a = (i < this.size) ? this.coefficents[i] : 0;
            double b = (i < another.size) ? another.coefficents[i] : 0;
            result.append(a + b);
        }
        return result;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        /* TODO */
        int maxSize = Math.max(this.size, another.size);
        ArrayPolynomial result = new ArrayPolynomial();
        for (int i = 0; i < maxSize; i++) {
            double a = (i < this.size) ? this.coefficents[i] : 0;
            double b = (i < another.size) ? another.coefficents[i] : 0;
            result.append(a - b);
        }
        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        /* TODO */
        int totalSize = this.size + another.size - 1;
        double[] result = new double[totalSize];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < another.size; j++) {
                result[i + j] += this.coefficents[i] * another.coefficents[j];
            }
        }
        ArrayPolynomial coeffs = new ArrayPolynomial();
        for (double elm : result) {
            coeffs.append(elm);
        }
        return coeffs;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        int newCapacity = size * 2;
        double[] newCoefficents = new double[newCapacity];
        for (int i = 0; i < size; i++) {
            newCoefficents[i] = coefficents[i];
        }
        coefficents = newCoefficents;
    }
}
