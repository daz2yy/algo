
/**
 * 简单逻辑题，30分钟，https://leetcode-cn.com/problems/valid-sudoku/
 * 总结：
 * 1. 基础计算过关即可
 * 改进：
 *      一次遍历完成所有判断
 *      Trick：方格的顺序性与数组的顺序性重叠
 */
public class IsValidSudo_36 {
    
    public boolean checkRow(char[][] board, int i, int j) {
        for (int index = 0; index < board[i].length; ++index) {
            if (index != j && board[i][index] == board[i][j]) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkColunm(char[][] board, int i, int j) {
        for (int index = 0; index < board.length; ++index) {
            if (index != i && board[index][j] == board[i][j]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkNight(char[][] board, int i, int j) {
        int minRow = i/3*3, minCol = j/3*3;
        int maxRow = (i/3+1)*3 - 1, maxCol = (j/3+1)*3 - 1;
        for (int m = minRow; m <= maxRow; ++m) {
            for (int n = minCol; n <= maxCol; ++n) {
                if (m != i && n != j && board[m][n] == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] != '.' &&
                    (!checkRow(board, i, j) || 
                    !checkColunm(board, i, j) ||
                    !checkNight(board, i, j))
                ) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("ans: " + new IsValidSudo_36().isValidSudoku(board1));
    }
}
