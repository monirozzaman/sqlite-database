package com.itvillage.dev.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;



public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "information_table";
    ArrayList<String> columeNames;

    public DatabaseHelper(Context context, String DATABASE_NAME, ArrayList<String> columeNames) {
        super(context, DATABASE_NAME, null, 1);
        this.columeNames =columeNames;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="ID INTEGER PRIMARY KEY AUTOINCREMENT";
        for (String s : columeNames) {
            query = query + ","+s+" VARCHAR";
        }
       db.execSQL( "CREATE TABLE information_table("+query+");");
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

   /* public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String name, String age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, age);
        db.update(TABLE_NAME, contentValues, "ID=?", new String[]{id});
        return true;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID=?", new String[]{id});
    }*/
}
