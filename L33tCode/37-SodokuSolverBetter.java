class Solution {

    private int SIZE = 9;

    private boolean[][] rowFlag;
    private boolean[][] colFlag;
    private boolean[][] groupFlag;

    public void solveSudoku(char[][] board) {
        rowFlag = new boolean[SIZE][9];
        colFlag = new boolean[9][9];
        groupFlag = new boolean[9][9];
    }
}