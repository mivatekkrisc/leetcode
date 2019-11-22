package leecode;

public class RangeSumQuery2D {

    int[][] matrix;

    public RangeSumQuery2D(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int sum = 0;
        for(int i = row1; i <= row2; i++)
            for(int j = col1; j <= col2; j++)
                sum += matrix[i][j];
        return sum;
    }

}
