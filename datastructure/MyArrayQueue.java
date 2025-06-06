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
        this.elements = new int[capacity];
        this.headIndex = 0;
        this.tailIndex = 0;
        this.numberOfElements = 0;
    }

    @Override
    public void enqueue(int element) {
        /* TODO */
        if (numberOfElements == elements.length) {
            grow();
        }
        int tailIndex = (headIndex + numberOfElements) % elements.length;
        elements[tailIndex] = element;
        numberOfElements++;
    }

    /*
     * Tăng kích thước queue gấp đôi.
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
    public int dequeue() {
        /* TODO */
        int result = elements[headIndex];
        headIndex = (headIndex + 1) % elements.length;
        numberOfElements--;
        return result;
    }

    @Override
    public int peek() {
        /* TODO */
        return elements[headIndex];
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
            int index = (headIndex + i) % elements.length;
            sb.append(elements[index]);
            if (i < numberOfElements - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
