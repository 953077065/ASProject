package com.yh.study.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Bundle bundle;
    private List<CheckBox> checkBoxs = new ArrayList<CheckBox>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        bundle = new Bundle();
        checkBoxs.add((CheckBox)findViewById(R.id.checkbox1));
        checkBoxs.add((CheckBox)findViewById(R.id.checkbox2));
        checkBoxs.add((CheckBox)findViewById(R.id.checkbox3));
        checkBoxs.add((CheckBox)findViewById(R.id.checkbox4));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=0;
                for(CheckBox chx:checkBoxs){
                    if(chx.isChecked()){
                        bundle.putString(""+i,chx.getText().toString());
                        i++;
                    }
                }
                bundle.putInt("num",i);
                Intent intent=new Intent(MainActivity.this,Activity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
