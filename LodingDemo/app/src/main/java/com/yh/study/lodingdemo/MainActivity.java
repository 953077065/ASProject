package com.yh.study.lodingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button progressCircleBtn; Button progressBarBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressCircleBtn=(Button)findViewById(R.id.progressCircleBtn);
        progressCircleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setIcon(android.R.drawable.ic_dialog_dialer);
                progressDialog.setTitle("等待");
                progressDialog.setMessage("正在加载。。。");
                progressDialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            progressDialog.dismiss();
                        }
                    }
                }).start();
            }
        });
        progressBarBtn=(Button)findViewById(R.id.progressBarBtn);
        progressBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        final ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        progressDialog.setTitle("提示");
                        progressDialog.setMessage("数据加载中，请稍后。。。");
                        progressDialog.setIcon(android.R.drawable.ic_dialog_dialer);
                        progressDialog.setIndeterminate(false);
                        progressDialog.setCancelable(true);
                        progressDialog.setMax(200);
                        progressDialog.setProgress(0);
                        progressDialog.setSecondaryProgress(1000);
                        progressDialog.show();
                        new Thread(){
                            public void run(){
                                int count=0;
                                while(count<=200){
                                    progressDialog.setProgress(count++);
                                    try{
                                        Thread.sleep(100);
                                    }catch(Exception e){

                                    }
                                }
                            }
                        }.start();
                    }
        });
    }
}
