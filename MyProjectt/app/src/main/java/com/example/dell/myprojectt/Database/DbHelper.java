package com.example.dell.myprojectt.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dell on 1/25/2018.
 * By taking Help from Codes Uploaded by Sir Zain Aftab
 */
public class DbHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "Doner";
    public static final String C_1 = "ID";
    public static final String C_2 = "name";
    public static final String C_3 = "email";
    public static final String C_4 = "phone";
    public static final String C_5 = "bloodgrp";

    private static final String DATABASE_NAME = "BloodOrg.db";
    public static final String TYPE_INT =" INT ";
    public static final String TYPE_TEXT =" TEXT ";
    public static final String SEPERATOR =", ";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_query = "Create table " + TABLE_NAME + " ("
                + C_1 + TYPE_INT + " AUTO_INCREMENT PRIMARY KEY " + SEPERATOR
                + C_2 + TYPE_TEXT + SEPERATOR
                + C_3 + TYPE_TEXT + SEPERATOR
                + C_4 + TYPE_TEXT + SEPERATOR
                + C_5 + TYPE_TEXT + ");";
        db.execSQL(create_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        String drp_query = "drop database if exists " + DATABASE_NAME;
        db.execSQL(drp_query);
        onCreate(db);
    }
    /**
     *  Data entry in database
     */
    public long insert(String name, String email, String phone, String bloodgrp ) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(C_2, name);
        cv.put(C_3, email);
        cv.put(C_4, phone);
        cv.put(C_5, bloodgrp);
        long r = db.insert(TABLE_NAME, null, cv);
        Log.d("Database_helper", String.valueOf(r));
        db.close();
        return r;
    }
    public Cursor read(long id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cr = db.query(TABLE_NAME, new String[]{C_1, C_2}, null, null, null, null, null);
        return cr;
    }

}
