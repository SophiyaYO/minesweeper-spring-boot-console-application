package com.minesweeper.demo.view;

public class IntroMsg {
    static final String INTRO_MSG = "Enter the Difficulty Level\n" +
            "Press 0 for BEGINNER (9 * 9 Cells and 10 Mines)\n" +
            "Press 1 for INTERMEDIATE (16 * 16 Cells and 40 Mines)\n" +
            "Press 2 for ADVANCED (24 * 24 Cells and 99 Mines)";

    private String msg;

    public IntroMsg() {
        this.msg = INTRO_MSG;
    }

    public void getIntroMsg(){
        System.out.println(this.msg);
    }
}
