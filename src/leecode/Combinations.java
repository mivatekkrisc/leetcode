package leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        int[] nums = new int[n];
        for(int i = 1; i <= n; i++)
            nums[i-1] = i;

        return combine(nums, 1, k);
    }

    public List<List<Integer>> combine(int[] nums, int start, int k) {

        List<List<Integer>> tmp = new ArrayList<>();
        if (k == 1) {
            for (int i = start; i <= nums.length; i++) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                tmp.add(l);
            }
            return tmp;
        }

        for(int i = start; i <= nums.length; i++) {
            List<List<Integer>> subList = combine(nums, i+1, k - 1);
            for(List<Integer> l : subList) {
                l.add(0, i);
                tmp.add(l);
            }
        }
        return tmp;

    }

    public static void main(String args[]) {
        List<List<Integer>> result = new Combinations().combine(4,3);
        for(List<Integer> l : result)
            System.out.println(l.stream().map(i->String.valueOf(i)).collect(Collectors.joining(",")));
    }
}
