package com.example.juegoderompecabezas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    LevelsFragment levelsFragment;
    static EditText etnombre;
    Button btniniciar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        levelsFragment = new LevelsFragment();
        btniniciar = view.findViewById(R.id.btIniciar);
        etnombre = view.findViewById(R.id.etName);

        btniniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etnombre.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Debe introducir su Nombre", Toast.LENGTH_SHORT).show();

                }else{
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,levelsFragment).commit();
                }
            }
        });

        return view;
    }
}