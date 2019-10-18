package com.itvillage.dev.sqlite;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by monirozzamanroni on 8/30/2019.
 */

public class SQLiteDB {

    public static DatabaseHelper databaseHelper;

    public static void createDatabase(Context context, String databaseName) {
        String DATABASE_NAME = databaseName + ".db";
        databaseHelper = new DatabaseHelper(context, DATABASE_NAME);

    }
    /**
     * This method is used to create table.
     *
     * @param tableName  This is tableName name what you want
     * @param columnName This list is a column name list  whatever you want
     * @return int This returns average of numA, numB and numC.
     */

    public static void createTable(String tableName, ArrayList<String> columnName) {

        databaseHelper.createTable(tableName, columnName);
    }

    public static boolean insert(String tableName, ArrayList<String> values) {
        if (databaseHelper.insertDate(tableName, values)) {
            return true;
        } else {
            return false;
        }
    }

    public static Cursor findAll(String tableName) {
        return databaseHelper.getData(tableName);
    }

    public static Cursor findById(String tableName, String id) {
        return databaseHelper.getDataById(tableName, id);
    }

    public static boolean updateRowById(String tableName, String id, ArrayList<String> values) {
        if (databaseHelper.updateData(tableName, id, values)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean deleteRowById(String tableName, String id) {
        if (databaseHelper.deleteData(tableName, id)) {
            return true;
        } else {
            return false;
        }
    }

    public static void dropTable(String tableName) {
        databaseHelper.dropTable(tableName);
    }


}
