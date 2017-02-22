package com.project.alex.reciclabcn.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.project.alex.reciclabcn.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexbruch on 14/2/17.
 */

public class ItemsDatasource extends DataBaseManager{

    private ItemsOpenHelper itemsOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public static final String CONTENIDORS_TABLE_NAME = "Contenidors";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    public static class ColumnContenidors {
        public static final String CONTENIDOR_ID = "_id";
        public static final String CONTENIDOR_NAME = "name";
        public static final String CONTENIDOR_COLOR_1 = "color1";
        public static final String CONTENIDOR_COLOR_2 = "color2";
        public static final String CONTENIDOR_THUMBNAIL = "thumbnail";
    }

    /** PER CREAR LA TAULA A LA BASE DE DADES **/

    public static final String CREATE_ITEMS_SCRIPT =
            "create table " + CONTENIDORS_TABLE_NAME + "(" +
                    ColumnContenidors.CONTENIDOR_ID + " " + INT_TYPE + " primary key autoincrement, "+
                    ColumnContenidors.CONTENIDOR_NAME + " " + STRING_TYPE + " not null, " +
                    ColumnContenidors.CONTENIDOR_COLOR_1 + " " + STRING_TYPE + " not null, " +
                    ColumnContenidors.CONTENIDOR_COLOR_2 + " " + STRING_TYPE + " not null, " +
                    ColumnContenidors.CONTENIDOR_THUMBNAIL + " " + STRING_TYPE + " not null)";

    public ItemsDatasource(Context context) {
        super(context);
        itemsOpenHelper = new ItemsOpenHelper(context);
        sqLiteDatabase = itemsOpenHelper.getWritableDatabase();
    }

    @Override
    public void closeDB() {
        super.getSqLiteDatabase().close();
    }

    /** CREAR TAULA CONTENIDORS **/
    public void saveContenidors( String contenidor_name, String color1, String color2, String thumbnail) {
        ContentValues values = new ContentValues();

        //values.put(ColumnContenidors.CONTENIDOR_ID, id);
        values.put(ColumnContenidors.CONTENIDOR_NAME, contenidor_name);
        values.put(ColumnContenidors.CONTENIDOR_COLOR_1, color1);
        values.put(ColumnContenidors.CONTENIDOR_COLOR_2, color2);
        values.put(ColumnContenidors.CONTENIDOR_THUMBNAIL, thumbnail);

        sqLiteDatabase.insert(CONTENIDORS_TABLE_NAME, null, values);
    }

    public void cleanContenidors() {
        sqLiteDatabase.delete(CONTENIDORS_TABLE_NAME, null, null);
    }

    @Override
    public Cursor cargarCursor() {
        String[] columns = new String[]{
                ColumnContenidors.CONTENIDOR_ID,
                ColumnContenidors.CONTENIDOR_NAME,
                ColumnContenidors.CONTENIDOR_COLOR_1,
                ColumnContenidors.CONTENIDOR_COLOR_2,
                ColumnContenidors.CONTENIDOR_THUMBNAIL};

        return super.getSqLiteDatabase().query(CONTENIDORS_TABLE_NAME, columns, null, null, null, null, null);
    }

    public List<Card> getCardsList() {
        List<Card> list = new ArrayList<>();

        Cursor cursor = cargarCursor();

        while (cursor.moveToNext()) {
            Card card = new Card();
            card.setName(cursor.getString(1));
            card.setColor1(cursor.getString(2));

            list.add(card);
        }

        return list;
    }
}
