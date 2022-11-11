package com.example.ejercicioadicionalexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.ejercicioadicionalexamen.Modelos.Partido;
import com.example.ejercicioadicionalexamen.databinding.ActivityPartidoAddBinding;

public class PartidoActivityAdd extends AppCompatActivity {


    private ActivityPartidoAddBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding = ActivityPartidoAddBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

       binding.btnCrearPartidoAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              Partido partido = crearPartido();
           }
       });



    }

    private Partido crearPartido() {
        //if(!binding.spEquipo1PartidoAdd.)

        return null;
    }


}