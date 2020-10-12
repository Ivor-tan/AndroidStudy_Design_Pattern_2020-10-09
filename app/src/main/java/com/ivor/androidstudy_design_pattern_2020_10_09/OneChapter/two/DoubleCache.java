package com.ivor.androidstudy_design_pattern_2020_10_09.OneChapter.two;

import android.graphics.Bitmap;

import com.ivor.androidstudy_design_pattern_2020_10_09.utils.KLog;

public class DoubleCache implements ImageCache {
    ImageCache mMemoryCache = new MemoryCache();
    ImageCache mDiskCache = new DiskCache();


    @Override
    public Bitmap get(String url) {
        KLog.d("get");
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        KLog.d("put");
        mDiskCache.put(url, bitmap);
        mMemoryCache.put(url, bitmap);
    }
}
