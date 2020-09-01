package com.minesweeper.demo.repositories;

public interface CellRepository {
    boolean setIsMine();

    boolean getIsMine();

    String getValue();
}
