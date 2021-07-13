package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity","onCreate");

        MainActivityObserver myActivityObserver = new MainActivityObserver();
        getLifecycle().addObserver(myActivityObserver);

        Button btn1 = findViewById(R.id.BtnToBaiDu);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        Button btn4 = findViewById(R.id.BtnToCycler);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Top10.class);
                startActivity(intent);
            }
        });

        Button btn3 = findViewById(R.id.BtnToCall);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:911");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        Button btn2 = findViewById(R.id.BtnToMyActivity);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyActivity.class);
                startActivity(intent);
            }
        });
    }
}


class MainActivityObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void checkStart(){
        Log.i("MainActivity","onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void checkResume() {
        Log.i("MainActivity","onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void checkPause() {
        Log.i("MainActivity","onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void checkStop() {
        Log.i("MainActivity","onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void checkDestroy() {
        Log.i("MainActivity","onDestroy");
    }
}