package hus.oop.fraction;

public class Fraction implements FractionComparable {
    private int numerator;
    private int denominator;

    /**
     * Hàm dựng khởi tạo giá trị mặc định là 1/1.
     */
    public Fraction() {
        /* TODO */
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * Hàm dựng khởi tạo giá trị cho tử số và mẫu số.
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        /* TODO */
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Hàm dựng copy, copy giá trị của phân số truyền vào.
     * @param copyFraction
     */
    public Fraction(Fraction copyFraction) {
        /* TODO */
        this.numerator = copyFraction.numerator;
        this.denominator = copyFraction.denominator;
    }

    public int getNumerator() {
        /* TODO */
        return numerator;
    }

    public void setNumerator(int numerator) {
        /* TODO */
        this.numerator = numerator;
    }

    public int getDenominator() {
        /* TODO */
        return denominator;
    }

    public void setDenominator(int denominator) {
        /* TODO */
        this.denominator = denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu byte của phân số.
     * @return
     */
    public byte byteValue() {
        /* TODO */
        int divided = numerator / denominator;
        return (byte) divided ;
    }

    /**
     * Phương thức trả về giá trị kiểu int của phân số.
     * @return
     */
    public int intValue() {
        /* TODO */
        return numerator / denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu long của phân số.
     * @return
     */
    public long longValue() {
        /* TODO */
        return (long) numerator / denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu short của phân số.
     * @return
     */
    public short shortValue() {
        /* TODO */
        int divided = numerator / denominator;
        return (short) divided ;
    }

    /**
     * Phương thức trả về giá trị kiểu double của phân số.
     * @return
     */
    public double doubleValue() {
        /* TODO */
        return (double) numerator / denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu float của phân số.
     * @return
     */
    public float floatValue() {
        /* TODO */
        return (float) numerator / denominator;
    }

    /**
     * Phương thức tính ước số chung lớn nhất của tử số và mẫu số.
     * @return ước số chung lớn nhất của tử số và mẫu số.
     */
    public int gcd() {
        /* TODO */
        while (true) {
            while (numerator >= denominator) {
                numerator = numerator - denominator;
            }
            if (numerator == 0) {
                return denominator;
            }
            int temp = denominator;
            denominator = numerator;
            numerator = temp;
        }

    }

    /**
     * Phương thức rút gọn phân số về phân số tối giản.
     */
    public void simplify() {
        /* TODO */
        int temp1 = numerator;
        int temp2 = denominator;
        int gcdValue = gcd();
        numerator = temp1 / gcdValue;
        denominator = temp2 / gcdValue;
    }

    @Override
    public int compareTo(Fraction another) {
        /* TODO */
        int a = this.numerator;
        int b = this.denominator;
        int c = another.numerator;
        int d = another.denominator;
        int Y = a * d - b * c;
        return Y;
    }

    /**
     * Phương thức mô tả phân số theo định dạng numerator/denominator;
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append(numerator).append(" / ").append(denominator);
        return sb.toString();
    }
}
