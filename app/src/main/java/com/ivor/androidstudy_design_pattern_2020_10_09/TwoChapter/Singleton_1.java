package com.ivor.androidstudy_design_pattern_2020_10_09.TwoChapter;

public class Singleton_1 {
    private volatile static Singleton_1 instance = null;

    private void Singleton() {

    }

    public static Singleton_1 getInstance() {
        if (instance == null) {
            synchronized (Singleton_1.class) {
                if (instance == null) {
                    instance = new Singleton_1();
                }
            }
        }
        return instance;
    }

}
