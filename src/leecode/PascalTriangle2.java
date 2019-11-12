package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++)
            result.add(0);

        result.set(0, 1);

        for (int i = 1; i <= rowIndex; i++) {

            for (int j = i; j >= 1; j--) {
                int sum = result.get(j) + result.get(j - 1);
                result.set(j, sum);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        List<Integer> result = new PascalTriangle2().getRow(4);
        System.out.println(result.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));

//        result = new PascalTriangle2().getRow(5);
//        System.out.println(result.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
    }
}
