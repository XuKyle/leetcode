package easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution125 {

    public static void main(String[] args) {
//        String source = "A man, a plan, a canal: Panama";
        String source = "race a car";

        Solution125 solution = new Solution125();
        boolean palindrome = solution.isPalindrome(source);
        System.out.println("palindrome = " + palindrome);

        boolean palindrome1 = solution.isPalindrome2(source);
        System.out.println("palindrome1 = " + palindrome1);
    }


    public boolean isPalindrome(String s) {

        Pattern p = Pattern.compile("[^A-Za-z0-9]");

        Matcher matcher = p.matcher(s);
        String toLowerCase = matcher.replaceAll("").trim().toLowerCase();

        char[] chars = toLowerCase.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            int x = chars[left];
            int y = chars[right];
            if (Character.isLetterOrDigit(x)) {
                if (Character.isLetterOrDigit(y)) {
                    if (x != y) {
                        return false;
                    }
                    left++;
                    right--;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return true;
    }
}
