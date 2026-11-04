package com.example.turystyka;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

   int licznik = 0;
    Button przycisk_polub, przycisk_usun, przycisk_zapisz, przycisk_umow, przycisk_o_nas;
    TextView polubienia;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        przycisk_polub = findViewById(R.id.przycisk_polub);
        przycisk_usun = findViewById(R.id.przycisk_usun);
        przycisk_zapisz = findViewById(R.id.przycisk_zapisz);
        przycisk_umow = findViewById(R.id.przycisk_umow);
        przycisk_o_nas = findViewById(R.id.przycisk_o_nas);
        polubienia = findViewById(R.id.polubienia);

        sharedPreferences = getSharedPreferences("ustawienia", Context.MODE_PRIVATE);
        licznik = sharedPreferences.getInt("polubienia", 0);
        polubienia.setText(licznik + " polubień");

        przycisk_polub.setOnClickListener(v -> {
            licznik++;
            polubienia.setText(licznik + " polubień");
        });
        przycisk_usun.setOnClickListener(v -> {
            if (licznik > 0){
                licznik--;
                polubienia.setText(licznik + " polubień");
            }
        });

        przycisk_zapisz.setOnClickListener(v -> {
            saveLikes();
        });

        przycisk_umow.setOnClickListener(v -> {
            startActivity(new Intent(this, druga.class));
        });

        przycisk_o_nas.setOnClickListener(v -> {
            startActivity(new Intent(this, trzecia.class));
        });
    }

    /***Zapisuje liczbę polubień do SharedPreferences.
     *Wyświetla komunikat Toast oznajmiający o pomyślnym zapisie
     * @author Jakub Olszewski
     */
    private void saveLikes(){
        SharedPreferences.Editor edytor = sharedPreferences.edit();
        edytor.putInt("polubienia", licznik);
        edytor.apply();
        Toast.makeText(this, "Zapisano liczbę polubień", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        saveLikes();
        Log.d("onpause", "onpause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        saveLikes();
        Log.d("ondestroy", "ondestroy");
    }

}