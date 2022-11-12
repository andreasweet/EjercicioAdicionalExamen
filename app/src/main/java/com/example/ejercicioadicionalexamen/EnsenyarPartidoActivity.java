package com.example.ejercicioadicionalexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.ejercicioadicionalexamen.Modelos.Partido;
import com.example.ejercicioadicionalexamen.databinding.ActivityEnsenyarPartidoBinding;

public class EnsenyarPartidoActivity extends AppCompatActivity {

    private ActivityEnsenyarPartidoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEnsenyarPartidoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pintarElementos();

    }

    private void pintarElementos() {
        Partido p = (Partido)getIntent().getExtras().getSerializable("PARTIDO");
        //castear: convertir una variable a un tipo de variable en otra distinta

       binding.lblEquipo1Mostrar.setText(p.getEquipo1());
       binding.lblEquipo2Mostrar.setText(p.getEquipo2());
       binding.lblResultadoMostrar.setText(p.getResultado());
       binding.lblResumenMostrar.setText(p.getComentario());

    }
}