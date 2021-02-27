package com.luna.algorithm.array;
//37. 解数独
//        编写一个程序，通过填充空格来解决数独问题。
//
//        一个数独的解法需遵循如下规则：
//
//        数字 1-9 在每一行只能出现一次。
//        数字 1-9 在每一列只能出现一次。
//        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//        空白格用 '.' 表示。
//
//
//
//        一个数独。
//
//
//
//        答案被标成红色。
//
//        提示：
//
//        给定的数独序列只包含数字 1-9 和字符 '.' 。
//        你可以假设给定的数独只有唯一解。
//        给定数独永远是 9x9 形式的。

import java.util.ArrayList;
import java.util.List;

//直接放弃,想不明白,贴上官方题解
public class SolveSudoku {
//    方法一：递归
//            思路
//
//    最容易想到的方法是用一个数组记录每个数字是否出现。
//    由于我们可以填写的数字范围为 [1, 9][1,9]，而数组的下标从 00 开始，因此在存储时，我们使用一个长度为 99 的布尔类型的数组，
//    其中 i 个元素的值为 True，当且仅当数字 i+1 出现过。例如我们用 line[2][3]=True 表示数字 44 在第 22 行已经出现过，
//    那么当我们在遍历到第 22 行的空白格时，就不能填入数字 44。
//
//    算法
//
//    我们首先对整个数独数组进行遍历，当我们遍历到第 i 行第 j 列的位置：
//
//    如果该位置是一个空白格，那么我们将其加入一个用来存储空白格位置的列表中，方便后续的递归操作；
//
//    如果该位置是一个数字 x，那么我们需要将 line[i][x−1]，column[j][x−1] 以及 block[⌊i/3⌋][⌊j/3⌋][x−1] 均置为 True。
//
//    当我们结束了遍历过程之后，就可以开始递归枚举。当递归到第 i 行第 j 列的位置时，我们枚举填入的数字 x。
//    根据题目的要求，数字 x 不能和当前行、列、九宫格中已经填入的数字相同，因此 line[i][x−1]，column[j][x−1] 以及 block[⌊i/3⌋][⌊j/3⌋][x−1] 必须均为 False。
//
//    当我们填入了数字 x 之后，我们要将上述的三个值都置为 True，并且继续对下一个空白格位置进行递归。在回溯到当前递归层时，我们还要将上述的三个值重新置为 False。

    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}
