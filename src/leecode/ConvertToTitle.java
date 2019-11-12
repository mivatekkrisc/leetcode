package leecode;

import java.util.ArrayList;
import java.util.List;

public class ConvertToTitle {

    public String convertToTitle(int n) {

        List<Integer> tmp = new ArrayList<>();

        while(n > 26) {
            int remain = n % 26;
            if(remain == 0) {
                n = n / 26 - 1;
                remain = 26;
            } else {
                n = n / 26;
            }
            tmp.add(remain);
        }
        tmp.add(n);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tmp.size(); i++) {
            int val = tmp.get(i);
            sb.insert(0, (char)(val-1+'A'));
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        ConvertToTitle c = new ConvertToTitle();
        System.out.println(c.convertToTitle(1));
        System.out.println(c.convertToTitle(28));
        System.out.println(c.convertToTitle(701));
        System.out.println(c.convertToTitle(52));
        System.out.println(c.convertToTitle(703));
    }

}
