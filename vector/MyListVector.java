package hus.oop.midterm.vector;

import java.util.ArrayList;
import java.util.List;

public class MyListVector extends AbstractMyVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        /* TODO */
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        /* TODO */
        return data.size();
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        /* TODO */
        double[] data = new double[size()];
        for (int i = 0; i < size(); i++) {
            data[i] = coordinate(i);
        }
        return data;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
        data.set(index, value);
    }

    /**
     * Cộng các giá trị tọa độ với value.
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector add(double value) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + value);
        }
        return this;
    }

    /**
     * Cộng vector khác vào vector hiện tại.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     * @param another
     * @return vector hiện tại.
     */
    public MyListVector add(MyListVector another) {
        /* TODO */
        if (this.size() != another.size()) {
            System.out.println("Cannot add two vectors");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + another.data.get(i));
        }
        return this;
    }

    /**
     * Trừ các giá trị tọa độ của vector cho value.
     * @return vector hiện tại.
     */
    public MyListVector minus(double value) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) - value);
        }
        return this;
    }

    /**
     * Trừ vector hiện tại với vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return
     */
//    public MyListVector minus() {
//        /* TODO */
//    }

    /**
     * Trừ vector hiện tại với vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return vector hiện tại.
     */
    public MyListVector minus(MyListVector another) {
        /* TODO */
        if (this.size() != another.size()) {
            System.out.println("Cannot minus two vectors");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) - another.data.get(i));
        }
        return this;
    }

    /**
     * Tích vô hướng của hai vector.
     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
     * @return vector hiện tại.
     */
    public MyListVector dot(MyListVector another) {
        /* TODO */
        MyListVector vector = new MyListVector();
        if (this.size() != another.size()) {
            System.out.println("Cannot dot two vectors");
        } else {
            double x = data.get(1) * another.data.get(2) - data.get(2) * another.data.get(1);
            double y = data.get(2) * another.data.get(0) - data.get(0) * another.data.get(2);
            double z = data.get(0) * another.data.get(1) - data.get(1) * another.data.get(0);
            vector.insert(x).insert(y).insert(z);
        }
        return vector;
    }

    /**
     * Các giá trị của vector được lấy mũ power.
     * @param power
     * @return vector hiện tại.
     */
    public MyListVector pow(double power) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, Math.pow(data.get(i), power));
        }
        return this;
    }

    /**
     * Các giá trị tọa độ của vector được nhân với value.
     * @return vector hiện tại.
     */
    public MyListVector scale(double value) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) * value);
        }
        return this;
    }

    /**
     * Lấy chuẩn của vector.
     * @return chuẩn của vector.
     */
    @Override
    public double norm() {
        /* TODO */
        double sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += Math.pow(data.get(i), 2);
        }
        return Math.sqrt(sum);
    }

    /**
     * Thêm một giá trị value vào tọa độ vector ở vị trí cuối cùng.
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector insert(double value) {
        /* TODO */
        data.add(value);
        return this;
    }

    /**
     * Thêm một giá trị vào tọa độ vector ở vị trí index.
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector insert(double value, int index) {
        /* TODO */
        data.add(index, value);
        return this;
    }

    /**
     * Xóa giá trị ở tọa độ thứ index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector remove(int index) {
        /* TODO */
        if  (index >= 0 && index < data.size()) {
            data.remove(index);
        } else {
            System.out.println("Index out of bounds!");
        }
        return this;
    }

    /**
     * Trích xuất ra một vector con của vector ban đầu, có các giá trị tọa độ
     * được lấy theo các chỉ số của mảng đầu vào.
     * Ví dụ, cho vector [1 2 3 4 5], cho mảng đầu vào là {2, 1} thì vector trích xuất ra
     * có tọa độ là [2 1].
     * Nếu có thỉ số trong mảng đầu vào không hợp lệ thì in ra thông báo lỗi,
     * hoặc ném exception.
     * @param indices
     * @return vector mới có tọa độ được trích xuất từ vector hiện tại.
     */
    public MyListVector extract(int[] indices) {
        /* TODO */
        for (int i = 0; i < indices.length; i++) {
            if ( i < 0 || i >= size()) {
                System.out.println("Cannot extract vector value");
            }
        }
        MyListVector vector = new MyListVector();
        for (int i = 0; i < indices.length; i++) {
            vector.insert(data.get(indices[i]));
        }
        return vector;
    }
}
