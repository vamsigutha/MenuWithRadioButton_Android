package com.example.menuwithradiobutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int itemSelected=0;

    public void networkSelection(View view){
        registerForContextMenu(view);
        openContextMenu(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.network_menu,menu);

        /*
        Here we create our our menu items form MenuItem class for each item and then,
         we perform pre check if user already checked and we assign it
        */

        MenuItem item_wifi = menu.findItem(R.id.wifi);
        MenuItem item_bluetooth = menu.findItem(R.id.bluetooth);
        MenuItem item_mobile = menu.findItem(R.id.mobile);

        if(itemSelected==1){
            item_wifi.setChecked(true);
        }else if(itemSelected==2){
            item_bluetooth.setChecked(true);
        }else if(itemSelected==3){
            item_mobile.setChecked(true);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.wifi:
                Toast.makeText(getApplicationContext(),"Wifi Selected",Toast.LENGTH_LONG).show();
                item.setChecked(true);
                itemSelected=1;
                return true;
            case R.id.bluetooth:
                Toast.makeText(getApplicationContext(),"Bluetooth Selected",Toast.LENGTH_LONG).show();
                item.setChecked(true);
                itemSelected=2;
                return true;
            case R.id.mobile:
                Toast.makeText(getApplicationContext(),"Mobile Selected",Toast.LENGTH_LONG).show();
                item.setChecked(true);
                itemSelected=3;
                return true;
        }

        return super.onContextItemSelected(item);
    }
}