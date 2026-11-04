package com.example.turystyka;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class trzecia extends AppCompatActivity {

    Button przycisk_powrot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trzecia);

        przycisk_powrot = findViewById(R.id.przycisk_powrot);
        przycisk_powrot.setOnClickListener(v -> {
            finish();
        });
    }
}