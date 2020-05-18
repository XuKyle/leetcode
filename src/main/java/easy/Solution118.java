package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution118 {
    public static void main(String[] args) {
        Solution118 solution = new Solution118();
        List<List<Integer>> generate = solution.generate(8);
        System.out.println("generate = " + generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;

        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        while (result.size() < numRows) {
            List<Integer> integers = result.get(result.size() - 1);
            LinkedList<Integer> left = new LinkedList<>(integers);
            left.addFirst(0);
            LinkedList<Integer> right = new LinkedList<>(integers);
            right.addLast(0);

            List<Integer> thisRow = new ArrayList<>();
            for (int i = 0; i < left.size(); i++) {
                thisRow.add(left.get(i) + right.get(i));
            }

            result.add(thisRow);
        }

        return result;
    }
}
