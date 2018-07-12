package com.project.alex.reciclabcn.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.project.alex.reciclabcn.Card;
import com.project.alex.reciclabcn.Material;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by alexbruch on 14/2/17.
 */

public class ItemsDatasource extends DataBaseManager{

    public static final String CONTENIDORS_TABLE_NAME = "Contenidors";
    public static final String MATERIALS_TABLE_NAME4 = "Materials";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    /** CONTENIDORS **/

    public static class ColumnContenidors {
        public static final String CONTENIDOR_ID = "_id";
        public static final String CONTENIDOR_NAME = "name";
        public static final String CONTENIDOR_COLOR_1 = "color1";
        public static final String CONTENIDOR_COLOR_2 = "color2";
        public static final String CONTENIDOR_THUMBNAIL = "thumbnail";
    }

    public static final String CREATE_CONTENIDORS_SCRIPT =
            "create table " + CONTENIDORS_TABLE_NAME + "(" +
                    ColumnContenidors.CONTENIDOR_ID + " " + INT_TYPE + " primary key autoincrement, "+
                    ColumnContenidors.CONTENIDOR_NAME + " " + STRING_TYPE + " not null, " +
                    ColumnContenidors.CONTENIDOR_COLOR_1 + " " + STRING_TYPE + " not null, " +
                    ColumnContenidors.CONTENIDOR_COLOR_2 + " " + STRING_TYPE + " not null, " +
                    ColumnContenidors.CONTENIDOR_THUMBNAIL + " " + STRING_TYPE + " not null);";

    /** MATERIALS **/

    public static class ColumnMaterials {
        public static final String MATERIAL_ID = "_id";
        public static final String MATERIAL_NAME = "name";
        public static final String MATERIAL_THUMBNAIL = "thumbnail";
        public static final String MATERIAL_CONTENIDOR = "contenidor";
        public static final String MATERIAL_CUBO = "cubo";
        public static final String MATERIAL_COLOR1 = "color1";
        public static final String MATERIAL_COLOR2 = "color2";
        public static final String MATERIAL_LOCA = "loca";
        public static final String MATERIAL_DESC = "desc";
    }

    public static final String CREATE_MATERIALS_SCRIPT =
            "create table " + MATERIALS_TABLE_NAME4 + "(" +
                    ColumnMaterials.MATERIAL_ID + " " + INT_TYPE + " primary key autoincrement, "+
                    ColumnMaterials.MATERIAL_NAME + " " + STRING_TYPE + " not null, " +
                    ColumnMaterials.MATERIAL_THUMBNAIL + " " + STRING_TYPE + " not null, " +
                    ColumnMaterials.MATERIAL_CONTENIDOR + " " + STRING_TYPE + " not null, " +
                    ColumnMaterials.MATERIAL_CUBO + " " + STRING_TYPE + " not null, " +
                    ColumnMaterials.MATERIAL_COLOR1 + " " + STRING_TYPE + " not null, " +
                    ColumnMaterials.MATERIAL_COLOR2 + " " + STRING_TYPE + " not null, " +
                    ColumnMaterials.MATERIAL_LOCA + " " + STRING_TYPE + " not null, " +
                    ColumnMaterials.MATERIAL_DESC + " " + STRING_TYPE + " not null);";

    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public ItemsDatasource(Context context) {
        super(context);
        dbHelper = new DBHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    @Override
    public void closeDB() {
        super.getSqLiteDatabase().close();
    }

    /** CREAR TAULA CONTENIDORS **/
    public void saveContenidors( String contenidor_name, String color1, String color2, String thumbnail) {
        ContentValues values = new ContentValues();

        values.put(ColumnContenidors.CONTENIDOR_NAME, contenidor_name);
        values.put(ColumnContenidors.CONTENIDOR_COLOR_1, color1);
        values.put(ColumnContenidors.CONTENIDOR_COLOR_2, color2);
        values.put(ColumnContenidors.CONTENIDOR_THUMBNAIL, thumbnail);

        sqLiteDatabase.insert(CONTENIDORS_TABLE_NAME, null, values);
    }

    /** CREAR TAULA MATERIALS **/
    public void saveMaterials(String material_name, String thumbnail, String contenidor, String cubo, String mcolor1, String mcolor2, String loca, String desc) {
        ContentValues values = new ContentValues();

        values.put(ColumnMaterials.MATERIAL_NAME, material_name);
        values.put(ColumnMaterials.MATERIAL_THUMBNAIL, thumbnail);
        values.put(ColumnMaterials.MATERIAL_CONTENIDOR, contenidor);
        values.put(ColumnMaterials.MATERIAL_CUBO, cubo);
        values.put(ColumnMaterials.MATERIAL_COLOR1, mcolor1);
        values.put(ColumnMaterials.MATERIAL_COLOR2, mcolor2);
        values.put(ColumnMaterials.MATERIAL_LOCA, loca);
        values.put(ColumnMaterials.MATERIAL_DESC, desc);

        sqLiteDatabase.insert(MATERIALS_TABLE_NAME4, null, values);
    }

    public void cleanDB() {
        sqLiteDatabase.delete(CONTENIDORS_TABLE_NAME, null, null);
        sqLiteDatabase.delete(MATERIALS_TABLE_NAME4, null, null);
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

    @Override
    public Cursor cargarCursorM(String contenidor) {
        String[] columns = new String[]{
                ColumnMaterials.MATERIAL_ID,
                ColumnMaterials.MATERIAL_NAME,
                ColumnMaterials.MATERIAL_THUMBNAIL,
                ColumnMaterials.MATERIAL_CONTENIDOR,
                ColumnMaterials.MATERIAL_CUBO,
                ColumnMaterials.MATERIAL_COLOR1,
                ColumnMaterials.MATERIAL_COLOR2,
                ColumnMaterials.MATERIAL_LOCA,
                ColumnMaterials.MATERIAL_DESC};

        return super.getSqLiteDatabase().query(MATERIALS_TABLE_NAME4, columns, ColumnMaterials.MATERIAL_CONTENIDOR + "=" +"'" + contenidor + "'" , null, null, null, null);
    }

    @Override
    public Cursor cargarCursorMD(String material) {
        String[] columns = new String[]{
                ColumnMaterials.MATERIAL_ID,
                ColumnMaterials.MATERIAL_NAME,
                ColumnMaterials.MATERIAL_THUMBNAIL,
                ColumnMaterials.MATERIAL_CONTENIDOR,
                ColumnMaterials.MATERIAL_CUBO,
                ColumnMaterials.MATERIAL_COLOR1,
                ColumnMaterials.MATERIAL_COLOR2,
                ColumnMaterials.MATERIAL_LOCA,
                ColumnMaterials.MATERIAL_DESC};

        return super.getSqLiteDatabase().query(MATERIALS_TABLE_NAME4, columns, ColumnMaterials.MATERIAL_NAME + "=" +"'" + material + "'" , null, null, null, null);
    }


    /** CARREGAR CONTENIDORS A LLISTA PER CARREGARLOS A RECYCLERVIEW **/

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

    /** CARREGAR MATERIALS A LLISTA PER CARREGARLOS A RECYCLERVIEW **/

    public List<Material> getMaterialsList(String contenidor) {
        List<Material> list = new ArrayList<>();

        Cursor cursor = cargarCursorM(contenidor);

        while (cursor.moveToNext()) {
            Material material = new Material();
            material.setMaterial(cursor.getString(1));
            material.setThumbnail(cursor.getString(2));
            material.setContenidor(cursor.getString(3));
            material.setCubo(cursor.getString(4));
            material.setColor1(cursor.getString(5));
            material.setColor2(cursor.getString(6));
            material.setLocalitzacio(cursor.getString(7));
            material.setDescription(cursor.getString(8));

            list.add(material);
        }
        return list;
    }

    /** CARREGAR DETALLS MATERIAL A LLISTA PER CARREGARLOS A RECYCLERVIEW **/

    public List<Material> getDetallMaterial(String material) {
        List<Material> list = new ArrayList<>();

        Cursor cursor = cargarCursorMD(material);

        while (cursor.moveToNext()) {
            Material material1 = new Material();
            material1.setMaterial(cursor.getString(1));
            material1.setThumbnail(cursor.getString(2));
            material1.setContenidor(cursor.getString(3));
            material1.setCubo(cursor.getString(4));
            material1.setColor1(cursor.getString(5));
            material1.setColor2(cursor.getString(6));
            material1.setLocalitzacio(cursor.getString(7));
            material1.setDescription(cursor.getString(8));

            list.add(material1);
        }
        return list;
    }
}
