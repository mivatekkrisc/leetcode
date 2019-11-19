package leecode;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int[][] min = new int[grid.length][grid[0].length];
        min[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) min[i][0] = min[i - 1][0] + grid[i][0];
        for (int i = 1; i < grid[0].length; i++) min[0][i] = min[0][i - 1] + grid[0][i];

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                int value = Math.min(min[i - 1][j], min[i][j - 1]);
                min[i][j] = value + grid[i][j];
            }
        }

        return min[grid.length - 1][grid[0].length - 1];

    }

    public static void main(String args[]) {
        int[][] input = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new MinPathSum().minPathSum(input));
    }
}
