package com.yh.study.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView show;
    Bitmap bitmap;
    @SuppressLint("HandlerLeak")
    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0x123){
                if(bitmap == null){
                    show.setImageResource(android.R.drawable.ic_lock_lock);
                }else{
                    show.setImageBitmap(bitmap);
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (ImageView)findViewById(R.id.show);
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url=new URL("http://101.200.55.106/data/user/admin/home/plus_logo_web.png");
                    InputStream is=url.openStream();
                    bitmap = BitmapFactory.decodeStream(is);
                    h.sendEmptyMessage(0x123);
                    is.close();
                }catch (Exception e){
                    String msg=e.getMessage();
                    Log.d("HandlerActivity",msg);
                    h.sendEmptyMessage(0x123);
                }

            }
        }.start();
    }
}
