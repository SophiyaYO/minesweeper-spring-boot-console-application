package com.minesweeper.demo.model;

public class DigitCell extends Cell {
    private boolean hasMine;
    private int cellValue;

    public DigitCell(int row, int col, int cellValue) {
        super(row,col);
        this.hasMine = setIsMine();
        this.cellValue=cellValue;
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
        return String.valueOf(this.cellValue);
    }

}
