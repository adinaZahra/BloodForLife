package com.example.dell.myprojectt;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

/**
 * Created by Dell on 1/26/2018.
 */
public class Activity_2 extends AppCompatActivity {
    private TextView name;
    private TextView phone;
    private TextView bloodgrp;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_2);

        name = (TextView) findViewById(R.id.name);
        phone = (TextView) findViewById(R.id.phone);
        bloodgrp = (TextView) findViewById(R.id.bldgrp);

        String name1 = getIntent().getStringExtra("name");
        String phone1 = getIntent().getStringExtra("phone");
        String bloodgrp1 = getIntent().getStringExtra("bldgrp");

        name.setText(name1);
        phone.setText(phone1);
        bloodgrp.setText(bloodgrp1);


    }

}
