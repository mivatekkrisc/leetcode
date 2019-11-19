package leecode;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];
        int count = 1;
        int left = 0, right = n - 1, up = 1, down = n - 1;
        int direction = 0;
        int i = 0, j = 0;

        while (count <= n * n) {

            if (direction % 4 == 0) { //right

                if (j == right + 1) {
                    j--;
                    direction++;
                    i++;
                    right--;
                } else {
                    result[i][j] = count++;
                    j++;
                }
            } else if (direction % 4 == 1) { //down
                if (i == down + 1) {
                    i--;
                    direction++;
                    j--;
                    down--;
                } else {
                    result[i][j] = count++;
                    i++;
                }
            } else if (direction % 4 == 2) { //left
                if (j == left - 1) {
                    j++;
                    direction++;
                    i--;
                    left++;
                } else {
                    result[i][j] = count++;
                    j--;
                }

            } else { //up
                if (i == up - 1) {
                    i++;
                    direction++;
                    j++;
                    up++;
                } else {
                    result[i][j] = count++;
                    i--;
                }

            }

        }
        return result;
    }

    public static void main(String args[]) {
        int[][] result = new SpiralMatrix2().generateMatrix(3);
        System.out.println(result);

        result = new SpiralMatrix2().generateMatrix(1);
        System.out.println(result);

        result = new SpiralMatrix2().generateMatrix(4);
        System.out.println(result);
    }
}
