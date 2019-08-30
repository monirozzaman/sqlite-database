package com.itvillage.dev.sqlite;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by monirozzamanroni on 8/30/2019.
 */

public class SQLiteDB {

   public static DatabaseHelper databaseHelper;
    public  static void   crateDb(Context context, String dbName, ArrayList<String> columeName)
    {
        String DATABASE_NAME=dbName+".db";
        databaseHelper=new DatabaseHelper(context,DATABASE_NAME,columeName);

    }
    public  static void  push(ArrayList<String> values)
    {
        databaseHelper.insertDate(values);
    }
}
