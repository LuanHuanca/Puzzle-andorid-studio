package com.example.juegoderompecabezas;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EasyFragment extends Fragment {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tvmovimientos,tvporcentaje;
    Button btnregresar;
    int movements = 0;

    LevelsFragment levelsFragment;
    WinFragment winFragment;

    MediaPlayer incorrecto,correcto;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_easy, container, false);
        tv1 = view.findViewById(R.id.tv1);
        tv2 = view.findViewById(R.id.tv2);
        tv3 = view.findViewById(R.id.tv3);
        tv4 = view.findViewById(R.id.tv4);
        tv5 = view.findViewById(R.id.tv5);
        tv6 = view.findViewById(R.id.tv6);
        tv7 = view.findViewById(R.id.tv7);
        tv8 = view.findViewById(R.id.tv8);
        tv9 = view.findViewById(R.id.tv9);
        levelsFragment = new LevelsFragment();
        tvmovimientos = view.findViewById(R.id.tvMovimientos);
        btnregresar = view.findViewById(R.id.btnRegresar);
        incorrecto = MediaPlayer.create(getContext(),R.raw.incorrect);
        correcto = MediaPlayer.create(getContext(),R.raw.correct);
        winFragment = new WinFragment();
        tvporcentaje = view.findViewById(R.id.tvPorcentaje);
        mezclar();

        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,levelsFragment).commit();
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv1,tv2,tv4);
                ganaste();
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv2,tv1,tv3,tv5);
                ganaste();
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv3,tv2,tv6);
                ganaste();
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv4,tv1,tv5,tv7);
                ganaste();
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv5,tv2,tv4,tv6,tv8);
                ganaste();
            }
        });
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv6,tv3,tv5,tv9);
                ganaste();
            }
        });
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv7,tv4,tv8);
                ganaste();
            }
        });
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv8,tv7,tv5,tv9);
                ganaste();
            }
        });
        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findEmptyAndExchange(tv9,tv6,tv8);
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
    private void find2Empty(TextView original,TextView textView1, TextView textView2){
        String texto1 = textView1.getText().toString();
        String texto2= textView2.getText().toString();
        if(texto1.equals("")){
            exchange(original,textView1);
        }else if(texto2.equals("")){
            exchange(original,textView2);
            correcto.start();
        }else{
            Toast.makeText(getActivity(), "No es posible el cambio", Toast.LENGTH_SHORT).show();
        }
    }

    private void findEmptyAndExchange(TextView original, TextView... textViews) {
        for (TextView textView : textViews) {
            String text = textView.getText().toString();
            if (text.equals("")) {
                exchange(original, textView);
                correcto.start();
                movements++;
                tvmovimientos.setText("Movimientos: "+ movements );
                return; // Terminar la función si se realiza un intercambio
            }
        }
        incorrecto.start();
        Toast.makeText(getActivity(), "No es posible el cambio", Toast.LENGTH_SHORT).show();
    }
    private void mezclar() {
        int longitud = 9; // longitud del vector
        int[] aleatorio = new int[longitud];
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            int numerorandom;
            boolean duplicado;
            do {
                numerorandom = random.nextInt(9) + 1;
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



        TextView[] textViews = {tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9};
        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setText(String.valueOf(aleatorio[i]));
            if (textViews[i].getText().toString().equals("9")) {
                textViews[i].setText("");
                textViews[i].setBackgroundColor(Color.parseColor("#004CAF50"));
            }
        }
    }
    private void ganaste(){
        TextView[] textViews = {tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9};
        String [] cadena_correcta = {"1","2","3","4","5","6","7","8",""};
        int aciertos=0;
        for (int i = 0; i < textViews.length; i++) {
            if (textViews[i].getText().toString().equals(cadena_correcta[i])) {
                aciertos++;
            }
        }
        if (aciertos == 9) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, winFragment).commit();
        } else {
            int porcentaje =(aciertos * 100) / 9;
            tvporcentaje.setText("Porcentaje: " + porcentaje + "%");
        }
    }


}