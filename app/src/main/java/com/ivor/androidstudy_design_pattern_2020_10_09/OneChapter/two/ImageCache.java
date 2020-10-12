package com.ivor.androidstudy_design_pattern_2020_10_09.OneChapter.two;

import android.graphics.Bitmap;

public interface ImageCache {

    public Bitmap get(String url);

    public void put(String url, Bitmap bitmap);
}
