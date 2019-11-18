package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            combination(candidates, i, target - candidates[i], list, result);
        }
        return result;
    }

    public void combination(int[] nums, int i, int target, List<Integer> list, List<List<Integer>> result) {

        if (target == 0) {
            result.add(list);
            return;
        }

        if (nums[i] > target)
            return;

        if (target == nums[i]) {
            list.add(nums[i]);
            result.add(list);
            return;
        }

        List<Integer> l1 = new ArrayList<>();
        l1.addAll(list);
        l1.add(nums[i]);
        combination(nums, i, target - nums[i], l1, result);

        for (int j = i + 1; j < nums.length; j++) {
            List<Integer> l2 = new ArrayList<>();
            l2.addAll(list);
            l2.add(nums[j]);
            combination(nums, j, target - nums[j], l2, result);
        }

    }

    public static void main(String args[]) {
        for (List<Integer> list : new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7)) {

            System.out.println(list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));

        }

        for (List<Integer> list : new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8)) {

            System.out.println(list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));

        }

        for (List<Integer> list : new CombinationSum().combinationSum(new int[]{2, 3, 5}, 7)) {

            System.out.println(list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));

        }
    }
}
