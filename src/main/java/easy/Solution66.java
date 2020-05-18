package easy;

import java.util.Arrays;

public class Solution66 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        Solution66 solution66 = new Solution66();
        int[] result = solution66.plusOne(ints);
        System.out.println("result = " + Arrays.toString(result));
    }


    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
