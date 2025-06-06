package hus.oop.datastructure;

/**
 * Stack sử dụng cấu trúc dữ liệu linked list.
 */
public class MyLinkedListStack implements MyStack {
    private Node top;

    @Override
    public void push(int value) {
        /* TODO */
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    @Override
    public int pop() {
        /* TODO */
        Node temp = top;
        top = top.next;
        return temp.data;
    }

    @Override
    public int peek() {
        /* TODO */
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        /* TODO */
        return top == null;
    }

    public String toString() {
        Node curr = top;
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
