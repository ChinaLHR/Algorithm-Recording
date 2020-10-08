package io.github.chinalhr.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lhr
 * @Date 2020/10/7
 * @Description: 题目：51. N 皇后 hard
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 输入：4
 * 输出：[
 * [".Q..",
 * "...Q",
 * "Q...",
 * "..Q."]
 * <p>
 * 实现：
 * 1. 抽象决策树
 *            *
 *       /    |... \
 * row0 col0 col1  colN
 * row1 ...
 * rowN ...
 * 2. 确定路径： track中小于 row 的那些行都已经成功放置了皇后
 * 3. 确定选择列表：第 n row 的所有 col 列都是放置皇后的选择
 * 4. 确定结束条件：row超过track最后一行，即放置完了最后一个皇后了
 */
public class NQueens {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        /**
         * 构建初始的棋盘，棋盘所有col铺满 .
         */
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(".");
        }
        ArrayList<String> track = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            track.add(stringBuilder.toString());
        }

        //回溯所有情况
        backtrack(track,0);
        return result;
    }

    private void backtrack(List<String> track, int row) {
        //触发结束条件 row行数超过了track的最后一行，视为已找到正解，添加到result中
        if (row == track.size()) {
            ArrayList<String> copyTrack = new ArrayList<>(track);
            result.add(copyTrack);
            return;
        }


        int n = track.get(row).length();
        // 决策树决策
        // 选择列表：当前row的所有col
        // 剪枝：通过isValid方法检查冲突，进行剪枝
        for (int col = 0; col < n; col++) {

            // 排除不合法选择
            if (!isValid(track, row, col))
                continue;

            // 做选择
            StringBuilder sb = new StringBuilder(track.get(row));
            sb.replace(col, col + 1, "Q");
            track.set(row, sb.toString());

            // 进入下一行决策
            backtrack(track, row + 1);

            // 撤销选择
            sb.replace(col, col + 1, ".");
            track.set(row, sb.toString());
        }

    }


    private boolean isValid(List<String> track, int row, int col) {
        int n = track.size();
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (track.get(i).charAt(col) == 'Q') return false;
        }

        //检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (track.get(i).charAt(j) == 'Q') return false;
        }
        //检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (track.get(i).charAt(j) == 'Q') return false;

        }
        return true;
    }

}
