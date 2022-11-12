package com.example.ejercicioadicionalexamen;

import android.content.Intent;
import android.os.Bundle;

import com.example.ejercicioadicionalexamen.Adapters.PartidoAdapter;
import com.example.ejercicioadicionalexamen.Modelos.Partido;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.ejercicioadicionalexamen.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ArrayList<Partido> partidoList;
    private ActivityResultLauncher<Intent> launcherCrearPartidos;

    private PartidoAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        partidoList = new ArrayList<>();
        inicializarLaunchers();

        adapter = new PartidoAdapter(partidoList,R.layout.partido_model_card,this);
        layoutManager = new GridLayoutManager(this, 1);

        binding.content.contenedor.setAdapter(adapter);
        binding.content.contenedor.setLayoutManager(layoutManager);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               launcherCrearPartidos.launch(new Intent(MainActivity.this, PartidoActivityAdd.class));
            }
        });

    }

    private void inicializarLaunchers() {
        launcherCrearPartidos = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null) {
                        if (result.getData().getExtras() != null) {
                            if (result.getData().getExtras().getSerializable("PARTIDO") != null) {

                                Partido partido = (Partido) result.getData().getExtras().getSerializable("PARTIDO");
                                partidoList.add(partido);
                                adapter.notifyItemInserted(partidoList.size()-1); //notifica que se ha introducido una card
                                Toast.makeText(MainActivity.this, partido.toString(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "NO HAY DATOS", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "NO HAY BUNDLE EN EL INTENT", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "NO HAY INTENT", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}