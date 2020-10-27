package com.ivor.androidstudy_design_pattern_2020_10_09.ThreeChapter.five;

public abstract class Builder {

    public abstract void buildBoard(String board);
    public abstract void buildDisplay(String display);
    public abstract void buildOS();

    public abstract Computer create();
}
