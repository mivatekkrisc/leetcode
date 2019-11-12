package leecode;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        if (digits.length == 0) return digits;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0) return digits;

            int sum = carry + digits[i];
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry == 0) return digits;
        else {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }

    }

    public static void main(String args[]) {
        PlusOne p = new PlusOne();

        int[] output = p.plusOne(new int[]{1, 2, 3});
        output = p.plusOne(new int[]{4, 3, 2, 1});
        output = p.plusOne(new int[]{9});
        output = p.plusOne(new int[]{8,9,9,9});
        output = p.plusOne(new int[]{9,9,9,9});
        Arrays.stream(output).forEach(System.out::println);
    }
}
