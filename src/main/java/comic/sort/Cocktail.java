package comic.sort;

import java.util.Arrays;

public class Cocktail {

    private static void sort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSort = true;
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;

                    isSort = false;
                }
            }

            System.out.print("第一轮排序：");
            print(array);

            if (isSort) {
                break;
            }

            isSort = true;
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;

                    isSort = false;
                }
            }
            System.out.print("第二轮排序：");
            print(array);
            if (isSort) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{2, 9, 5, 4, 6, 7, 8, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
