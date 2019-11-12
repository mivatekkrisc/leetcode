package leecode;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        if (word == null || word.length() == 0) return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (traverse(board, i, j, word, 0, visited)) return true;
            }
        }
        return false;
    }

    public boolean traverse(char[][] board, int i, int j, String word, int index, boolean[][] visited) {

//        System.out.println(board[i][j]+" "+word.charAt(index)+" "+index+" i:"+i+" j:"+j);
        visited[i][j] = true;
        int row = board.length, column = board[0].length;
        if (board[i][j] != word.charAt(index)) {
            visited[i][j] = false;
            return false;
        }
        if (index == word.length() - 1 && board[i][j] == word.charAt(index)) return true;

        if (i - 1 >= 0 && !visited[i-1][j] && traverse(board, i - 1, j, word, index + 1, visited)) return true;
        if (i + 1 <= row - 1 && !visited[i+1][j] && traverse(board, i + 1, j, word, index + 1, visited)) return true ;
        if (j - 1 >= 0 && !visited[i][j-1] && traverse(board, i, j - 1, word, index + 1, visited)) return true;
        if (j + 1 <= column - 1 && !visited[i][j+1] && traverse(board, i, j + 1, word, index+1, visited)) return true;

        visited[i][j] = false;
        return false;
    }

    public static void main(String args[]) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        WordSearch w = new WordSearch();
        System.out.println(w.exist(board, "AB"));
        System.out.println(w.exist(board, "ABCCED"));
        System.out.println(w.exist(board, "SEE"));
        System.out.println(w.exist(board, "ABCB"));

        board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        System.out.println(w.exist(board, "cdba"));
    }
}
