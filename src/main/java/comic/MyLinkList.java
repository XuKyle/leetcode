package comic;

public class MyLinkList {
    private Node head;
    private Node tail;
    private int size;

    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node insertedNode = new Node(data);
        if (size == 0) {
            head = insertedNode;
            tail = insertedNode;
        } else if (index == 0) {
            insertedNode.next = head;
            head = insertedNode;
        } else if (index == size) {
            tail.next = insertedNode;
            tail = insertedNode;
        } else {
            Node node = get(index - 1);
            insertedNode.next = node.next;
            node.next = insertedNode;
        }
        size++;
    }

    public Node remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            Node node = get(index - 1);
            node.next = null;
            removedNode = tail;
            tail = node;
        } else {
            Node preNode = get(index - 1);
            removedNode = preNode.next;
            preNode.next = removedNode.next;
        }

        size--;
        return removedNode;
    }

    public Node get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void print() {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.insert(3, 0);
        myLinkList.print();
        myLinkList.insert(7, 1);
        myLinkList.print();
        myLinkList.insert(9, 2);
        myLinkList.print();
        myLinkList.insert(5, 3);
        myLinkList.print();
        myLinkList.insert(4, 2);
        myLinkList.print();
        myLinkList.remove(1);
        myLinkList.print();
        Node remove = myLinkList.remove(0);
        System.out.println("remove = " + remove);
        myLinkList.print();
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
