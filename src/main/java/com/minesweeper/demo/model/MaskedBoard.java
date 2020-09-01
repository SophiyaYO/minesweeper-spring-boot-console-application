package com.minesweeper.demo.model;

import com.minesweeper.demo.repositories.BoardRepository;

public class MaskedBoard extends BoardRepository.GameBoard {

    public MaskedBoard(int numberLevel) {
        super(numberLevel);
        setBoard();
    }

    public Cell[][] getBoard() {
        return super.getBoard();
    }

    public void updateStatusToMines(int r, int c) {
        super.getBoard()[r][c] = new MineCell(r, c);
    }

    public void updateStatusToEmpty(int row, int col) {
        super.getBoard()[row][col] = new EmptyCell(row, col);
    }

}
