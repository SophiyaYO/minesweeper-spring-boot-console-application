package com.minesweeper.demo.repositories;

import com.minesweeper.demo.model.Cell;
import com.minesweeper.demo.model.MaskedCell;

public interface BoardRepository {
    int getRolls();

    Cell[][] getBoard();

    class GameBoard implements BoardRepository {
        private final int level;
        private int rolls;
        private int mines;
        private int movesLeft;
        private final Cell[][] board;

        public GameBoard(int numberLevel) {
            this.level = numberLevel;
            setRolls();
            setMines();
            setMovesLeft();
            this.board = new Cell[getRolls()][getRolls()];
        }

        public void setBoard() {
            for (int y = 0; y < getRolls(); y++) {
                for (int x = 0; x < getRolls(); x++) {
                    this.board[y][x] = new MaskedCell(y, x);
                }
            }
        }

        public void setRolls() {
            switch (getLevel()) {
                case 0:
                    this.rolls = 9;
                    break;
                case 1:
                    this.rolls = 16;
                    break;
                case 2:
                    this.rolls = 24;
                    break;
            }
        }

        private void setMines() {
            switch (getLevel()) {
                case 0:
                    this.mines = 10;
                    break;
                case 1:
                    this.mines = 216;
                    break;
                case 2:
                    this.mines = 477;
                    break;
            }
        }

        private void setMovesLeft() {
            switch (getLevel()) {
                case 0:
                    this.movesLeft = 71;
                    break;
                case 1:
                    this.movesLeft = 40;
                    break;
                case 2:
                    this.movesLeft = 99;
                    break;
            }
        }

        public Cell[][] getBoard() {
            return this.board;
        }

        private int getLevel() {
            return this.level;
        }

        public int getMines() {
            return this.mines;
        }

        public int getRolls() {
            return this.rolls;
        }

        public int decreaseMoves() {
            this.movesLeft = this.movesLeft - 1;
            return this.movesLeft;
        }

        public int getMovesLeft() {
            return this.movesLeft;
        }
    }

}
