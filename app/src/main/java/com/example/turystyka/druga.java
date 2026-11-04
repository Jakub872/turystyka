package com.example.turystyka;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class druga extends AppCompatActivity {

    EditText wiadomosc, imie_nazwisko, ulica, miasto, email;
    Button przycisk_wyslij, przycisk_powrot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_druga);

        wiadomosc = findViewById(R.id.wiadomosc);
        imie_nazwisko = findViewById(R.id.imie_nazwisko);
        ulica = findViewById(R.id.ulica);
        miasto = findViewById(R.id.miasto);
        email = findViewById(R.id.email);
        przycisk_wyslij = findViewById(R.id.przycisk_wyslij);
        przycisk_powrot = findViewById(R.id.przycisk_powrot);

        przycisk_wyslij.setOnClickListener(v -> {
            Toast.makeText(this, "Zapytanie zostało wysłane. Oczekuj na kontakt!", Toast.LENGTH_LONG).show();
        });

        przycisk_powrot.setOnClickListener(v -> {
            finish();
        });
    }
}