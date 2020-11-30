package ru.job4j.puzzle;

public class Win {
    public static boolean monoVertical(int[][] board) {
        boolean rsl = true;
        for (int diagonal = 0; diagonal < board.length; diagonal++) {
            if (board[diagonal][diagonal] == 1) {
                for (int row = 0; row < board.length; row++) {
                    if (board[row][diagonal] != 1) {
                        rsl = false;
                        break;
                    }
                }
            }
        }
        return rsl;
    }

    public static boolean monoHorizontal(int[][] board) {
        boolean rsl = true;
        for (int diagonal = 0; diagonal < board.length; diagonal++) {
            if (board[diagonal][diagonal] == 1) {
                for (int cell = 0; cell < board.length; cell++) {
                    if (board[diagonal][cell] != 1) {
                        rsl = false;
                        break;
                    }
                }
            }
        }
        return rsl;
    }

    public static boolean check(int[][] board) {
        boolean rsl = false;
        if ((monoHorizontal(board)) || monoVertical(board)) {
            rsl = true;
        }
        return rsl;
    }
}