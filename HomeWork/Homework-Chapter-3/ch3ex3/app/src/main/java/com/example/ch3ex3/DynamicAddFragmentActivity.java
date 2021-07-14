package com.example.ch3ex3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DynamicAddFragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_add_fragment);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,new HiFragment())
                .addToBackStack(null)
                .commit();
    }
}
