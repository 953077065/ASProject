package com.yh.study.intentdemo;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = (Button)findViewById(R.id.BtnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                TextView user=(TextView)findViewById(R.id.Username);
                TextView pass=(TextView)findViewById(R.id.PassWord);
                data.putString("name",user.getText().toString());
                data.putString("password",pass.getText().toString());
                Intent intent = new Intent(MainActivity.this,ShowResult.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });
    }
}
