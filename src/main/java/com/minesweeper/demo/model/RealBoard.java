package com.minesweeper.demo.model;

import com.minesweeper.demo.repositories.BoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RealBoard extends BoardRepository.GameBoard {
    private final List<int[]> mineLocations;
    private final List<Cell> recursionEmptyCellsCollection;
    private int movesLeft;

    public RealBoard(int numberLevel) {
        super(numberLevel);
        setBoard();
        this.mineLocations = new ArrayList<>();
        this.recursionEmptyCellsCollection = new ArrayList<>();
    }

    public Cell[][] getBoard() {
        return super.getBoard();
    }

    public boolean getCellStatus(int r, int c) {
        return this.getBoard()[r][c].getIsMine();
    }

    public List<int[]> getMineLocations() {
        return this.mineLocations;
    }

    @Override
    public int getMovesLeft() {
        return super.getMovesLeft();
    }

    public List<Cell> getRecursionEmptyCellsCollection() {
        return this.recursionEmptyCellsCollection;
    }

    public void setGameBoardMines(int colX, int rolY) {
        int counter = super.getMines();
        Random random = new Random();

        while (counter > 0) {
            int row = random.nextInt(super.getRolls());
            int col = random.nextInt(super.getRolls());

            if (isValidCell(row, col)) {
                if (row == rolY && col == colX) {
                    boolean continueRand = true;
                    while (continueRand) {
                        row = random.nextInt(super.getRolls());
                        col = random.nextInt(super.getRolls());
                        if (isValidCell(row, col)) {
                            if ((row != rolY || col != colX)) {
                                continueRand = false;
                            }
                        }
                    }
                }

                if (!getCellStatus(row, col)) {
                    this.getBoard()[row][col] = new MineCell(row, col);
                    mineLocations.add(new int[]{row, col});
                    counter--;
                }
            }
        }

        calculateAndSetOnPositionDigitCells();
    }

    private void calculateAndSetOnPositionDigitCells() {
        for (int[] mine : this.getMineLocations()) {

            if (isValidCell(mine[0], mine[1] - 1)) {
                this.updateTypeCell(mine[0], mine[1] - 1);
            }
            if (isValidCell(mine[0], mine[1] + 1)) {
                this.updateTypeCell(mine[0], mine[1] + 1);
            }
            if (isValidCell(mine[0] + 1, mine[1] + 1)) {
                this.updateTypeCell(mine[0] + 1, mine[1] + 1);
            }
            if (isValidCell(mine[0] + 1, mine[1] - 1)) {
                this.updateTypeCell(mine[0] + 1, mine[1] - 1);
            }
            if (isValidCell(mine[0] - 1, mine[1] + 1)) {
                this.updateTypeCell(mine[0] - 1, mine[1] + 1);
            }
            if (isValidCell(mine[0] - 1, mine[1] - 1)) {
                this.updateTypeCell(mine[0] - 1, mine[1] - 1);
            }
            if (isValidCell(mine[0] - 1, mine[1])) {
                this.updateTypeCell(mine[0] - 1, mine[1]);
            }
            if (isValidCell(mine[0] + 1, mine[1])) {
                this.updateTypeCell(mine[0] + 1, mine[1]);
            }
        }
    }

    private boolean isValidCell(int row, int col) {
        return (
                (row >= 0 && row < super.getRolls())
                        && (col >= 0 && col < super.getRolls()));
    }

    public void recursionEmptyCells(int r, int c) {
        if (isValidCell(r, c)) {

            if (isValidCell(r, c - 1)) {
                if (this.getBoard()[r][c - 1] instanceof EmptyCell || (this.getBoard()[r][c - 1] instanceof MaskedCell)) {

                    if (!this.getRecursionEmptyCellsCollection().contains(this.getBoard()[r][c - 1])) {
                        this.setToEmptyCell(r, c - 1);
                        this.recursionEmptyCellsCollection.add(this.getBoard()[r][c - 1]);
                        this.movesLeft=this.decreaseMoves();
                        recursionEmptyCells(r, c - 1);
                    }
                }
            }
            if (isValidCell(r, c + 1)) {
                if (this.getBoard()[r][c + 1] instanceof EmptyCell || (this.getBoard()[r][c + 1] instanceof MaskedCell)) {

                    if (!this.recursionEmptyCellsCollection.contains(this.getBoard()[r][c + 1])) {
                        this.setToEmptyCell(r, c + 1);
                        this.recursionEmptyCellsCollection.add(this.getBoard()[r][c + 1]);
                        this.movesLeft=this.decreaseMoves();
                        recursionEmptyCells(r, c + 1);
                    }
                }
            }
            if (isValidCell(r + 1, c + 1)) {
                if (this.getBoard()[r + 1][c + 1] instanceof EmptyCell || this.getBoard()[r + 1][c + 1] instanceof MaskedCell) {
                    if (!this.recursionEmptyCellsCollection.contains(this.getBoard()[r + 1][c + 1])) {
                        this.setToEmptyCell(r + 1, c + 1);
                        this.recursionEmptyCellsCollection.add(this.getBoard()[r + 1][c + 1]);
                        this.movesLeft=this.decreaseMoves();
                        recursionEmptyCells(r + 1, c + 1);
                    }
                }
            }
            if (isValidCell(r + 1, c - 1)) {
                if (this.getBoard()[r + 1][c - 1] instanceof EmptyCell || this.getBoard()[r + 1][c - 1] instanceof MaskedCell) {
                    if (!this.recursionEmptyCellsCollection.contains(this.getBoard()[r + 1][c - 1])) {
                        this.setToEmptyCell(r + 1, c - 1);
                        this.recursionEmptyCellsCollection.add(this.getBoard()[r + 1][c - 1]);
                        this.movesLeft=this.decreaseMoves();
                        recursionEmptyCells(r + 1, c - 1);
                    }
                }
            }
            if (isValidCell(r - 1, c + 1)) {
                if (this.getBoard()[r - 1][c + 1] instanceof EmptyCell || this.getBoard()[r - 1][c + 1] instanceof MaskedCell) {
                    if (!this.recursionEmptyCellsCollection.contains(this.getBoard()[r - 1][c + 1])) {
                        this.setToEmptyCell(r - 1, c + 1);
                        this.recursionEmptyCellsCollection.add(this.getBoard()[r - 1][c + 1]);
                        this.movesLeft=this.decreaseMoves();
                        recursionEmptyCells(r - 1, c + 1);
                    }
                }
            }
            if (isValidCell(r - 1, c - 1)) {
                if (this.getBoard()[r - 1][c - 1] instanceof EmptyCell || this.getBoard()[r - 1][c - 1] instanceof MaskedCell) {
                    if (!this.recursionEmptyCellsCollection.contains(this.getBoard()[r - 1][c - 1])) {
                        this.setToEmptyCell(r - 1, c - 1);
                        this.recursionEmptyCellsCollection.add(this.getBoard()[r - 1][c - 1]);
                        this.movesLeft=this.decreaseMoves();
                        recursionEmptyCells(r - 1, c - 1);
                    }
                }
            }
            if (isValidCell(r - 1, c)) {
                if (this.getBoard()[r - 1][c] instanceof EmptyCell || this.getBoard()[r - 1][c] instanceof MaskedCell) {
                    if (!this.recursionEmptyCellsCollection.contains(this.getBoard()[r - 1][c])) {
                        this.setToEmptyCell(r - 1, c);
                        this.recursionEmptyCellsCollection.add(this.getBoard()[r - 1][c]);
                        this.movesLeft=this.decreaseMoves();
                        recursionEmptyCells(r - 1, c);
                    }
                }
            }
            if (isValidCell(r + 1, c)) {
                if (this.getBoard()[r + 1][c] instanceof EmptyCell || this.getBoard()[r + 1][c] instanceof MaskedCell) {
                    if (!this.recursionEmptyCellsCollection.contains(this.getBoard()[r + 1][c])) {
                        this.setToEmptyCell(r + 1, c);
                        this.recursionEmptyCellsCollection.add(this.getBoard()[r + 1][c]);
                        this.movesLeft= this.decreaseMoves();
                        recursionEmptyCells(r + 1, c);
                    }
                }
            }
        } else {
            //exception
        }
    }

    private void setToEmptyCell(int r, int c) {
        this.getBoard()[r][c] = new EmptyCell(r, c);
    }

    public void updateTypeCell(int r, int c) {
        if (isValidCell(r, c)) {
            int countMines = 0;

            if (!this.getBoard()[r][c].getIsMine()) {
                if (isValidCell(r, c - 1)) {
                    if (this.getBoard()[r][c - 1].getIsMine()) {
                        countMines++;
                    }
                }
                if (isValidCell(r, c + 1)) {
                    if (this.getBoard()[r][c + 1].getIsMine()) {
                        countMines++;
                    }
                }
                if (isValidCell(r + 1, c + 1)) {
                    if (this.getBoard()[r + 1][c + 1].getIsMine()) {
                        countMines++;
                    }
                }
                if (isValidCell(r + 1, c - 1)) {
                    if (this.getBoard()[r + 1][c - 1].getIsMine()) {
                        countMines++;
                    }
                }
                if (isValidCell(r - 1, c + 1)) {
                    if (this.getBoard()[r - 1][c + 1].getIsMine()) {
                        countMines++;
                    }
                }
                if (isValidCell(r - 1, c - 1)) {
                    if (this.getBoard()[r - 1][c - 1].getIsMine()) {
                        countMines++;
                    }
                }
                if (isValidCell(r - 1, c)) {
                    if (this.getBoard()[r - 1][c].getIsMine()) {
                        countMines++;
                    }
                }
                if (isValidCell(r + 1, c)) {
                    if (this.getBoard()[r + 1][c].getIsMine()) {
                        countMines++;
                    }
                }

                if (countMines == 0) {
                    return;
                }

                this.getBoard()[r][c] = new DigitCell(r, c, countMines);
            }

        } else {
            //ADD EXCEPTION
        }
    }

}
