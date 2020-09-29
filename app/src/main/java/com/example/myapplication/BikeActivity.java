package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.domain.Bike;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BikeActivity extends AppCompatActivity {

    List<Bike> bikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvContacts);

//        bikes = Bike.createBikeList();
        BikesRecycleViewAdapter adapter = new BikesRecycleViewAdapter(bikes, this,true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseDatabase.getInstance().getReference().child("bike").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Bike> bikes = new ArrayList<>();
                for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Bike bike = new Bike();
                    bike.setName(snapshot.child("name").getValue().toString());
                    bikes.add(bike);
                }

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvContacts);
                BikesRecycleViewAdapter bikesRecycleViewAdapter= new BikesRecycleViewAdapter(bikes, BikeActivity.this, true);
                recyclerView.setAdapter(bikesRecycleViewAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}