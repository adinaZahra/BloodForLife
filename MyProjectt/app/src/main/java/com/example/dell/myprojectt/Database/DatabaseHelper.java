package com.example.dell.myprojectt.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dell.myprojectt.Globals;

/**
 * Created by Bcsf14a043 on 1/25/2018.
 * using codes given by Sir Zain Aftab
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "doner_info";
    private static final String C_1 = "ID";
    private static final String C_2 = "name";
    private static final String C_3 = "email";
    private static final String C_4 = "phone";
    private static final String C_5 = "bloodgrp";

    public DatabaseHelper(Context context) {

        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "Create table " + TABLE_NAME
                + " ( "
                + C_1 + " INTEGER PRIMARY KEY AUTO_INCREMENT,"
                + C_2 + " TEXT, "
                + C_3 + " TEXT, "
                + C_4 + " TEXT, "
                + C_5 + " TEXT);";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("Drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * Adds data to database
     */
    public boolean add_data(String name, String email, String phone, String bloodgrp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cnv = new ContentValues();
        cnv.put(C_2, name);
        cnv.put(C_3, email);
        cnv.put(C_4, phone);
        cnv.put(C_5, bloodgrp);
        if (db.insert(TABLE_NAME, null, cnv) != -1){
            return true;}
        return false;
    }

}
