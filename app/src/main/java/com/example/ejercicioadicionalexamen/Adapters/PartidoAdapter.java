package com.example.ejercicioadicionalexamen.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicioadicionalexamen.Modelos.Partido;
import com.example.ejercicioadicionalexamen.R;

import java.util.List;

public class PartidoAdapter extends RecyclerView.Adapter<PartidoAdapter.ProductoVH>  {

    private List<Partido> objects;
    private int resource;
    private Context context;

    public PartidoAdapter(List<Partido> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;

}

    @NonNull
    @Override
    public ProductoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View partidoView = LayoutInflater.from(context).inflate(resource, null);
        partidoView.setLayoutParams(new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        return new ProductoVH(partidoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoVH holder, int position) {
        Partido partido = new Partido();
        holder.lblEquipos.setText(partido.getEquipo1()+ "vs"+partido.getEquipo2());
        holder.lblResultado.setText(partido.getResultado());
        holder.btnConfirmGanador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmGanador(partido).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private AlertDialog confirmGanador(Partido p) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("GANADOR");
        String [] trozos;
        trozos = p.getResultado().split("-");
        if(Integer.parseInt(trozos[0]) > Integer.parseInt(trozos[1])){
            builder.setMessage("Ha ganado: "+p.getEquipo1());
        }else if(Integer.parseInt(trozos[0]) < Integer.parseInt(trozos[1])){
            builder.setMessage("Ha ganado: "+p.getEquipo2());
        }else{
            builder.setMessage("Han empatado"+p.getEquipo2());
        }

        builder.setMessage(null);
        builder.setCancelable(false);
        builder.setNegativeButton("SALIR", null);
        return builder.create();
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ProductoVH extends RecyclerView.ViewHolder {

        TextView lblEquipos;
        TextView lblResultado;
        Button btnConfirmGanador;

        public ProductoVH(@NonNull View itemView) {
            super(itemView);
            lblEquipos = itemView.findViewById(R.id.lblEquiposPartidoCard);
            lblResultado = itemView.findViewById(R.id.lblResultadoPartidoCard);
            btnConfirmGanador = itemView.findViewById(R.id.btnConfirmGanadoPartidoCard);
        }
    }
}
