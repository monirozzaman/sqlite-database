package com.itvillage.dev.sqlite;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by monirozzamanroni on 8/30/2019.
 */

public class SQLiteDB {

   public static DatabaseHelper databaseHelper;

    public static void crateDb(Context context, String dbName, String tableName, ArrayList<String> columeName)
    {
        String DATABASE_NAME=dbName+".db";
        databaseHelper = new DatabaseHelper(context, DATABASE_NAME, tableName, columeName);

    }

    public static boolean push(ArrayList<String> values)
    {
        if (databaseHelper.insertDate(values)) {
            return true;
        } else {
            return false;
        }
    }

    public static Cursor show() {
        return databaseHelper.getData();
    }

    public static boolean update(String id, ArrayList<String> values) {
        if (databaseHelper.updateData(id, values)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean deleteById(String id) {
        if (databaseHelper.deleteData(id)) {
            return true;
        } else {
            return false;
        }
    }

    public static void delete() {
        databaseHelper.delete();
    }
}
