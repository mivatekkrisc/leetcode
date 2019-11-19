package leecode;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length, col = matrix[0].length;

        int lo = 0, hi = row - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] > target)
                hi = mid - 1;
            else lo = mid + 1;
        }

        int targetRow = matrix[lo][0] > target && lo - 1 >= 0 ? lo - 1 : lo;
        lo = 0;
        hi = col - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (matrix[targetRow][mid] == target)
                return true;
            else if (matrix[targetRow][mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }

    public static void main(String args[]) {
        int[][] input = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        Search2DMatrix s = new Search2DMatrix();
        System.out.println(s.searchMatrix(input, 3));
        System.out.println(s.searchMatrix(input, 13));
        System.out.println(s.searchMatrix(input, 11));

        input = new int[][]{{1}};
        System.out.println(s.searchMatrix(input, 1));


    }
}
