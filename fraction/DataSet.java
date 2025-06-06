package hus.oop.fraction;

public class DataSet {
    private static int DEFAULT_CAPACITY = 8;
    private Fraction[] data;
    private int length;


    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public DataSet() {
        this.data = new Fraction[DEFAULT_CAPACITY];
        this.length = 0;
    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số theo data.
     * @param data
     */
    public DataSet(Fraction[] data) {
        this.data = data;
    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    public boolean insert(Fraction fraction, int index) {
        /* TODO */
        if (this.length == data.length) {
            enlarge();
        }

        if (index >= 0 && index < length) {
            return true;
        }
        return false;
    }

    /**
     * Phương thức tạo ra một tập dữ liệu lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     * @return tập dữ liệu mới lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     */
    public DataSet toSimplify() {
        /* TODO */
        DataSet result = new DataSet();
        int i =0;
        for (int j = 0; j < this.length; j++) {
            data[j].simplify();
            result.append(data[j]);
        }
        return result;
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dứ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction
     * @return
     */
    public void append(Fraction fraction) {
        /* TODO */
        if (this.length == data.length) {
            enlarge();
        }
        data[length] = fraction;
        length++;
    }

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị tăng dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số tăng dần.
     * @return mảng mới được sắp xếp theo thứ tự có giá trị tăng dần.
     */
    public Fraction[] sortIncreasing() {
        /* TODO */
        Fraction[] result = new Fraction[length];
        System.arraycopy(data, 0, result, 0, length);
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (result[j].compareTo(result[j + 1]) > 0) {
                    Fraction temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị giảm dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số giảm dần.
     * @return mảng mới được sắp xếp theo thứ tự có giá trị giảm dần.
     */
    public Fraction[] sortDecreasing() {
        /* TODO */
        Fraction[] result = new Fraction[length];
        System.arraycopy(data, 0, result, 0, length);
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (result[j].compareTo(result[j + 1]) < 0) {
                    Fraction temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dự liệu từ mảng cũ vào.
     */
    private void enlarge() {
        /* TODO */
        int newCapacity = data.length * 2;
        Fraction[] newData = new Fraction[newCapacity];
        System.arraycopy(data, 0, newData, 0, length);
        data = newData;
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        /* TODO */
        if (index >= 0 && index < upperBound) {
            return true;
        }
        return false;
    }

    /**
     * In ra tập dữ liệu theo định dạng [a1, a2, ... , an].
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append("\n");
        for (int i = 0; i < length; i++) {
            sb.append(data[i]).append("\n");
            if (i != length - 1) {
                sb.append("");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * In ra mảng các phân số fractions theo định dạng [a1, a2, ... , an].
     * @param fractions
     */
    public static void printFractions(Fraction[] fractions) {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Fraction fraction : fractions) {
            sb.append(fraction).append("\n");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
