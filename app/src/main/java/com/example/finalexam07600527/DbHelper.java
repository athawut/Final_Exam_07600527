package com.example.finalexam07600527;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String mdatabaseName = "account.sqLite";
    private static final int mdatabaseVersion = 1;
    Context mContext;



    private static final String tableCreateSQL = "CREATE TABLE account_table ("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "fullname TEXT,"+
            "username TEXT,"+
            "password TEXT"+
            ");";

    public DbHelper(@Nullable Context context) {
        super(context, mdatabaseName,null, mdatabaseVersion);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableCreateSQL);
        /*String insertData1 = "INSERT INTO account_table (fullname,username,password) VALUES ('testfull','testuser','testpassword');";
        db.execSQL(insertData1);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }


}
