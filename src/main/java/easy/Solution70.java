package easy;

import java.util.HashMap;
import java.util.Map;

public class Solution70 {

    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        int climbStairs = solution70.climbStairs(10);
        System.out.println("climbStairs = " + climbStairs);
        climbStairs = solution70.climbStairs1(10);
        System.out.println("climbStairs = " + climbStairs);
        climbStairs = solution70.climbStairs2(10);
        System.out.println("climbStairs = " + climbStairs);
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        if (n <= 2) {
            map.put(n, n);
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int result = climbStairs2(n - 1) + climbStairs2(n - 2);
            map.put(n, result);
            return result;
        }
    }
}
