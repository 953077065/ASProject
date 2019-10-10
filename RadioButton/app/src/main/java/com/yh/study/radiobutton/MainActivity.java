package com.yh.study.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView chooseTxt;
    private RadioGroup radioGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private Button clearBtn;
    private Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chooseTxt = (TextView) findViewById(R.id.chooseTxt);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        clearBtn = (Button) findViewById(R.id.clearBtn);
        addBtn = (Button) findViewById(R.id.addBtn);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = radioGroup.getCheckedRadioButtonId();
                switch (id){
                    case R.id.rb1:
                        chooseTxt.setText("我选择的是："+rb1.getText());
                        break;
                    case R.id.rb2:
                        chooseTxt.setText("我选择的是："+rb2.getText());
                        break;
                    default:
                        chooseTxt.setText("我选择的是：新增");
                        break;
                }
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup.check(-1);
                chooseTxt.setText("我选择的是...?");
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radio = new RadioButton(MainActivity.this);
                radio.setLayoutParams(new RadioGroup.LayoutParams(
                        RadioGroup.LayoutParams.MATCH_PARENT,
                        RadioGroup.LayoutParams.MATCH_PARENT
                ));
                radio.setText("新增");
                radioGroup.addView(radio,radioGroup.getChildCount());
            }
        });
    }
}
