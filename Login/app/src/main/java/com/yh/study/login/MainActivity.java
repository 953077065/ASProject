package com.yh.study.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText pwd;
    private Button login;
    private TextView tips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.pwd);
        login = (Button) findViewById(R.id.login);
        tips = (TextView) findViewById(R.id.tips);
        final String name1=name.toString();
        final String pwd1=pwd.toString();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!"admin".equals(name1)){
                    tips.setText("用户名不存在");
                    tips.setVisibility(View.VISIBLE);
                    return;
                }
                if (!"1".equals(pwd1)){
                    tips.setText("密码不正确");
                    tips.setVisibility(View.VISIBLE);
                    return;
                }
                if ("admin".equals(name1)&&"1".equals(pwd1)){
                    tips.setText("登录成功");
                    tips.setVisibility(View.VISIBLE);
                    return;
                }
            }
        });
    }
}
