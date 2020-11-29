package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int diagonal = 0; diagonal < board.length; diagonal++) {
            if (board[diagonal][diagonal] == 1 && board[diagonal + 1][diagonal] == 1) { // проверка вертикальной правильности
                for (int row = 0; row < board.length; row++) {
                    if (board[row][diagonal] == 1) {
                        rsl = true;
                    } else {
                        rsl = false;
                        break;
                    }
                }
            }
            if ((board[diagonal][diagonal] == 1 && board[diagonal][diagonal + 1] == 1)) { // проверка горизонтальной правильности
            for (int cell = 0; cell < board.length; cell++) {
                if (board[diagonal][cell] == 1) {
                    rsl = true;
                } else {
                    rsl = false;
                    break;
                }
            }
        }
    }
        return rsl;
    }
}
