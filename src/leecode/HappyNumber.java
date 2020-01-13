package leecode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {

        Set<Integer> numbers = new HashSet<>();

        int count = 1;
        int result = 0;
        while (n > 0) {
            int remain = n % 10;
            result += remain * remain;
            n = n / 10;
            if (n < 10) {
                result += n * n;
                if (result == 1)
                    return true;
                if (numbers.contains(result))
                    return false;
                else
                    numbers.add(result);
                n = result;
                result = 0;
            }

        }

        return false;
    }

    public static void main(String args[]) {

        HappyNumber h = new HappyNumber();
        System.out.println(h.isHappy(19));
        System.out.println(h.isHappy(1));

    }
}
