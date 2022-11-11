package com.example.ejercicioadicionalexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
               if(partido != null){
                   Bundle bundle = new Bundle(); //guardar los datos
                   bundle.putSerializable("PARTIDO", partido);
                   Intent intent = new Intent(); //enviar los datos al MainActivity
                   intent.putExtras(bundle);
                   setResult(RESULT_OK, intent);
                   finish();
               }else{
                   Toast.makeText(PartidoActivityAdd.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
               }
           }
       });





    }

    private Partido crearPartido() {
        if(binding.spEquipo1PartidoAdd.getSelectedItemPosition() != 0 &&
        binding.spEquipo2PartidoAdd.getSelectedItemPosition() != 0 &&
        !binding.txtResultadoPartidoAdd.getText().toString().isEmpty() &&
        !binding.txtComentPartidoAdd.getText().toString().isEmpty()){

             String equipo1 = binding.spEquipo1PartidoAdd.getSelectedItem().toString();
             String equipo2 = binding.spEquipo2PartidoAdd.getSelectedItem().toString();
             String resultado = binding.txtResultadoPartidoAdd.getText().toString();
             String comentario = binding.txtComentPartidoAdd.getText().toString();

            return new Partido(equipo1, equipo2, resultado,comentario);
        }else{

            return null;
        }
    }


}