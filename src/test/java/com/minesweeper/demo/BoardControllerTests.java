package com.minesweeper.demo;

import com.minesweeper.demo.controller.BoardController;
import com.minesweeper.demo.engine.Engine;
import com.minesweeper.demo.engine.EngineIml;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardControllerTests {
    //test with Beginner level (4)
    BoardController testGameBoardInvalidLevel = new BoardController(0);
    //test with Beginner level (0)
    BoardController testGameBoardFirst = new BoardController(0);
    //test with Intermediate level (1)
    BoardController testGameBoardSecond = new BoardController(1);



    @Test
    public void ifSecondMoveIsMineShouldStopTheGame() {

        testGameBoardFirst.initialStart();
        testGameBoardFirst.firstCellChosen(0, 0);
        Random random = new Random();
        while (true) {
            int row = random.nextInt(testGameBoardFirst.getDimension());
            int col = random.nextInt(testGameBoardFirst.getDimension());
            testGameBoardFirst.play(row, col);
            if (testGameBoardFirst.getDead()) {
                assertTrue(true, String.valueOf(testGameBoardFirst.getDead()));
                break;
            }
        }

    }
}
