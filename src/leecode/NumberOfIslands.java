package leecode;

public class NumberOfIslands {

    int result = 0;

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int[][] visited = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++)
                dfs(grid, visited, i, j, false);
        }

        return result;
    }

    public void dfs(char[][] grid, int[][] visited, int row, int col, boolean newIsland) {

        if (visited[row][col] == 1) return;
        int r = grid.length, c = grid[0].length;

        visited[row][col] = 1;
        if (grid[row][col] == '1') {
            if (col + 1 < c)
                dfs(grid, visited, row, col + 1, true);
            if (row + 1 < r)
                dfs(grid, visited, row + 1, col, true);
            if (row - 1 >= 0)
                dfs(grid, visited, row - 1, col, true);
            if (col - 1 >= 0)
                dfs(grid, visited, row, col - 1, true);

            if (!newIsland) {
//                System.out.println(String.format("row %d col %d", row, col));
                result++;
            }
        }
    }

    public static void main(String args[]) {
        char[][] input = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};

        NumberOfIslands n = new NumberOfIslands();
        System.out.println(n.numIslands(input));


        n.result = 0;
        input = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(n.numIslands(input));
    }
}
