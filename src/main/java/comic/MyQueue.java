package comic;

public class MyQueue {
    private int[] array;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    public void enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("queue full!");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("empty queue!");
        }

        int elem = array[front];
        front = (front + 1) % array.length;
        return elem;
    }

    public void print() {
        System.out.println("front = " + front + " rear: " + rear);
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.print(array[i]);
            if ((i + 1) % array.length != rear) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(6);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.enQueue(5);
        myQueue.print();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.print();
        myQueue.enQueue(99);
        myQueue.print();
    }
}
