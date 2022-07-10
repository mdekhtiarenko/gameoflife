package com.mdekhtiarenko;

import com.mdekhtiarenko.models.Board;

public class Main {

    public static void main(String[] args) {

        Board initialBoard = initializeBoardWithGliderPattern();

        GameOfLife game = new GameOfLife(initialBoard);

        game.play(5);
    }

    private static Board initializeBoardWithGliderPattern() {
        Board initialBoard = new Board(25);
        initialBoard.setCellValue(13, 12, true);

        initialBoard.setCellValue(14, 13, true);

        initialBoard.setCellValue(12, 14, true);
        initialBoard.setCellValue(13, 14, true);
        initialBoard.setCellValue(14, 14, true);
        return initialBoard;
    }
}
