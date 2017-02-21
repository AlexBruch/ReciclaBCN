package com.project.alex.reciclabcn.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ItemsOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Reciclabcn.db";
    public static final int DATABASE_VERSION = 1;

    public ItemsOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ItemsDatasource.CREATE_ITEMS_SCRIPT);
    }
}
