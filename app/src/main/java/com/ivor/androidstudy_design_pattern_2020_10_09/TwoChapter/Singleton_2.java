package com.ivor.androidstudy_design_pattern_2020_10_09.TwoChapter;

import com.ivor.androidstudy_design_pattern_2020_10_09.utils.KLog;

public class Singleton_2 {
    private void Singleton_2() {
    }

    public static Singleton_2 getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static final Singleton_2 sInstance = new Singleton_2();
    }

    public void showLog() {
        KLog.d("showLog");
    }
}
