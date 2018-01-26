package com.example.dell.myprojectt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.dell.myprojectt.Database.DbHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DbHelper DB_Helper;
    EditText et_name, et_email, et_phone ,et_bldgrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB_Helper = new DbHelper(this);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_bldgrp = (EditText) findViewById(R.id.et_bldgrp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                long rid = DB_Helper.insert(et_name.getText().toString(), et_email.getText().toString(), et_phone.getText().toString(),  et_bldgrp.getText().toString() );
                Intent in = new Intent(this, Activity_2.class);
                in.putExtra("name", et_name.getText().toString());
                in.putExtra("phone", et_phone.getText().toString());
                in.putExtra("bldgrp", et_bldgrp.getText().toString());
                startActivity(in);

             //   Cursor b = DB_Helper.read(rid);
             //   String[] rows = new String[b.getCount()];
             //   while (b.moveToNext()) {
              //      rows[b.getPosition()] = "ID: " + b.getInt(b.getColumnIndex(DbHelper.C_1))
             //               + "\n" + "NAME: " + b.getString(b.getColumnIndex(DbHelper.C_2));
               // }
             //   b.close();
             //   break;

            // Redirecting to the new page
            case R.id.btn_list:
                Intent inn = new Intent(this, Activity_2.class);
                inn.putExtra("name", et_name.getText().toString());
                inn.putExtra("phone", et_phone.getText().toString());
                inn.putExtra("bldgrp", et_bldgrp.getText().toString());
                startActivity(inn);
        }

    }
}

