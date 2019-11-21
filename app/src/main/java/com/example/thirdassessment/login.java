package com.example.thirdassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    EditText usernametxt, passwordtxt;
    Button logbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernametxt = findViewById(R.id.username);
        passwordtxt = findViewById(R.id.password);
        logbtn = findViewById(R.id.logbtn);

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login() {

        String username = usernametxt.getText().toString();
        String password = passwordtxt.getText().toString();

        if (validate(username,password)){

            if (username.equals("softwarica") && password.equals("coventry")) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            } else {
                usernametxt.requestFocus();
                usernametxt.setError("username or password is incorrect");
            }

        }


    }


    private boolean validate(String usernametxt, String passwordtxt) {
        if (TextUtils.isEmpty(usernametxt)) {
            this.usernametxt.setError("Username shouldn't be empty");
            this.usernametxt.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(passwordtxt)) {
            this.passwordtxt.setError("Password shouldn't be empty");
            this.passwordtxt.requestFocus();
            return false;
        }

        return  true;
    }
}
