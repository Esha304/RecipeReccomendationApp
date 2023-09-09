package com.example.recipereccom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private EditText etSignupUsername, etSignupPassword;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etSignupUsername = findViewById(R.id.etSignupUsername);
        etSignupPassword = findViewById(R.id.etSignupPassword);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etSignupUsername.getText().toString();
                String password = etSignupPassword.getText().toString();

                // Perform signup logic here
                if (isValidSignupCredentials(username, password)) {
                    navigateToPreferenceChange();
                } else {
                    Toast.makeText(SignupActivity.this, "Signup failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidSignupCredentials(String username, String password) {
        // Placeholder: Implement your signup validation logic here
        // Replace with actual logic to validate signup information
        return true; // Return true if valid, false otherwise
    }

    private void navigateToPreferenceChange() {
        Intent intent = new Intent(SignupActivity.this, PreferenceActivity.class);
        startActivity(intent);
        finish();
    }
}