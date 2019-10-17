package com.yh.study.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowResult extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        TextView showResult=(TextView)findViewById(R.id.ShowResult);
        Intent intent=getIntent();
        Bundle res=intent.getExtras();
        String username=res.getString("name");
        String password=res.getString("password");
        showResult.setText("Welcome, "+username+" To Use,Your Password Is "+password);
    }
}
