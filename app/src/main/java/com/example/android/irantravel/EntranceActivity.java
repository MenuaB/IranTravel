package com.example.android.irantravel;

import android.content.ContextWrapper;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        String destination = "/data/data/com.example.android.irantravel/databases/";
        Log.i(TAG, "onCreate: get file dir = "+getCacheDir());
        Log.i(TAG, "onCreate: getabsolutepath = "+getCacheDir().getAbsolutePath());
        Log.i(TAG, "onCreate: destination = "+ destination);
        copyDataBase("/db/IranTravel.db", destination, "IranTravel.db");
    }


    public void enterMain(View v) {
        Intent enterMain = new Intent(this, MainActivity.class);
        startActivity(enterMain);
    }

    private void copyDataBase(String dbPath, String destination, String dbName) {
        Log.i("Database",
                "New database is being copied to device!");
        byte[] buffer = new byte[1024];
        OutputStream myOutput = null;
        int length;
        // Open your local db as the input stream
        InputStream myInput = null;
        try {
            myInput = getAssets().open(dbPath);
            // transfer bytes from the inputfile to the
            // outputfile
            myOutput = new FileOutputStream(destination + dbName);
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.close();
            myOutput.flush();
            myInput.close();
            Log.i(TAG,
                    "New database has been copied to device!");
            Toast.makeText(this, "db coppied.", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Log.i(TAG, "error"+e.getMessage());
            e.printStackTrace();
        }
    }

    private final String TAG="EnteraceActivity";
}
