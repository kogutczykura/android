package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Logged extends AppCompatActivity {

    private ImageButton maps;
    private ImageButton bike;
    private ImageButton person;
    private ImageButton docs;
    private ImageButton settings;
    private ImageButton info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        maps = (ImageButton) findViewById(R.id.maps);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Logged.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        bike = (ImageButton) findViewById(R.id.bike);
        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Logged.this, Bike.class);
                startActivity(intent);
            }
        });
        person = (ImageButton) findViewById(R.id.person);
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Logged.this, Person.class);
                startActivity(intent);
            }
        });
        docs = (ImageButton) findViewById(R.id.docs);
        docs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Logged.this, Docs.class);
                startActivity(intent);
            }
        });
        settings = (ImageButton) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Logged.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
        info = (ImageButton) findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Logged.this, Info.class);
                startActivity(intent);
            }
        });

    }
}