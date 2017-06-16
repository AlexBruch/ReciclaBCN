package com.project.alex.reciclabcn.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by alexbruch on 21/2/17.
 */

public abstract class DataBaseManager {

    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DataBaseManager() {
    }

    public DataBaseManager(Context context) {
        dbHelper = new DBHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public void closeDB() {
        sqLiteDatabase.close();
    }

    abstract public Cursor cargarCursor();

    abstract public  Cursor cargarCursorM(String color);

    public DBHelper getDbHelper() {
        return dbHelper;
    }

    public void setDbHelper(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public void setSqLiteDatabase(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }
}
