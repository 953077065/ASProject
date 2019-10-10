package com.yh.study.menudemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,0,1,"张佳杰");
        menu.add(0,1,1,"是");
        menu.add(0,2,1,"我的儿");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 0:Msg("Menu Item 1 has been clicked");break;
            case 1:Msg("Menu Item 2 has been clicked");break;
            case 2:Msg("Menu Item 3 has been clicked");break;
            default:Msg("Default");break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void Msg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
