package com.example.juegoderompecabezas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    TextView tvappbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        tvappbar = findViewById(R.id.tvAppbar);
        getSupportFragmentManager().beginTransaction().add(R.id.flContainer, homeFragment).commit();
    }
}