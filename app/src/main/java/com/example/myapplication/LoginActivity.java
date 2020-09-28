package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.domain.User;
import com.example.myapplication.domain.UserService;
import com.example.myapplication.domain.UserServiceFactory;

import java.util.Optional;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    private EditText Name;
    private EditText Password;
    private TextView Info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText) findViewById(R.id.editTextTextPersonName);
        Password = (EditText) findViewById(R.id.editTextTextPassword);
        Info = (TextView) findViewById(R.id.valid);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword) {
        UserService userService = UserServiceFactory.getInstance(getApplicationContext());
        Optional<User> user = userService.findByIdAndPassword(userName, userPassword);
        if(user.isPresent()) {
            userService.setCurrentlyLoginUser(user.get());
            Intent intent = new Intent(LoginActivity.this, LoggedActivity.class);
            startActivity(intent);
        } else {
            Info.setText("Invalid login or password");
            buttonLogin.setEnabled(false);
        }
    }
}