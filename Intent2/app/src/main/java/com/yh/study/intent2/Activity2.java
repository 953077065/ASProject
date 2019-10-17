package com.yh.study.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView tx = (TextView)findViewById(R.id.aihao);
        Intent intent = getIntent();
        int num = intent.getIntExtra("num",0);
        String str="";
        for(int i=0;i<num;i++){
            str+=intent.getStringExtra(""+i)+" ";
        }
        tx.setText(str);
    }
}
