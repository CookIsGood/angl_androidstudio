package com.example.readwritefile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

    final String LOG_TAG = "myLogs";

    final String FILENAME = "file.txt";




    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View v) {
        if (v.getId() == R.id.btnWrite) {
            createDir();
        }
    }

    private void createDir() {
        try {

            EditText simpleEditText = (EditText) findViewById(R.id.edit_text);
            String strValue = simpleEditText.getText().toString();
            File mydir = getDir(strValue, Context.MODE_PRIVATE);
            if (!mydir.exists())
                mydir.mkdirs();
            File fileWithinMyDir = new File(mydir, FILENAME);
            FileOutputStream out = new FileOutputStream(fileWithinMyDir);
            Log.d(LOG_TAG, "Папка создана с файлом");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }





}