package com.example.android.irantravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.android.irantravel.gallery.GalleryFragment;

public class EntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        //String s = getCacheDir().getAbsolutePath() + "/databases";
        new DBHelper(this).copyDataBase();

        //GalleryFragment.newInstance(null,0).show(getSupportFragmentManager(),"a;fkjd");

    }

    public void enterMain(View v) {
        Intent enterMain = new Intent(this, MainActivity.class);
        startActivity(enterMain);
    }
}
