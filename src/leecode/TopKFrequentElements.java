package leecode;

import java.lang.reflect.Array;
import java.util.*;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Set<Integer>> byFrequency = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Integer> byNum = new HashMap<>();

        for (int num : nums) {
            if (byNum.containsKey(num)) {
                int frequency = byNum.get(num) + 1;
                byNum.put(num, frequency);
            } else
                byNum.put(num, 1);
        }

        for (Integer key : byNum.keySet()) {
            int frequency = byNum.get(key);
            if (byFrequency.containsKey(frequency)) {
                byFrequency.get(frequency).add(key);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(key);
                byFrequency.put(frequency, set);
            }
        }

        List<Integer> result = new ArrayList<>();
        Iterator<Map.Entry<Integer, Set<Integer>>> iter = byFrequency.entrySet().iterator();
        while (k > 0) {
            Set<Integer> set = iter.next().getValue();
            result.addAll(set);
            k -= set.size();
        }
        return result;
    }

    public static void main(String args[]) {
        TopKFrequentElements t = new TopKFrequentElements();
        for (int f : t.topKFrequent(new int[]{1, 2}, 2))
            System.out.println(f);
    }
}
