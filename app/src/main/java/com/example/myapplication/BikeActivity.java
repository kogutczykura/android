package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.domain.Bike;

import java.util.ArrayList;
import java.util.List;

public class BikeActivity extends AppCompatActivity {

    List<Bike> bikes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvContacts);

        bikes = Bike.createBikeList();
        BikesRecycleViewAdapter adapter = new BikesRecycleViewAdapter(bikes, this,true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}