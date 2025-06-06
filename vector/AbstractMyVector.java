package hus.oop.midterm.vector;
import java.util.Arrays;

public abstract class AbstractMyVector implements MyVector {
    /**
     * Mô tả vector theo định dạng [a1 a2 ... an]
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size(); i++) {
            sb.append(coordinate(i));
            if (i != size() - 1) {
                sb.append(" ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    /**
     * So sánh hai vector có bằng nhau không.
     * Hai vector bằng nhau nếu có cùng số chiều và có tọa độ bằng nhau.
     * @param another
     * @return
     */
    @Override
    public boolean equals(MyVector another) {
        /* TODO */
        return this.size() == another.size() && Arrays.equals(this.coordinates(), another.coordinates());
    }
}
