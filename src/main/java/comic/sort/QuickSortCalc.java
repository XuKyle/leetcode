package comic.sort;

import java.util.Arrays;

public class QuickSortCalc {

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

        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }

        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }
}
