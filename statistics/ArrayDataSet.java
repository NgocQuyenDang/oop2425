package hus.oop.statistics;

public class ArrayDataSet extends AbstractDataSet {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public ArrayDataSet() {
        /* TODO */
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    @Override
    public double elementAt(int index) {
        /* TODO */
        return data[index];
    }

    @Override
    public double[] elements(int from, int to) {
        /* TODO */
        double[] result = new double[(to - from) + 1];
        int index = 0;
        if (from > to || from < 0 || to >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = from; i <= to; i++) {
                result[index++] = data[i];
            }
        }
        return result;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(double value) {
        /* TODO */
        if (size == data.length) {
            allocateMore();
        }
        for (int i = size - 1; i >= 0; i--) {
            data[i + 1] = data[i];
        }
        data[0] = value;
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(double value) {
        /* TODO */
        if (size == data.length) {
            allocateMore();
        }
        data[size] = value;
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param index
     * @param value
     */
    @Override
    public void insertAtPosition(int index, double value) {
        /* TODO */
        if (data.length == size) {
            allocateMore();
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
        }
        size--;
    }

    /**
     * Xóa tất cả các phần tử dữ liệu có giá trị bằng value.
     * @param value
     */
    @Override
    public void remove(double value) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            if (elementAt(i) == value) {
                this.remove(i);
            }
        }
    }

    /**
     * Mở rộng gấp đôi kích thước mảng nếu hết chỗ để chứa dữ liệu.
     */
    private void allocateMore() {
        /* TODO */
        int newCapacity = data.length * 2;
        double[] newData = new double[newCapacity];
        for (int i = 0; i < size(); i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
