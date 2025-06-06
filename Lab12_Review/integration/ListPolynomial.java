package hus.oop.integration;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        /* TODO */
        this.coefficients = new ArrayList<>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + coefficients.size());
        }
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial append(double coefficient) {
        /* TODO */
        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + coefficients.size());
        }
        coefficients.add(index, coefficient);
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + coefficients.size());
        }
        coefficients.set(index, coefficient);
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        int deg = coefficients.size() - 1;
        while (deg > 0 && coefficients.get(deg) == 0) {
            deg--;
        }
        return deg;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0.0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        double[] derivedCoeffs = differentiate();
        ListPolynomial result = new ListPolynomial();
        for (double elm : derivedCoeffs) {
            result.append(elm);
        }
        return result;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        /* TODO */
        int maxSize = Math.max(this.coefficients.size(), another.coefficients.size());
        ListPolynomial result = new ListPolynomial();

        for (int i = 0; i < maxSize; i++) {
            double a = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0;
            double b = (i < another.coefficients.size()) ? another.coefficients.get(i) : 0;
            result.append(a + b);
        }
        return result;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        /* TODO */
        int maxSize = Math.max(this.coefficients.size(), another.coefficients.size());
        ListPolynomial result = new ListPolynomial();
        for (int i = 0; i < maxSize; i++) {
            double a = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0;
            double b = (i < another.coefficients.size()) ? another.coefficients.get(i) : 0;
            result.append(a - b);
        }
        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        /* TODO */
        int totalSize = this.coefficients.size() + another.coefficients.size() - 1;
        double[] result = new double[totalSize];
        for (int i = 0; i < this.coefficients.size(); i++) {
            for (int j = 0; j < another.coefficients.size(); j++) {
                result[i + j] += this.coefficients.get(i) * another.coefficients.get(j);
            }
        }

        ListPolynomial coeffs = new ListPolynomial();
        for (double elm : result) {
            coeffs.append(elm);
        }
        return coeffs;
    }
}
