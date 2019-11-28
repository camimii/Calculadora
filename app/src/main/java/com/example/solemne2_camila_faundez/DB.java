package com.example.solemne2_camila_faundez;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    private static final String DB_NAME = "test.db";
    private static final int VERSION = 1;
    private final String[] nombreTablas = new String[]{"ULTIMAOP"};
    private final String[] tablas;

    public DB(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
        // Tablas
        tablas = new String[]{
                "CREATE TABLE ULTIMAOP(" +
                        "OPERACION VARCHAR(100) PRIMARY KEY NOT NULL," +
                        "TOTAL varchar(100) NOT NULL"+
                        ")"};
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String s : tablas)
            db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        for (String s : nombreTablas)
            db.execSQL("DROP TABLE IF EXISTS " + s);
        onCreate(db);
    }

}
