package com.example.pawner;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FamilyPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_picker);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the Up button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(""); // Remove the title
        }

        Button btnUnirse = findViewById(R.id.btnUnirse);
        Button btnCrear = findViewById(R.id.btnCrear);

        btnUnirse.setOnClickListener(v -> {
            Intent intent = new Intent(FamilyPickerActivity.this, JoinFamilyActivity.class);
            startActivity(intent);
        });

        btnCrear.setOnClickListener(v -> {
            Intent intent = new Intent(FamilyPickerActivity.this, CreateFamilyActivity.class);
            startActivity(intent);
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