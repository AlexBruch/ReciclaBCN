package com.project.alex.reciclabcn.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by alexbruch on 21/2/17.
 */

public abstract class DataBaseManager {

    private ItemsOpenHelper itemsOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DataBaseManager() {
    }

    public DataBaseManager(Context context) {
        itemsOpenHelper = new ItemsOpenHelper(context);
        sqLiteDatabase = itemsOpenHelper.getWritableDatabase();
    }

    public void closeDB() {
        sqLiteDatabase.close();
    }

    abstract public Cursor cargarCursor();

    public ItemsOpenHelper getItemsOpenHelper() {
        return itemsOpenHelper;
    }

    public void setItemsOpenHelper(ItemsOpenHelper itemsOpenHelper) {
        this.itemsOpenHelper = itemsOpenHelper;
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public void setSqLiteDatabase(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }
}
