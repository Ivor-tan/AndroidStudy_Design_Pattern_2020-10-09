package com.ivor.androidstudy_design_pattern_2020_10_09.ThreeChapter.five;

import androidx.annotation.NonNull;

public abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOS;

    protected Computer() {

    }

    public void setBoard(String board) {
        this.mBoard = board;
    }

    public void setDisplay(String display) {
        this.mDisplay = display;
    }

    public abstract void setOS();

    public String getInfo(){
        return mBoard + "===" + mDisplay + "===" + mOS;
    }

    @NonNull
    @Override
    public String toString() {

        return mBoard + "===" + mDisplay + "===" + mOS;
    }
}
