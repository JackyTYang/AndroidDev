package com.example.ch7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class picture extends AppCompatActivity {

    String rightUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201104%2F16%2F2136492e16kpc6oqcz1rie.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1629360805&t=af6ad46a66bd89ffe7962bd2f9b7ca4b";
    String wrongUrl = "abcdefg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture2);

        ImageView imageView = findViewById(R.id.display);
        Button btnsuccess = findViewById(R.id.button1);
        Button btnfail = findViewById(R.id.button2);
        Button btnroundcorner = findViewById(R.id.button3);

        btnsuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(picture.this).load(rightUrl)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_background)
                        .transition(withCrossFade())
                        .into(imageView);
            }
        });

        btnfail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(picture.this).load(wrongUrl)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_background)
                        .transition(withCrossFade())
                        .into(imageView);
            }
        });

        btnroundcorner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawableCrossFadeFactory drawableCrossFadeFactory = new DrawableCrossFadeFactory.Builder(1000).setCrossFadeEnabled(true).build();

                Glide.with(picture.this).load(rightUrl)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_background)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                        .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
                        .into(imageView);
            }
        });
    }
}