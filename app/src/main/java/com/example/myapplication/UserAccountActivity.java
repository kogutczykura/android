package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.domain.Bike;
import com.example.myapplication.domain.User;
import com.example.myapplication.domain.UserService;
import com.example.myapplication.domain.UserServiceFactory;

import java.util.List;

public class UserAccountActivity extends AppCompatActivity {

    private Button logOutButton;
    private TextView userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        UserService userService = UserServiceFactory.getInstance(getApplicationContext());
        User user = userService.getCurrentlyLoginUser().get();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvContacts);
        BikesRecycleViewAdapter adapter = new BikesRecycleViewAdapter(user.getBikes(), this ,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        logOutButton = (Button) findViewById(R.id.logOutButton);
        userName = (TextView) findViewById(R.id.userName);
        userName.setText("User: " + userService.getCurrentlyLoginUser().get().getUsername());

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Intent intent = new Intent(UserAccountActivity.this, MainActivity.class);
                    UserService userService = UserServiceFactory.getInstance(getApplicationContext());
                    userService.setCurrentlyLoginUser(null);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                catch(Exception ex2)
                {
                    System.out.println("Not able to log out"+ex2.toString());
                }
            }
        });
    }
}