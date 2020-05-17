package comic;

import java.util.Arrays;

public class MyArray {
    private int size;
    private int[] array;

    public MyArray(int capacity) {
        this.size = 0;
        this.array = new int[capacity];
    }

    public void insert(int element, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size >= array.length) {
            resize();
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
    }

    public int delete(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int elem = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
        return elem;
    }

    public void print() {
        System.out.println("Array:" + Arrays.toString(array) + " Size:" + size);
    }

    public void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        this.array = newArray;
    }

    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(10);

        myArray.insert(3, 0);
        myArray.insert(7, 1);
        myArray.insert(9, 2);
        myArray.insert(5, 3);
        myArray.insert(6, 1);
        myArray.insert(11, 1);
        myArray.insert(12, 1);
        myArray.insert(13, 1);
        myArray.insert(14, 1);
        myArray.insert(15, 1);
        myArray.insert(16, 1);
        myArray.print();

        myArray.delete(1);
        myArray.print();
    }
}
