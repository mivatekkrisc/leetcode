package leecode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        return permute(nums, 0);

    }

    public List<List<Integer>> permute(int[] nums, int i) {

        if (i == nums.length - 1)
            return Arrays.asList(Arrays.asList(nums[i]));

        List<List<Integer>> suffix = permute(nums, i + 1);

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> l2 : suffix) {
            for(int j = 0 ; j <= l2.size(); j++) {
                List<Integer> list = new ArrayList<>();
                list.addAll(l2);
                list.add(j, nums[i]);
                result.add(list);
            }

        }
        return result;
    }

    public static void main(String args[]) {
        Permutations p = new Permutations();
        for (List<Integer> l : p.permute(new int[]{1, 2, 3})) {
            System.out.println(l.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
        }
    }
}
