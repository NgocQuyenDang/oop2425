package hus.oop.datastructure;

/**
 * Stack sử dụng cấu trúc dữ liệu mảng.
 */
public class MyArrayStack implements MyStack {
    public static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private int[] elements;
    private int numberOfElements;

    public MyArrayStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyArrayStack(int initialCapacity) {
        /* TODO */
    }

    @Override
    public void push(int value) {
        /* TODO */
    }

    /*
     * Tăng kích thước stack lên gấp đôi.
     */
    private void grow() {
        /* TODO */
    }

    @Override
    public int pop() {
        /* TODO */
    }

    @Override
    public int peek() {
        /* TODO */
    }

    @Override
    public boolean isEmpty() {
        /* TODO */
    }
}
