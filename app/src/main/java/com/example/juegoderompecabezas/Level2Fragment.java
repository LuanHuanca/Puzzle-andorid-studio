package com.example.juegoderompecabezas;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Level2Fragment extends Fragment {

    LevelsFragment levelsFragment;
    Button btnregresarL2;
    TextView tv1L2,tv2L2,tv3L2,tv4L2,tv5L2,tv6L2,tv7L2,tv8L2,tv9L2,tv10L2,
            tv11L2,tv12L2,tv13L2,tv14L2,tv15L2,tv16L2,tvmovimientosL2,tvporcentajeL2;
    int movementsL2=0;

    WinFragment winFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_level2, container, false);
        levelsFragment = new LevelsFragment();
        winFragment = new WinFragment();
        tv1L2=view.findViewById(R.id.tv1L2);
        tv2L2=view.findViewById(R.id.tv2L2);
        tv3L2=view.findViewById(R.id.tv3L2);
        tv4L2=view.findViewById(R.id.tv4L2);
        tv5L2=view.findViewById(R.id.tv5L2);
        tv6L2=view.findViewById(R.id.tv6L2);
        tv7L2=view.findViewById(R.id.tv7L2);
        tv8L2=view.findViewById(R.id.tv8L2);
        tv9L2=view.findViewById(R.id.tv9L2);
        tv10L2=view.findViewById(R.id.tv10L2);
        tv11L2=view.findViewById(R.id.tv11L2);
        tv12L2=view.findViewById(R.id.tv12L2);
        tv13L2=view.findViewById(R.id.tv13L2);
        tv14L2=view.findViewById(R.id.tv14L2);
        tv15L2=view.findViewById(R.id.tv15L2);
        tv16L2=view.findViewById(R.id.tv16L2);
        tvmovimientosL2 = view.findViewById(R.id.tvMovimientosL2);
        btnregresarL2 = view.findViewById(R.id.btnRegresarL2);
        tvporcentajeL2 = view.findViewById(R.id.tvPorcentajeL2);
        mezclar();

        btnregresarL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,levelsFragment).commit();
            }
        });
        tv1L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv1L2,tv2L2,tv5L2);
                ganaste();
            }
        });
        tv2L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv2L2,tv1L2,tv3L2,tv6L2);
                ganaste();
            }
        });
        tv3L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv3L2,tv2L2,tv4L2,tv7L2);
                ganaste();
            }
        });
        tv4L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv4L2,tv3L2,tv8L2);
                ganaste();
            }
        });
        tv5L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv5L2,tv1L2,tv6L2,tv9L2);
                ganaste();
            }
        });
        tv6L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv6L2,tv2L2,tv5L2,tv10L2,tv7L2);
                ganaste();
            }
        });
        tv7L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv7L2,tv3L2,tv6L2,tv8L2,tv11L2);
                ganaste();
            }
        });
        tv8L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv8L2,tv12L2,tv4L2,tv7L2);
                ganaste();
            }
        });
        tv9L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv9L2,tv5L2,tv10L2,tv13L2);
                ganaste();
            }
        });
        tv10L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv10L2,tv6L2,tv9L2,tv11L2,tv14L2);
                ganaste();
            }
        });
        tv11L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv11L2,tv7L2,tv10L2,tv12L2,tv15L2);
                ganaste();
            }
        });
        tv12L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv12L2,tv8L2,tv16L2,tv11L2);
                ganaste();
            }
        });
        tv13L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv13L2,tv9L2,tv14L2);
                ganaste();
            }
        });
        tv14L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv14L2,tv10L2,tv13L2,tv15L2);
                ganaste();
            }
        });
        tv15L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv15L2,tv11L2,tv14L2,tv16L2);
                ganaste();
            }
        });
        tv16L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv16L2,tv12L2,tv15L2);
                ganaste();
            }
        });

        return view;
    }
    private void exchange(TextView textView1, TextView textView2) {
        String text1 = textView1.getText().toString();
        Drawable background1 = textView1.getBackground();

        textView1.setText(textView2.getText().toString());
        textView1.setBackground(textView2.getBackground());

        textView2.setText(text1);
        textView2.setBackground(background1);
    }
    private void findEmptyAndExchange(TextView original, TextView... textViews) {
        for (TextView textView : textViews) {
            String text = textView.getText().toString();
            if (text.equals("")) {
                exchange(original, textView);
                movementsL2++;
                tvmovimientosL2.setText("Movimientos: "+ movementsL2 );
                return; // Terminar la función si se realiza un intercambio
            }
        }
        Toast.makeText(getActivity(), "No es posible el cambio", Toast.LENGTH_SHORT).show();
    }
    private void mezclar() {
        int longitud = 16; // longitud del vector
        int[] aleatorio = new int[longitud];
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            int numerorandom;
            boolean duplicado;
            do {
                numerorandom = random.nextInt(16) + 1;
                duplicado = false;
                for (int j = 0; j < i; j++) {
                    if (aleatorio[j] == numerorandom) {
                        duplicado = true;
                        break;
                    }
                }
            } while (duplicado);
            aleatorio[i] = numerorandom;
        }
        TextView[] textViews = {tv1L2,tv2L2,tv3L2,tv4L2,tv5L2,tv6L2,tv7L2,tv8L2,tv9L2,tv10L2,
                tv11L2,tv12L2,tv13L2,tv14L2,tv15L2,tv16L2};
        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setText(String.valueOf(aleatorio[i]));
            if (textViews[i].getText().toString().equals("16")) {
                textViews[i].setText("");
                textViews[i].setBackgroundColor(Color.parseColor("#004CAF50"));
            }
        }
    }
    private void ganaste(){
        TextView[] textViews = {tv1L2,tv2L2,tv3L2,tv4L2,tv5L2,tv6L2,tv7L2,tv8L2,tv9L2,tv10L2,
                tv11L2,tv12L2,tv13L2,tv14L2,tv15L2,tv16L2};
        String [] cadena_correcta = {"1","2","3","4","5",
                                    "6","7","8","9","10",
                                    "11","12","13","14","15",""};
        int aciertos=0;
        for (int i = 0; i < textViews.length; i++) {
            if (textViews[i].getText().toString().equals(cadena_correcta[i])) {
                aciertos++;
            }
        }
        if (aciertos == 16) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, winFragment).commit();
        } else {
            int porcentaje = (aciertos * 100) / 16;
            tvporcentajeL2.setText("Porcentaje: " + porcentaje + "%");
        }
    }
}