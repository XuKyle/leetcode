package easy;

public class Solution69 {
    public static void main(String[] args) {
        int sqrt = new Solution69().mySqrt(2147395599);
        System.out.println("sqrt = " + sqrt);
        sqrt = new Solution69().mySqrt1(2147395599);
        System.out.println("sqrt = " + sqrt);
    }


    public int mySqrt(int x) {
        int left = 0, right = x, answer = -1;
        while (left <= right) {
            int mid = left + (right - 1) / 2;
            if (mid * mid <= x) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public int mySqrt1(int x) {
        if (x < 2) {
            return x;
        }
        int l = 2, r = x / 2;
        while (l <= r) {
            long mid = (l + r) >> 1;
            if (mid * mid < x) {
                l = (int) (mid + 1);
            } else if (mid * mid > x) {
                r = (int) (mid - 1);
            } else {
                return (int) mid;
            }
        }
        return l - 1;
    }
}
