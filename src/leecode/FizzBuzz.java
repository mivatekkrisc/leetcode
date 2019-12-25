package leecode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String tmp = "";
            if (i % 15 == 0)
                tmp = "FizzBuzz";
            else if (i % 3 == 0)
                tmp = "Fizz";
            else if (i % 5 == 0)
                tmp = "Buzz";
            else
                tmp += i;


            result.add(tmp);
        }
        return result;

    }

    public static void main(String args[]) {
        for (String str : new FizzBuzz().fizzBuzz(15))
            System.out.println(str);
    }
}
