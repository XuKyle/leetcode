package comic;

import java.util.Arrays;

// 二插堆
public class MyHeap {


    /**
     * 二叉堆 添加 上浮操作
     *
     * @param array
     */
    private static void upAdjust(int[] array) {
        int currentIndex = array.length - 1;
        int parentIndex = (currentIndex - 1) / 2;
        int temp = array[currentIndex];

        while (currentIndex > 0 && temp < array[parentIndex]) {
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
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }

            if (temp < array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    public static void buildHeap(int[] array) {
        // 从最后一个非子节点开始下沉
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
