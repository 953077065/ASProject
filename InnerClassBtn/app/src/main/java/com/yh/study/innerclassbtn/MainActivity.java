package com.yh.study.innerclassbtn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn1);
        tv1=(TextView) findViewById(R.id.tv1);
        btn.setOnClickListener(new ClickListener());

    }
    class ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            tv1.setText("BTN 被点击了");
        }
    }
}
