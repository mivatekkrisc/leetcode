package leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class LargestNumber {

    public String largestNumber(int[] nums) {

        String[] arr = Arrays.stream(nums).mapToObj(i -> String.valueOf(i)).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o2.contains(o1) || o1.contains(o2)) {
                    return (o2 + o1).compareTo(o1 + o2);
                }

                return -1 * o1.compareTo(o2);
            }
        }).toArray(String[]::new);

        StringBuilder sb = new StringBuilder();

        boolean leadingZero = true;
        for (String str : arr) {
            if(!str.equals("0") || !leadingZero)
                sb.append(str);
            if(!str.equals("0"))
                leadingZero = false;
        }
        if(sb.toString().isEmpty())
            sb.append("0");
        return sb.toString();
    }

    public static void main(String args[]) {
        LargestNumber l = new LargestNumber();
//        l.largestNumber(new int[]{10, 2});
        System.out.println(l.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(l.largestNumber(new int[]{12, 121}));
        System.out.println(l.largestNumber(new int[]{0, 0}));
    }
}
