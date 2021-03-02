package 回溯;

import java.util.ArrayList;
import java.util.List;

/*
* n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 

示例 1：


输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。

* */
public class N皇后 {

    private static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> stringBuilder = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                stringBuilder.add(".");
            }
            board.add(stringBuilder);
        }
        backtrack(0, board);
        return res;
    }

    public static void backtrack(int row, List<List<String>> board) {
        if (row == board.size()) {
            List<String> flag = new ArrayList<>();
            for (List<String> b : board) {
                String s = null;
                for (String ss : b) {
                    s = s == null ? ss : s + ss;
                }
                flag.add(s);
            }
            res.add(flag);
            return;
        }
        for (int i = 0; i < board.size(); i++) {
            if (isValid(board, row, i)) {
                continue;
            }
            board.get(row).set(i, "Q");
            backtrack(row + 1, board);
            board.get(row).set(i, ".");
        }
    }

    public static boolean isValid(List<List<String>> board, int row, int i) {
        // 检查列
        for (int x = row - 1; x >= 0; x--) {
            if ("Q".equals(board.get(x).get(i))) {
                return true;
            }
        }
        // 检查左上方
        for (int a = row - 1, b = i - 1; a >= 0 && b >= 0; a--, b--) {
            if ("Q".equals(board.get(a).get(b))) {
                return true;
            }
        }
        // 检查右上方
        for (int a = row - 1, b = i + 1; a >= 0 && b < board.size(); a--, b++) {
            if ("Q".equals(board.get(a).get(b))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(N皇后.solveNQueens(4).toString());
    }

}
