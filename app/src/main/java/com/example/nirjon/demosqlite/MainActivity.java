package com.example.nirjon.demosqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = openOrCreateDatabase("MyDatabse", Context.MODE_PRIVATE, null);

        db.execSQL("DROP TABLE IF EXISTS User");
        db.execSQL("CREATE TABLE User (name TEXT, address TEXT)");
        db.execSQL("INSERT INTO User VALUES ('john', 'winterfell')");
        db.execSQL("INSERT INTO User VALUES ('daenerys', 'dragon stone')");

        Cursor c = db.rawQuery("SELECT * from User", null);
        c.moveToFirst();

        for(int i = 0; i < c.getCount(); i++){

            for(int j = 0; j < c.getColumnCount(); j++) {
                Log.v("tag", c.getString(j));
            }

            c.moveToNext();

        }


    }
}
