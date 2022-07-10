package com.mdekhtiarenko;

import com.mdekhtiarenko.models.Board;

public record GameOfLife(Board initialBoard) {

    public void play(int generationsAmount) {
        Board board = initialBoard;
        System.out.println("Game started! Initial board: ");
        System.out.println(board.toString());

        for (int i = 0; i < generationsAmount; i++) {
            board = nextGeneration(board);
            System.out.println("Generation #" + (i + 1));
            System.out.println(board.toString());
        }
    }

    public Board nextGeneration(Board currentGeneration) {
        Board nextGeneration = new Board(currentGeneration.getDimensions());

        for (int x = 0; x < currentGeneration.getDimensions(); x++) {
            for (int y = 0; y < currentGeneration.getDimensions(); y++) {
                long neighboursAmount = currentGeneration.getAliveNeighboursAmount(x, y);
                boolean isAliveInCurrentGeneration = currentGeneration.getCellValue(x, y);
                nextGeneration.setCellValue(x, y, willBeAbleToLiveInNextGeneration(isAliveInCurrentGeneration, neighboursAmount));
            }
        }

        return nextGeneration;
    }

    private boolean willBeAbleToLiveInNextGeneration(boolean isAliveInCurrentGeneration, long numberOfNeighboursInCurrentGeneration) {
        return (isAliveInCurrentGeneration && numberOfNeighboursInCurrentGeneration == 2) || numberOfNeighboursInCurrentGeneration == 3;
    }
}
