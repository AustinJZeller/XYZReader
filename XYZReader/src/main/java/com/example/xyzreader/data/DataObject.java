package com.example.xyzreader.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.xyzreader.data.NetworkObject.Tables;

public class DataObject extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "xyzreader.db";
    private static final int DATABASE_VERSION = 1;

    public DataObject(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Tables.ITEMS + " ("
                + BondObject.ItemsColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + BondObject.ItemsColumns.SERVER_ID + " TEXT,"
                + BondObject.ItemsColumns.TITLE + " TEXT NOT NULL,"
                + BondObject.ItemsColumns.AUTHOR + " TEXT NOT NULL,"
                + BondObject.ItemsColumns.BODY + " TEXT NOT NULL,"
                + BondObject.ItemsColumns.THUMB_URL + " TEXT NOT NULL,"
                + BondObject.ItemsColumns.PHOTO_URL + " TEXT NOT NULL,"
                + BondObject.ItemsColumns.ASPECT_RATIO + " REAL NOT NULL DEFAULT 1.5,"
                + BondObject.ItemsColumns.PUBLISHED_DATE + " INTEGER NOT NULL DEFAULT 0"
                + ")" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Tables.ITEMS);
        onCreate(db);
    }
}
