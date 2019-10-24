package com.yh.study.fileio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

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
        try {
            FileInputStream fis=openFileInput(FILE_NAME);
            byte[] buff=new byte[1024];
            int hasRead=0;
            StringBuilder sb=new StringBuilder("");
            while ((hasRead=fis.read(buff))>0)
                sb.append(new String(buff,0,hasRead));
            fis.close();
            return sb.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private void write(String content){
        try {
            FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_APPEND);
            PrintStream ps=new PrintStream(fos);
            ps.println(content);
            ps.close();
            Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_LONG).show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
