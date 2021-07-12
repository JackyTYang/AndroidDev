package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*按钮改变欢迎文字*/
        Button btn1 = findViewById(R.id.btn_change);
        btn1.setOnClickListener(new View.OnClickListener() {
            int flag = 0;
            @Override
            public void onClick(View v) {
                //设置text
                //声明textview_welcome
                if(flag == 0){
                    TextView textline1 = findViewById(R.id.textline1);
                    textline1.setText("GoodBye World");
                    flag = 1;
                    //控制台打印
                    Log.d("btnchange_GoodbyeWorld","我被点击了");
                }
                else{
                    TextView textline1 = findViewById(R.id.textline1);
                    textline1.setText("Hello World");
                    flag = 0;
                    //控制台打印
                    Log.d("btnchange_HelloWorld","我被点击了");
                }

            }
        });

        /*单选框*/
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        RadioButton alading = (RadioButton)findViewById(R.id.radioButton3);
        RadioButton happy = (RadioButton)findViewById(R.id.radioButton1);
        RadioButton sad = (RadioButton)findViewById(R.id.radioButton2);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String chosen = "";
                switch (checkedId){
                    case R.id.radioButton1:
                        chosen = happy.getText().toString();
                        Log.d("chosen_happy","我被点击了");
                        break;
                    case R.id.radioButton2:
                        chosen = sad.getText().toString();
                        Log.d("chosen_sad","我被点击了");
                        break;
                    case R.id.radioButton3:
                        chosen = alading.getText().toString();
                        Log.d("chosen_alading","我被点击了");
                        break;
                    default:break;
                }

                //消息提示
                Toast toast=Toast.makeText(MainActivity.this,"我今天非常"+chosen,Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });


//        ProgressBar progressBar1;
//        progressBar1=(ProgressBar) findViewById(R.id.progressBar1);
//
    }
}