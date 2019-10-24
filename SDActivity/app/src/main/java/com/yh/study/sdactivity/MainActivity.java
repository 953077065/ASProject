package com.yh.study.sdactivity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class MainActivity extends AppCompatActivity {
    private EditText fileout,filein;
    private Button btnwrite,btnread;
    final String FILE_NAME="text.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filein=(EditText)findViewById(R.id.editFileIn);
        fileout=(EditText)findViewById(R.id.editFileOut);
        btnread=(Button)findViewById(R.id.btnRead);
        btnwrite=(Button)findViewById(R.id.btnWrite);
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filein.setText(read());
            }
        });
        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                write(fileout.getText().toString());
                fileout.setText("");
            }
        });

    }
    private String read(){
        try{
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                File sdCardDir=Environment.getExternalStorageDirectory();
                FileInputStream fis=new FileInputStream(sdCardDir+"/"+FILE_NAME);
                BufferedReader br=new BufferedReader(new InputStreamReader(fis));
                StringBuilder sb=new StringBuilder("");
                String line=null;
                while ((line = br.readLine())!=null)
                    sb.append(line);
                br.close();
                return sb.toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private void write(String content){
        try{
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                File sdCardDir=Environment.getExternalStorageDirectory();
                File targetFile=new File(sdCardDir,FILE_NAME);
                RandomAccessFile raf=new RandomAccessFile(targetFile,"rw");
                raf.seek(targetFile.length());
                raf.write(content.getBytes());
                raf.close();
            }
            Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
