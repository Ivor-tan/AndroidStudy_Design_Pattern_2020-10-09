package com.ivor.androidstudy_design_pattern_2020_10_09.ThreeChapter.five;

public class Director {
    Builder mBuilder = null;

    public Director(Builder builder) {
        this.mBuilder = builder;
    }

    public void construct(String board, String display) {
        mBuilder.buildBoard(board);
        mBuilder.buildDisplay(display);
        mBuilder.buildOS();
    }
}
