package com.example.juegoderompecabezas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class WinFragment extends Fragment {


    EasyFragment easyFragment;
    LevelsFragment levelsFragment;

    Level2Fragment level2Fragment;

    Button btnjugardenuevo,btnelegirnuevonivel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_win, container, false);
        easyFragment = new EasyFragment();
        levelsFragment = new LevelsFragment();
        level2Fragment = new Level2Fragment();
        btnelegirnuevonivel = view.findViewById(R.id.btnElegirNuevoNivel);
        btnjugardenuevo = view.findViewById(R.id.btnJugarDeNuevo);

        String level=LevelsFragment.level + "";

        btnjugardenuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (level.equals("nivel1")){
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,easyFragment).commit();
                    }else {
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,level2Fragment).commit();
                    }

            }
        });

        btnelegirnuevonivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,levelsFragment).commit();
            }
        });

        return view;
    }
}