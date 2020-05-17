package easy;

import java.util.Arrays;
import java.util.HashSet;

public class Solution136 {
    public static void main(String[] args) {
        int[] array = {4, 1, 2, 1, 2};
        System.out.println("find(array) = " + find(array));


        Solution136 solution136 = new Solution136();
        System.out.println("solution136.singleNumber(array) = " + solution136.singleNumber(array));
        System.out.println("solution136.singleNumber2(array) = " + solution136.singleNumber2(array));
    }

    //    本题根据题意，线性时间复杂度 O(n)O(n)，很容易想到使用 Hash 映射来进行计算，遍历一次后结束得到结果，但是在空间复杂度上会达到 O(n)O(n)，需要使用较多的额外空间
//    既满足时间复杂度又满足空间复杂度，就要提到位运算中的异或运算 XOR，主要因为异或运算有以下几个特点：
//    一个数和 0 做 XOR 运算等于本身：a⊕0 = a
//    一个数和其本身做 XOR 运算等于 0：a⊕a = 0
//    XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
//    故而在以上的基础条件上，将所有数字按照顺序做抑或运算，最后剩下的结果即为唯一的数字
//    时间复杂度：O(n)O(n)，空间复杂度：O(1)O(1)
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public int singleNumber2(int[] nums) {
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }

    public static int find(int[] array) {
        HashSet<Integer> exists = new HashSet<>();
        for (int elem : array) {
            if (exists.contains(elem)) {
                exists.remove(elem);
            } else {
                exists.add(elem);
            }
        }
        return exists.stream().findFirst().orElse(-1);
    }
}
