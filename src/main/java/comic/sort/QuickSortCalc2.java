package comic.sort;

import java.util.Arrays;

public class QuickSortCalc2 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int partition = partition(arr, startIndex, endIndex);

        quickSort(arr, startIndex, partition - 1);
        quickSort(arr, partition + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            int currentValue = arr[i];
            if (pivot > currentValue) {
                mark++;


                arr[i] = arr[mark];
                arr[mark] = currentValue;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
}
