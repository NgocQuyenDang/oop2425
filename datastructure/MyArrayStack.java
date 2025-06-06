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
        this.elements = new int[initialCapacity];
        this.numberOfElements = 0;
    }

    @Override
    public void push(int value) {
        /* TODO */
        if (numberOfElements == elements.length) {
            grow();
        }
        for (int i = numberOfElements; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = value;
        numberOfElements++;
    }

    /*
     * Tăng kích thước stack lên gấp đôi.
     */
    private void grow() {
        /* TODO */
        int newCapacity = elements.length * 2;
        int[] newElements = new int[newCapacity];
        for (int i = 0; i < numberOfElements; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public int pop() {
        /* TODO */
        int result = elements[0];
        for (int i = 1; i < numberOfElements;i++) {
            elements[i - 1] = elements[i];
        }
        numberOfElements--;
        return result;
    }

    @Override
    public int peek() {
        /* TODO */
        return elements[0];
    }

    @Override
    public boolean isEmpty() {
        /* TODO */
        return numberOfElements == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numberOfElements; i++) {
            sb.append(elements[i]);
            if (i != numberOfElements - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }


}
