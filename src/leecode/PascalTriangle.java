package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>(numRows);

        int row = 1;
        while (row <= numRows) {
            List<Integer> data = new ArrayList(row);
            for (int i = 0; i < row; i++) {
                if (i == 0 || i == row - 1)
                    data.add(1);
                else {
                    List<Integer> preRow = result.get(row - 2);
                    int sum = preRow.get(i - 1) + preRow.get(i);
                    data.add(sum);
                }
            }
            result.add(data);
            row++;
        }
        return result;
    }

    public static void main(String args[]) {
        PascalTriangle p = new PascalTriangle();
        List result = p.generate(1);
        result = p.generate(2);
        for (List<Integer> l : p.generate(1))
            System.out.println(l.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
    }
}
