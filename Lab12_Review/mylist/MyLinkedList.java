package hus.oop.mylist;

public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        this.head = null;
        this.size = 0;
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        /* TODO */
        return getNodeByIndex(index).getPayload();
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index == 0) {
            head = head.getNext();
        } else {
            MyLinkedListNode prev = getNodeByIndex(index - 1);
            prev.setNext(prev.getNext().getNext());
        }
        size--;
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     * @param payload
     */
    @Override
    public void append(Object payload) {
        /* TODO */
        MyLinkedListNode newNode = new MyLinkedListNode(payload);
        if (head == null) {
            head = newNode;
        } else {
            MyLinkedListNode last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newNode);
        }
        size++;
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        /* TODO */
        MyLinkedListNode newNode = new MyLinkedListNode(payload);

        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            MyLinkedListNode prev = getNodeByIndex(index - 1);
            newNode.setNext(prev.getNext());
            prev.setNext(newNode);
        }
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
        MyLinkedListNode currentNode = head;
        return new MyLinkedListIterator(currentNode);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyLinkedListNode getNodeByIndex(int index) {
        /* TODO */
        MyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }
}
