package io.github.chinalhr.leetcode.backtracking;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

/**
 * @Author lhr
 * @Date 2020/10/7
 * @Description: 题目：79. 单词搜索 medium
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例：
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * 回溯法实现：
 * 1. 抽象决策树
 * *
 * / | \ \
 * A  B  C ...
 * /
 * B ...
 * 2. 确定路径：select记录已经选择的路径,word为我们需要的路径
 * 3. 确定选择列表：当前选择点的上下左右并且没有走过,并且为word的第一个字符则选择，选择后删除word的
 * 第一个字符
 * 4. 确定结束条件：word == 空字符的时候
 */
public class WordSearch {

    private boolean result = false;


    public boolean exist(char[][] board, String word) {

        //特殊情况判断
        if(board.length == 1 && board[0].length == 1&&word.length() ==1 ){
            if (board[0][0] == word.charAt(0) ) return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] select = new boolean[board.length][board[0].length];
                backTrack(board, select,word, i, j);
            }
        }

        return result;
    }

    private void backTrack(char[][] board,boolean[][] select, String word, int row, int col) {
        if (result){
            return;
        }

        int maxRow = board.length;
        int maxCol = board[0].length;
        if (word.equals("")){
            result = true;
            return;
        }

        //上下左右走一遍
        for (int i = 1; i <= 4; i++) {
            int currentRow = row;
            int currentCol = col;
            //上边单位
            if (i==1){
                currentRow = row -1;
                currentCol = col;
            }
            //下边单位
            if (i==2){
                currentRow = row +1;
                currentCol = col;
            }
            //左边单位
            if (i==3){
                currentRow = row;
                currentCol = col-1;
            }

            //右边单位
            if (i==4){
                currentRow = row;
                currentCol = col+1;
            }

            //排除不合理选择
            if (currentRow < 0 || currentCol< 0 ) continue;
            if (currentRow >= maxRow || currentCol >= maxCol) continue;
            if (select[currentRow][currentCol]) continue;
            //做选择
            char targetChar = word.charAt(0);
            if (board[currentRow][currentCol]==targetChar){
                select[currentRow][currentCol] = true;
                //进入下一层决策树
                backTrack(board,select,word.substring(1),currentRow,currentCol);
            }
            // 取消选择
            select[currentRow][currentCol] = false;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}
                         ,{'S','F','E','S'},
                          {'A','D','E','E'}};
        WordSearch wordSearch = new WordSearch();
        boolean exist = wordSearch.exist(board, "ABCESEEEFS");
        System.out.println(exist);
    }
}
