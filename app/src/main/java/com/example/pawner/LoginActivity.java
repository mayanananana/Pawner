package com.example.pawner;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the Up button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(""); // Remove the title
        }

        TextView signUpBtn= findViewById(R.id.tvRegistro);
        signUpBtn.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        Button loginBtn= findViewById(R.id.btnLogin);
        loginBtn.setOnClickListener(v->{
            Intent intentLogin= new Intent(LoginActivity.this, FamilyPickerActivity.class);
            startActivity(intentLogin
            );
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to previous one
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}