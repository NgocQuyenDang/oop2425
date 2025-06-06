package hus.oop.datastructure;

public class MyLinkedListQueue implements MyQueue {
    private Node head;
    private Node tail;

    @Override
    public void enqueue(int element) {
        /* TODO */
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    @Override
    public int dequeue() {
        /* TODO */
        if (isEmpty()) {
            return -1;
        }

        Node temp = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        temp.next = null;
        return temp.data;
    }

    @Override
    public int peek() {
        /* TODO */
        Node first = head;
        return first.data;
    }

    @Override
    public boolean isEmpty() {
        /* TODO */
        return head == null;
    }

    public String toString() {
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) {
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
