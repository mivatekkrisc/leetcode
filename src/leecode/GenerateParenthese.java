package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateParenthese {

    public List<String> generateParenthesis(int n) {
        if (n == 0) return Collections.emptyList();

        List<String> l1 = new ArrayList<>();
        l1.add("()");
        if (n == 1) return l1;

        for (int i = 2; i <= n; ++i) {
            l1 = gen(i, l1);
        }
        return l1;
    }

    public List<String> gen(int n, List<String> list) {

        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add("(" + list.get(i) + ")");
            if(i == list.size() - 1)
                result.add(list.get(i)+"()");
            else {
                result.add(list.get(i)+"()");
                result.add("()"+list.get(i));
            }

        }
        return result;
    }

    public static void main(String args[]) {
        GenerateParenthese g = new GenerateParenthese();
        for (String s : g.generateParenthesis(4))
            System.out.println(s);
    }
}
