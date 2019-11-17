package com.example.finalexam07600527;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class AccountDAO {
    private SQLiteDatabase mdatabase;
    private DbHelper mdbHelper;

    public AccountDAO(Context context) {

        mdbHelper = new DbHelper(context);
    }

    public void open(){
        mdatabase = mdbHelper.getWritableDatabase();
    }

    public void close(){
        mdbHelper.close();
    }

    public ArrayList<Account> getAllAccount(){
        ArrayList<Account> account = new ArrayList<Account>();
        Cursor cursor = mdatabase.rawQuery("SELECT * FROM account_table",null);
        cursor.moveToFirst();
        Account account1;
        while (!cursor.isAfterLast()){
            account1 = new Account();
            account1.setId(cursor.getInt(0));
            account1.setFullname(cursor.getString(1));
            account1.setUsername(cursor.getString(2));
            account1.setPassword(cursor.getString(3));
            account.add(account1);
            cursor.moveToNext();
        }
        cursor.close();
        return account;
    }

    public ArrayList<String> getAllUsername(){
        ArrayList<String> username = new ArrayList<String>();
        Cursor cursor = mdatabase.rawQuery("SELECT * FROM account_table",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            username.add(cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
        return username;
    }

    public void add(String fullname,String username,String password){
        Account account = new Account();
        ContentValues values = new ContentValues();
        values.put("fullname",fullname);
        values.put("username",username);
        values.put("password",password);

        this.mdatabase.insert("account_table",null,values);

        /*String insertData1 = "INSERT INTO account_table (fullname,username,password) VALUES (fullname,username,password);";
        mdatabase.execSQL(insertData1);*/
    }
}
