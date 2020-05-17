package comic;

import java.util.Arrays;

public class MyPriorityQueue {
    private int[] array;
    private int size;

    public MyPriorityQueue() {
        this.array = new int[32];
    }


    private void enQueue(int elem) {
        if (size >= array.length) {
            resize();
        }
        array[size++] = elem;
        upAdjust(array);
    }

    public int deQueue() throws Exception {
        if (array.length == 0) {
            throw new Exception("queue is empty!");
        }

        int head = array[0];
        array[0] = array[size--];
        downAdjust(array, 0, array.length);
        return head;
    }

    private void resize() {
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(array, newSize);
    }

    /**
     * 二叉堆 添加 上浮操作
     *
     * @param array
     */
    private void upAdjust(int[] array) {
        int currentIndex = size - 1;
        int parentIndex = (currentIndex - 1) / 2;
        int temp = array[currentIndex];

        while (currentIndex > 0 && temp > array[parentIndex]) {
            array[currentIndex] = array[parentIndex];
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }

        array[currentIndex] = temp;
    }

    /**
     * 下沉操作
     *
     * @param array       待调整的堆
     * @param parentIndex 要下沉的节点
     * @param length      堆的长度
     */
    public void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            if (temp > array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    public static void main(String[] args) throws Exception {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(10);
        queue.enQueue(2);
        queue.enQueue(7);
        System.out.println(Arrays.toString(queue.array));
        System.out.println("出列 1：" + queue.deQueue());
        System.out.println("出列 2：" + queue.deQueue());
    }

}
