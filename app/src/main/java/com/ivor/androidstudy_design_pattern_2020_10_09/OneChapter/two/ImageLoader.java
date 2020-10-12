package com.ivor.androidstudy_design_pattern_2020_10_09.OneChapter.two;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 图片加载类
 */

public class ImageLoader {

    String TAG = getClass().getSimpleName();

    ImageCache mImageCache = new MemoryCache();

    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    Handler mUIHandler = new Handler(Looper.getMainLooper());

    public ImageLoader() {

    }

    public void setImageCache(ImageCache mImageCache) {
        this.mImageCache = mImageCache;
    }

    public void displayImage(final String url, final ImageView imageView) {
        imageView.setTag(url);
        Bitmap bitmap = mImageCache.get(url);
        if (bitmap != null) {
            updateImageView(imageView, bitmap);
            return;
        }

        submitLoadRequest(url, imageView);

    }


    private void updateImageView(final ImageView imageView, final Bitmap bitmap) {
        mUIHandler.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    private Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bitmap != null) {
            Log.d(TAG, "bitmap: size======>" + bitmap.getRowBytes() * bitmap.getHeight() / 1024);
        }
        return bitmap;
    }

    private void submitLoadRequest(final String imageUrl, final ImageView imageView) {
        imageView.setTag(imageUrl);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(imageUrl);
                if (bitmap == null) {
                    return;
                }
                if (imageView.getTag().equals(imageUrl)) {
                    updateImageView(imageView, bitmap);
                }
            }
        });
    }

}
