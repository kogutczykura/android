package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private Button buttonLogin;
    private EditText Name;
    private EditText Password;
    private TextView Info;
   // private Integer counter;
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
        if((userName.equals("Agata")) && (userPassword.equals("ataga"))) {
            Intent intent = new Intent(Login.this, Logged.class);
            startActivity(intent);
        } else {
        //    counter--;

            Info.setText("Invalid login or password");
                buttonLogin.setEnabled(false);

        }
    }
}