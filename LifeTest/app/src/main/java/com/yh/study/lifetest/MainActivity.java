package com.yh.study.lifetest;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private static final String TAG="LifeTestActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"执行了onCreate方法");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"执行了onStart方法");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"执行了onResume方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"执行了onStop方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"执行了onPause方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"执行了onRestart方法");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"执行了onDestroy方法");
    }
}
