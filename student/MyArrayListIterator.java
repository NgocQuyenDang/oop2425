package hus.oop.midterm.students;

public class MyArrayListIterator implements MyIterator {
    /* GỢI Ý: */
    /*
    MyArrayListIterator cần phải tham chiếu đến dữ liệu của MyArrayList để có thể duyệt qua
    các phần tử trong dữ liệu của MyArrayList.
     */
    private Object[] data;

    /*
    MyArrayListIterator cần phải biết vị trí hiện tại khi nó đang duyệt qua dữ liệu của MyArrayList.
     */
    private int currentPosition;
    private int size;

    /**
     * Khởi tạo dữ liệu cho Iterator bằng dữ liệu của MyArrayList để nó có thể duyệt qua các phần tử dữ liệu
     * của MyArrayList.
     * @param data
     */
    public MyArrayListIterator(Object[] data) {
        /* TODO */
        this.data = data;
    }

    public MyArrayListIterator(Object[] data, int size) {
        this.data = data;
        this.size = size;
        this.currentPosition = 0;
    }

    /**
     * Kiểm tra trong MyArrayList có còn phần tử tiếp theo không.
     * Nếu còn thì trả về true, nếu không còn thì trả về false.
     * @return
     */
    @Override
    public boolean hasNext() {
        /* TODO */
        return currentPosition < size;
    }

    /**
     * iterator dịch chuyển sang phần tử kế tiếp của MyArrayList và trả ra phần tử hiện tại của MyArrayList.
     * @return phần tử hiện tại.
     */
    @Override
    public Object next() {
        /* TODO */
        Object payload = data[currentPosition];
        currentPosition++;
        return payload;
    }
}
