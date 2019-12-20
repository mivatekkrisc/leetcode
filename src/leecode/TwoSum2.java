package leecode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {

//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        for (int i = 0; i < numbers.length; i++) {
//            int remain = target - numbers[i];
//            if (map.get(remain) != null)
//                return new int[]{map.get(remain) + 1, i + 1};
//            else
//                map.put(numbers[i], i);
//        }
//        return new int[0];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target)
                return new int[]{i + 1, j + 1};
            else if (sum > target)
                j--;
            else
                i++;
        }
        return new int[0];

    }

    public static void main(String args[]) {
        int[] result = new TwoSum2().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0] + " " + result[1]);
    }
}
