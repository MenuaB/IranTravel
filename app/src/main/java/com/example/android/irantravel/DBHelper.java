package com.example.android.irantravel;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Farhad-Beigirad on 5/15/18.
 */

public class DBHelper {
    private final String TAG = this.getClass().getSimpleName();
    private Context context;
    private String DB_NAME = "IranTravel.db";
    private String NEW_DB_PATH;

    public DBHelper(Context context) {
        this.context = context;
        NEW_DB_PATH = context.getFilesDir().getParent() + "/databases/";
    }

    public void copyDataBase() {
        try {
            String asstFileDir = "db/" + DB_NAME;
            Log.i(TAG, "Copy DB from " + asstFileDir);

            InputStream is = context.getAssets().open(asstFileDir);
            Log.i(TAG, "available : " + is.available());


            File folder = new File(NEW_DB_PATH);
            if (!folder.exists())
                folder.mkdirs();
            File file = new File(NEW_DB_PATH, DB_NAME);
            Log.i(TAG, "file in " + file.getAbsolutePath() + " existed " + file.exists());
            if (!file.exists())
                file.createNewFile();
            OutputStream os = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {

                os.write(buffer, 0, length);
            }
            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
