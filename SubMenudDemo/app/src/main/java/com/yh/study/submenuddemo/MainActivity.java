package com.yh.study.submenuddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu sm=menu.addSubMenu(0,2,Menu.NONE,"Basic Action");
        MenuItem rename = sm.add(2,201,1,"Rename");
        rename.setIcon(android.R.drawable.ic_menu_edit);
        MenuItem share = sm.add(2,202,1,"Share");
        share.setIcon(android.R.drawable.ic_menu_share);
        MenuItem delete = sm.add(2,203,1,"Delete");
        delete.setIcon(android.R.drawable.ic_menu_delete);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 201:Msg("Rename Action");break;
            case 202:Msg("Share Action");break;
            case 203:Msg("Delete Action");break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void Msg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
