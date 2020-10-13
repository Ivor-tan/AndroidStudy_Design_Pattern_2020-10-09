package com.ivor.androidstudy_design_pattern_2020_10_09.TwoChapter;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton_3 implements Serializable {
    private static final Singleton_3 sInstance = new Singleton_3();

    public static Singleton_3 getInstance() {
        return sInstance;
    }

    private Object readResolve() throws ObjectStreamException {
        return sInstance;
    }


}
