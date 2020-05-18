package easy;

public class Solution7 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int reverse = solution7.reverse(-1563847412);
        System.out.println("reverse = " + reverse);
    }

    public int reverse(int x) {
        int flag = x < 0 ? -1 : 1;
        x = x * flag;
        Long l = r(x) * flag;
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        }
        return l.intValue();
    }

    public Long r(int x) {
        long result = 0;
        while (x > 0) {
            int mod = x % 10;
            x = x / 10;
            result = result * 10 + mod;
        }
        return result;
    }

    public int reverse1(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

}
