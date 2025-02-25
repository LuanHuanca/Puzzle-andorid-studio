package com.example.juegoderompecabezas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LevelsFragment extends Fragment {

    Button btnnivel1,btnnivel2;
    TextView tvusuario;
    EasyFragment easyFragment;
    Level2Fragment level2Fragment;
    static String level;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_levels, container, false);

        easyFragment = new EasyFragment();
        level2Fragment = new Level2Fragment();

        btnnivel1 = view.findViewById(R.id.btnNivel1);
        btnnivel2 = view.findViewById(R.id.btnNivel2);
        tvusuario= view.findViewById(R.id.tvUsuario);

        tvusuario.setText("Bienvenido  " + HomeFragment.etnombre.getText().toString());

        btnnivel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,easyFragment).commit();
                level = "nivel1";
            }
        });
        btnnivel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,level2Fragment).commit();
                level = "nivel2";
            }
        });
        return view;
    }

}