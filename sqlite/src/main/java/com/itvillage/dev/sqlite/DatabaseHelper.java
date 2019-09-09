package com.itvillage.dev.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;



public class DatabaseHelper extends SQLiteOpenHelper {

    String TABLE_NAME;
    ArrayList<String> columeNames;

    public DatabaseHelper(Context context, String DATABASE_NAME, String TABLE_NAME, ArrayList<String> columeNames) {
        super(context, DATABASE_NAME, null, 1);
        this.columeNames =columeNames;
        this.TABLE_NAME = TABLE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="ID INTEGER PRIMARY KEY AUTOINCREMENT";
        for (String s : columeNames) {
            query = query + ","+s+" VARCHAR";
        }
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + query + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertDate(ArrayList<String> values) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for(int i=0;i<columeNames.size();i++)
        {
            contentValues.put(columeNames.get(i),values.get(i));
        }
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else
            return true;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, ArrayList<String> values) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < columeNames.size(); i++) {
            contentValues.put(columeNames.get(i), values.get(i));
        }
        db.update(TABLE_NAME, contentValues, "ID=?", new String[]{id});
        return true;
    }

    public boolean deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Integer result = db.delete(TABLE_NAME, "ID=?", new String[]{id});
        if (result == -1) {
            return false;
        } else
            return true;
    }

    public void delete() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM" + TABLE_NAME);
    }
}
