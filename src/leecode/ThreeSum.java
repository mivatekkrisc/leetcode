package leecode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        Set<Integer> checked = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {

            if (checked.contains(nums[i]))
                continue;

            checked.add(nums[i]);
            int target = -nums[i];

            Map<Integer, Integer> map = new HashMap<>();
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List l = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(l);
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;

                } else if (nums[j] + nums[k] < target) j++;
                else k--;
            }
//            for (int j = i + 1; j != i && j < nums.length; j++) {
//                int remain = target - nums[j];
//                if (map.get(remain) != null) {
//
//                    List l = Arrays.asList(nums[i], remain, nums[j]);
//                    if(!result.contains(l))
//                        result.add(l);
//
//                } else {
//                    map.put(nums[j], j);
//                }
//            }
        }

        return result;
    }

    public static void main(String args[]) {
        ThreeSum t = new ThreeSum();

        List<List<Integer>> result = t.threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0});
        for (List<Integer> list : result) {
            System.out.println(list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
        }

//        result = t.threeSum(new int[]{0, 0, 0, 0});
//        for (List<Integer> list : result) {
//            System.out.println(list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
//        }
    }
}
