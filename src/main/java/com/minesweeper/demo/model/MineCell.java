package com.minesweeper.demo.model;

public class MineCell extends Cell {
    boolean hasMine;
    String cellValue;

    public MineCell(int row, int col) {
        super(row, col);
        this.hasMine = true;
        this.cellValue = "*";
    }

    @Override
    public boolean setIsMine() {
        return true;
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
