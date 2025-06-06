package hus.oop.datastructure;

import java.util.Arrays;
import java.util.Random;

public class TestDataStructure {
    public static void main(String[] args) {
        /* TODO
        Yêu cầu:

        - Hoàn thiện code chương trình theo mẫu đã cho.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_DataStructure>.txt (Ví dụ, NguyenVanA_123456_DataStructure.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_DataStructure>.zip (Ví dụ, NguyenVanA_123456_DataStructure.zip),
          nộp lên classroom.
        */
        testArrayStack();
        testArrayQueue();
        testLinkedListStack();
        testLinkedListQueue();
    }

    public static void testArrayStack() {
        /* TODO
         - Sinh ngẫu nhiên ra một số tự nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào stack.
            + In ra các phần tử trong stack.
            + Lần lượt xóa các phần tử trong stack. Sau mỗi lần xóa, in ra các phần tử còn lại trong stack.
         */
        System.out.println("testArrayStack : ");
        MyArrayStack arrayStack = new MyArrayStack();
        Random random = new Random();
        int n = random.nextInt(11) + 20;
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(11) + 20;
            arrayStack.push(value);
        }
        System.out.println("Array Stack : " + arrayStack.toString());
        for(int i = 0; i < n; i++) {
            arrayStack.pop();
            System.out.println("Remaining elements: " +  arrayStack.toString());
        }
    }

    public static void testLinkedListStack() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào stack.
            + In ra các phần tử trong stack.
            + Lần lượt xóa các phần tử trong stack. Sau mỗi lần xóa, in ra các phần tử còn lại trong stack.
         */
        MyLinkedListStack listStack = new MyLinkedListStack();
        Random random = new Random();
        int n = random.nextInt(11) + 20;
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(11) + 20;
            listStack.push(value);
        }

        System.out.println("LinkedList Stack : " + listStack.toString());

        for (int i = 0; i < n; i++) {
            listStack.pop();
            System.out.println("Remaining elements: " +  listStack.toString());
        }
    }

    public static void testArrayQueue() {
        /* TODO
         - Sinh ngẫu nhiên ra một số tự nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào queue.
            + In ra các phần tử trong queue.
            + Lần lượt xóa các phần tử trong queue. Sau mỗi lần xóa, in ra các phần tử còn lại trong queue.
         */
        MyArrayQueue arrayQueue = new MyArrayQueue();
        Random random = new Random();
        int n = random.nextInt(11) + 20;
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(11) + 20;
            arrayQueue.enqueue(value);
        }
        System.out.println("Array Queue: " + arrayQueue);

        for (int i = 0; i < n; i++) {
            arrayQueue.dequeue();
            System.out.println("Remaining elements: " +  arrayQueue);
        }
    }

    public static void testLinkedListQueue() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào queue.
            + In ra các phần tử trong queue.
            + Lần lượt xóa các phần tử trong queue. Sau mỗi lần xóa, in ra các phần tử còn lại trong queue.
         */
        MyLinkedListQueue listQueue = new MyLinkedListQueue();
        Random random = new Random();
        int n = random.nextInt(11) + 20;
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(11) + 20;
            listQueue.enqueue(value);
        }
        System.out.println("LinkedList Queue: " + listQueue.toString());

        for (int i = 0; i < n; i++) {
            listQueue.dequeue();
            System.out.println("Remaining elements: " +  listQueue.toString());
        }
    }
}
