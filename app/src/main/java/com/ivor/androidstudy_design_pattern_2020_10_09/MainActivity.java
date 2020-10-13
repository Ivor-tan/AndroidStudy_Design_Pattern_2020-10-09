package com.ivor.androidstudy_design_pattern_2020_10_09;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.ivor.androidstudy_design_pattern_2020_10_09.OneChapter.two.DoubleCache;
import com.ivor.androidstudy_design_pattern_2020_10_09.OneChapter.two.ImageLoader;
import com.ivor.androidstudy_design_pattern_2020_10_09.TwoChapter.Singleton_1;
import com.ivor.androidstudy_design_pattern_2020_10_09.TwoChapter.Singleton_2;
import com.ivor.androidstudy_design_pattern_2020_10_09.TwoChapter.Singleton_4;

public class MainActivity extends AppCompatActivity {
    private final static String imageUrl = "https://c-ssl.duitang.com/uploads/item/201512/22/20151222223118_tnvcX.thumb.1000_0.jpeg";

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        ImageLoader imageLoader = new ImageLoader();
        imageLoader.setImageCache(new DoubleCache());
        imageLoader.displayImage(imageUrl, imageView);

        Singleton_1.getInstance();
        Singleton_2.getInstance().showLog();

        Singleton_4.INSTANCE.doSomething();

//        LayoutInflater.from(this).inflate();
    }
}