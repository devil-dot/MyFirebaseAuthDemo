package com.kmtstudio.myfirebaseauthdemo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText signInEmail, signInPassword;
    private TextView signUpTextView;
    private Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Setting the title bar name
        this.setTitle("Sign in activity");

        signInEmail = findViewById(R.id.signInEmailTxtID);
        signInPassword = findViewById(R.id.signInPasswordTxtID);

        signUpTextView = findViewById(R.id.signUpTextId);

        signInBtn = findViewById(R.id.signInBtn);


        signInBtn.setOnClickListener(this);
        signUpTextView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.signInBtn) {

            //Sign In with email password

        } else if (v.getId()==R.id.signUpTextId) {

            Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
            startActivity(intent);

        }
    }
}