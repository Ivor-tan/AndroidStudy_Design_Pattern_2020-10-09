package com.ivor.androidstudy_design_pattern_2020_10_09.OneChapter.two;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.ivor.androidstudy_design_pattern_2020_10_09.utils.KLog;

public class MemoryCache implements ImageCache {
    LruCache<String, Bitmap> mImageCache;

    public MemoryCache() {
        initImageCache();
    }

    private void initImageCache() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        final int cacheSize = maxMemory / 4;

        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(String url) {
        KLog.d("get");
        return mImageCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        KLog.d("put");
        mImageCache.put(url, bitmap);
    }
}
