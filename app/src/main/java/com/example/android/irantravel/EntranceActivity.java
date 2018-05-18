package com.example.android.irantravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class EntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        //String s = getCacheDir().getAbsolutePath() + "/databases";
        new DBHelper(this).copyDataBase();

    }

    public void enterMain(View v) {
        Intent enterMain = new Intent(this, MainActivity.class);
        startActivity(enterMain);
    }
}
