package com.ivor.androidstudy_design_pattern_2020_10_09;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.ivor.androidstudy_design_pattern_2020_10_09.ThreeChapter.five.Builder;
import com.ivor.androidstudy_design_pattern_2020_10_09.ThreeChapter.five.Director;
import com.ivor.androidstudy_design_pattern_2020_10_09.ThreeChapter.five.MacBookBuilder;
import com.ivor.androidstudy_design_pattern_2020_10_09.utils.KLog;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends AppCompatActivity {
    private final static String imageUrl = "https://c-ssl.duitang.com/uploads/item/201512/22/20151222223118_tnvcX.thumb.1000_0.jpeg";

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
//        2020-10-27
//        ImageLoader imageLoader = new ImageLoader();
//        imageLoader.setImageCache(new DoubleCache());
//        imageLoader.displayImage(imageUrl, imageView);
//
//        Singleton_1.getInstance();
//        Singleton_2.getInstance().showLog();
//
//        Singleton_4.INSTANCE.doSomething();
//      2020-10-27


        Builder builder = new MacBookBuilder();

        Director director = new Director(builder);

        director.construct("Intent", "SONGREN");

        KLog.d(builder.create().toString());

//        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//        builder1.show()

        ImageLoaderConfiguration builder1 = new ImageLoaderConfiguration.Builder(this)
                .denyCacheImageMultipleSizesInMemory()
                .threadPoolSize(5)
                .build();
//                .defaultDisplayImageOptions()
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().init(builder1);


//        LayoutInflater.from(this).inflate();
    }
}