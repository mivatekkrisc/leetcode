package leecode;

public class UniquePath {

    public int uniquePaths(int column, int row) {

        int[][] count = new int[row][column];
        for(int i = 0 ; i < row; i++)
            count[i][0] = 1;
        for(int i = 0 ; i < column; i++)
            count[0][i] = 1;

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < column; j++)
                count[i][j] = count[i][j-1] + count[i-1][j];
        }
        return count[row-1][column-1];


    }

    public int uniquePath(int row, int column) {
        if(row == 1) return 1;
        if(column == 1) return 1;

        return uniquePath(row-1, column) + uniquePath(row, column-1);
    }

    public static  void main(String args[]) {
        System.out.println(new UniquePath().uniquePaths(3,2));
    }
}
