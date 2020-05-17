package comic.sort;

import java.util.Arrays;

public class Bubble {

    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSort = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = -1;
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    isSort = true;
                }
            }
            if (!isSort) {
                break;
            } else {
                System.out.println("发生了交换");
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
//        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
