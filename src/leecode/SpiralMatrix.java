package leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        int direction = 0, col = 0, row = 0;
        int rowCount = matrix.length, colCount = matrix[0].length;
        int right = colCount - 1, left = 0, up = 1, down = rowCount - 1;

        while (result.size() < rowCount * colCount) {
            if (direction % 4 == 0) {
                while (col <= right) {
                    result.add(matrix[row][col]);
                    col++;
                }
                direction++;
                right--;
                col--;
                row++;
            } else if (direction % 4 == 1) {
                while (row <= down) {
                    result.add(matrix[row][col]);
                    row++;
                }
                direction++;
                down--;
                row--;
                col--;
            } else if (direction % 4 == 2) {
                while (col >= left) {
                    result.add(matrix[row][col]);
                    col--;
                }
                direction++;
                left++;
                col++;
                row--;
            } else if (direction % 4 == 3) {
                while (row >= up) {
                    result.add(matrix[row][col]);
                    row--;
                }
                direction++;
                up++;
                row++;
                col++;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        SpiralMatrix s = new SpiralMatrix();
        int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(s.spiralOrder(input).stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));

        input = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(s.spiralOrder(input).stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));

        input = new int[][]{{1}};
        System.out.println(s.spiralOrder(input).stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));


    }
}
