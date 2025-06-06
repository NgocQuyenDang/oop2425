package hus.oop.datastructure;

public class MyArrayQueue implements MyQueue {
    public static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private int[] elements;
    private int headIndex;
    private int tailIndex;
    private int numberOfElements;

    public MyArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyArrayQueue(int capacity) {
        /* TODO */
    }

    @Override
    public void enqueue(int element) {
        /* TODO */
    }

    /*
     * Tăng kích thước queue gấp đôi.
     */
    private void grow() {
        /* TODO */
    }

    @Override
    public int dequeue() {
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
