package com.example.recipereccom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class PreferenceActivity extends AppCompatActivity {

    private CheckBox cbVegetarian, cbVegan, cbGlutenFree;
    private Button btnSavePreferences;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        cbVegetarian = findViewById(R.id.cbVegetarian);
        cbVegan = findViewById(R.id.cbVegan);
        cbGlutenFree = findViewById(R.id.cbGlutenFree);
        btnSavePreferences = findViewById(R.id.btnSavePreferences);

        preferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);

        // Load and set saved preferences, if any
        cbVegetarian.setChecked(preferences.getBoolean("vegetarian", false));
        cbVegan.setChecked(preferences.getBoolean("vegan", false));
        cbGlutenFree.setChecked(preferences.getBoolean("gluten_free", false));

        btnSavePreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePreferences();
                Toast.makeText(PreferenceActivity.this, "Preferences saved", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PreferenceActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void savePreferences() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("vegetarian", cbVegetarian.isChecked());
        editor.putBoolean("vegan", cbVegan.isChecked());
        editor.putBoolean("gluten_free", cbGlutenFree.isChecked());
        editor.apply();
    }
}