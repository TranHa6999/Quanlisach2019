package com.tuan.duanmau.Base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void changeClass(Class target){
        Intent intent = new Intent(this, target);
        startActivity(intent);
    }

    public void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void replaceFragment(int layout, Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(layout,fragment).commit();
        }
    }

}
