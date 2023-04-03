import java.util.ArrayList;
import java.util.List;

class Solution {

    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][] subboxes = new boolean[9][10];

    public void solveSudoku( char[][] board) {
        int row = board.length, col = board[0].length;
        List<Integer> empty = new ArrayList<>();
        for( int i= 0; i < row; i++ ) {
            for( int j = 0; j < col; j++ ) {
                char c = board[i][j];
                if( c >= '1' && c <= '9' ) {
                    int idx = c -'0';
                    rows[i][idx] = true;
                    cols[j][idx] = true;
                    subboxes[mapping(i, j)][idx] = true;
                } else if( c == '.' ) {
                    empty.add(i * 9 + j);
                }
            }
        }

        dfs(board, empty, 0);
    }

    private boolean dfs( char[][] board, List<Integer> empty, int idx ) {
        if( idx == empty.size() ) {
            return true;
        }

        int pos = empty.get(idx);
        int row = pos / 9, col = pos % 9;
        for( int i = 1; i <= 9; i++ ) {
            if( !rows[row][i] && !cols[col][i] && !subboxes[mapping(row, col)][i] ) {
                rows[row][i] = true;
                cols[col][i] = true;
                subboxes[mapping(row, col)][i] = true;
                board[row][col] = (char) (i + '0');
                if( dfs(board, empty, idx + 1) ) {
                    return true;
                }
                rows[row][i] = false;
                cols[col][i] = false;
                subboxes[mapping(row, col)][i] = false;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private int mapping(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }
}