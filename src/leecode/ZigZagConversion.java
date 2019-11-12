package leecode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public String zigzag(String s, int numOfRows) {

        List<StringBuilder> rows = new ArrayList();
        for(int i = 0 ; i < Math.max(s.length(), numOfRows); i++)
            rows.add(new StringBuilder());

        boolean goingDown = false;
        int index = 0;
        for(int i = 0 ; i < s.length(); i++) {

            StringBuilder b = rows.get(index);
            b.append(s.charAt(i));

            if(index == 0 || index == numOfRows-1)
                goingDown = !goingDown;
            index += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder b : rows)
            result.append(b.toString());

        return result.toString();
    }

    public static void main(String args[]) {
        ZigZagConversion c = new ZigZagConversion();
        System.out.println(c.zigzag("PAYPALISHIRING", 3));
    }
}
