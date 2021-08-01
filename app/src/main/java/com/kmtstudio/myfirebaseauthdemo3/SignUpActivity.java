package com.kmtstudio.myfirebaseauthdemo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText signUpEmail, signUpPassword;
    private TextView signInTextView;
    private Button signUpBtn;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //Setting the title bar name
        this.setTitle("Sign up activity");


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        progressBar = findViewById(R.id.progressBarID);

        signUpEmail = findViewById(R.id.signUpEmailTxtID);
        signUpPassword = findViewById(R.id.signUpPasswordTxtID);

        signInTextView = findViewById(R.id.signInTextId);

        signUpBtn = findViewById(R.id.signUpBtn);


        signUpBtn.setOnClickListener(this);
        signInTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.signUpBtn) {

            userRegister();

        } else if (v.getId() == R.id.signInTextId) {

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

        }
    }

    private void userRegister() {

        String email = signUpEmail.getText().toString().trim();
        String password = signUpPassword.getText().toString().trim();

        //Checking the validity of email
        if (email.isEmpty()) {

            signUpEmail.setError("Please enter an email address");
            signUpEmail.requestFocus();

        }


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

            signUpEmail.setError("Please enter a valid email address");
            signUpEmail.requestFocus();

        }


        //Checking the validity of password
        if (password.isEmpty()) {

            signUpPassword.setError("Please enter password");
            signUpPassword.requestFocus();

        }

        if (password.length() < 6) {

            signUpPassword.setError("Minimum length of password should be 6");
            signUpPassword.requestFocus();

        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {

            progressBar.setVisibility(View.GONE);
            if (task.isSuccessful()) {

                signUpEmail.setText("");
                signUpPassword.setText("");

                Toast.makeText(getApplicationContext(),"Registration successful",Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(getApplicationContext(),"Registration is not successful",Toast.LENGTH_SHORT).show();
            }

        });

    }
}