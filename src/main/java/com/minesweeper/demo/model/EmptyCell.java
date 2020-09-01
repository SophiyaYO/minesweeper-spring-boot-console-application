package com.minesweeper.demo.model;

public class EmptyCell extends Cell {
    boolean hasMine;
    String cellValue;

    public EmptyCell(int row, int col) {
        super(row, col);
        this.hasMine = setIsMine();
        this.cellValue = " ";
    }

    @Override
    public boolean setIsMine() {
        return false;
    }

    @Override
    public boolean getIsMine() {
        return this.hasMine;
    }

    @Override
    public String getValue() {
        return this.cellValue;
    }
}
