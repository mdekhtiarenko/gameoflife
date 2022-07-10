package com.mdekhtiarenko.models;

import java.util.List;

public class Board {
    private final int dimensions;
    private final boolean[][] board;

    public Board(int dimensions) {
        this.dimensions = dimensions;
        this.board = new boolean[dimensions][dimensions];
    }

    public long getAliveNeighboursAmount(int x, int y) {
        validateThatCellInsideOfTheFieldBoundaries(x, y);

        return getNeighbourCells(x, y)
                .stream()
                .filter(this::isAliveCell)
                .count();
    }

    public boolean isAliveCell(Cell cell) {
        if (isOutsideOfFieldBoundaries(cell.x(), cell.y())) {
            return false;
        }
        return board[cell.x()][cell.y()];
    }

    public void setCellValue(int x, int y, boolean alive) {
        validateThatCellInsideOfTheFieldBoundaries(x, y);
        board[x][y] = alive;
    }

    public boolean getCellValue(int x, int y) {
        validateThatCellInsideOfTheFieldBoundaries(x, y);
        return board[x][y];
    }

    public int getDimensions() {
        return dimensions;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x < dimensions; x++) {
            for (int y = 0; y < dimensions; y++) {
                stringBuilder.append(board[y][x] ? "0" : "_");
                stringBuilder.append("  ");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private List<Cell> getNeighbourCells(int x, int y) {
        return List.of(
                // top row
                new Cell(x - 1, y - 1),
                new Cell(x, y - 1),
                new Cell(x + 1, y - 1),
                // middle/cell's row
                new Cell(x - 1, y),
                new Cell(x + 1, y),
                // bottom row
                new Cell(x - 1, y + 1),
                new Cell(x, y + 1),
                new Cell(x + 1, y + 1)
        );
    }

    private void validateThatCellInsideOfTheFieldBoundaries(int x, int y) {
        if (isOutsideOfFieldBoundaries(x, y)) {
            throw new IllegalArgumentException("Given point is outside the board.");
        }
    }

    private boolean isOutsideOfFieldBoundaries(int x, int y) {
        return x < 0 || x >= dimensions || y < 0 || y >= dimensions;
    }
}
