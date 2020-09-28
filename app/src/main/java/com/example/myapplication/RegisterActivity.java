package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.domain.User;
import com.example.myapplication.domain.UserService;
import com.example.myapplication.domain.UserServiceFactory;

public class RegisterActivity extends AppCompatActivity {

    private Button registerButton;
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerButton = (Button) findViewById(R.id.registerButton);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        registerButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  saveNewUser(username.getText().toString(), password.getText().toString());
              }
        });
    }

    private void saveNewUser(String userName, String userPassword) {
        if(userName.isEmpty() || userName.isEmpty() ) {
            Toast.makeText(this, "Username and password cannot be empty", Toast.LENGTH_LONG).show();
            return;
        }
        Context context = this.getApplicationContext();
        User user = new User(userName, userPassword);
        UserService userService = UserServiceFactory.getInstance(context);
        userService.saveUser(user);
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}

