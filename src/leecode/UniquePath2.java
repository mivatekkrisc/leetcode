package leecode;

public class UniquePath2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[row-1][column-1] == 1) return 0;

        int[][] count = new int[row][column];
        count[0][0] = 1;

        for(int i = 0 ; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(i > 0 || j > 0) {
                    int upValue = i - 1 < 0 || obstacleGrid[i - 1][j] == 1 ? 0 : count[i - 1][j];
                    int leftValue = j - 1 < 0 || obstacleGrid[i][j - 1] == 1 ? 0 : count[i][j - 1];

                    count[i][j] = upValue + leftValue;
                }
            }
        }
        return count[row-1][column-1];

    }

    public static void main(String args[]) {
        int[][] obs = new int[3][3];
        obs[1][1] = 1;

        UniquePath2 u = new UniquePath2();
        System.out.println(u.uniquePathsWithObstacles(obs));
    }
}
