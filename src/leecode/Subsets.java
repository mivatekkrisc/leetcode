package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    public List<List<Integer>> subsets(int[] nums, int start) {
        List<List<Integer>> tmp = new ArrayList<>();

        tmp.add(new ArrayList<>());
        tmp.add(Arrays.asList(nums[start]));
        if (start == nums.length - 1)
            return tmp;

        List<List<Integer>> sublist = subsets(nums, start + 1);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            for (int j = 0; j < sublist.size(); j++) {
                List<Integer> list = new ArrayList<>();
                list.addAll(tmp.get(i));
                list.addAll(sublist.get(j));
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        for (List<Integer> l : new Subsets().subsets(new int[]{1, 2, 3}))
            System.out.println(l.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
    }


}
