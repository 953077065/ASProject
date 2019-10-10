package com.yh.study.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView flagImg;
    TextView flagText;
    ImageButton backBtn;
    ImageButton forwardBtn;
    int[] flag={R.drawable.flag_us,R.drawable.flag_de,R.drawable.flag_ru};
    String[] flagNames={"美国","德国","俄罗斯"};
    int cp=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flagImg=(ImageView)findViewById(R.id.flagIV);
        flagText=(TextView)findViewById(R.id.flagText);
        backBtn = (ImageButton)findViewById(R.id.backBtn);
        forwardBtn = (ImageButton)findViewById(R.id.forwardBtn);
        backBtn.setOnClickListener(onClickListener);
        forwardBtn.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.backBtn:
                    if(cp == 0){
                        Toast.makeText(MainActivity.this,"第一页，前面没有了,",Toast.LENGTH_SHORT).show();
                    }else{
                        cp--;
                        flagImg.setImageResource(flag[cp]);
                        flagText.setText(flagNames[cp]);
                    }
                    break;
                case R.id.forwardBtn:
                    if(cp==flag.length-1){
                        Toast.makeText(MainActivity.this,"最后一页，后面没有了,",Toast.LENGTH_SHORT).show();
                    }else{
                        cp++;
                        flagImg.setImageResource(flag[cp]);
                        flagText.setText(flagNames[cp]);
                    }
                    break;
                default:
                    break;
            }
        }
    };
}
