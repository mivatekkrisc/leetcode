package leecode;

import java.util.ArrayList;
import java.util.List;

public class MultiplyString {

    public String multiply(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        int[] vals = new int[num1.length() + num2.length()];

        for(int i = num1.length() - 1; i >=0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int mul = n1 * n2;
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + vals[p2];

                vals[p2] = sum % 10;
                vals[p1] += sum / 10;

            }
        }

        boolean startPrint = false;
        for(int i = 0; i < vals.length; i++) {
            if(!startPrint && vals[i] > 0)
                startPrint = true;

            if(startPrint)
                sb.append(vals[i]);
        }
        String result = sb.toString();
        if(result.isEmpty())
            return "0";
        else
            return result;
    }

    public static void main(String args[]) {
        MultiplyString m = new MultiplyString();
//        System.out.println(m.multiply("2", "3"));
        System.out.println(m.multiply("123", "456"));
        System.out.println(m.multiply("0", "0"));
    }
}
