package hus.oop.mystudentmanager;

public class Node {
    public Object data;
    public Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
