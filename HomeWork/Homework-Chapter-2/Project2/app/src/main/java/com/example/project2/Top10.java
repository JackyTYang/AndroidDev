package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Top10 extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top10);

        recyclerView = findViewById(R.id.recyclerview);

        List<People> peopleList = new ArrayList<>();

        for(int i = 0; i<20; i++){
            People temppeople = new People("Jacky"+i,R.drawable.test);
            peopleList.add(temppeople);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyAdaptor myAdaptor = new MyAdaptor(peopleList);
        recyclerView.setAdapter(myAdaptor);
    }
}