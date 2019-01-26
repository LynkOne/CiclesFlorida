package com.example.hector.ciclesflorida;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cicles_ReciclerView extends RecyclerView.Adapter<Cicles_ReciclerView.CicleViewHolder>{

    private ArrayList<CicleFlorida> llistat_cicles;



    public static class CicleViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder implements AdapterView.OnClickListener {

        public TextView familia;
        public TextView tipus;
        public TextView titol;

        public CicleViewHolder(@NonNull View itemView) {
            super(itemView);
            familia=(TextView)itemView.findViewById(R.id.txt_fam_prof);
            tipus=(TextView)itemView.findViewById(R.id.txt_tipus);
            titol=(TextView)itemView.findViewById(R.id.rc_titol);

            familia.setOnClickListener(this);
            tipus.setOnClickListener(this);
            titol.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int id=v.getId();
            if (id==familia.getId()){
                Toast.makeText(itemView.getContext(), "Familia profesional polsat",Toast.LENGTH_SHORT);
            }
            if (id==tipus.getId()){
                Toast.makeText(itemView.getContext(), "Tipus polsat",Toast.LENGTH_SHORT);
            }
            if (id==titol.getId()){
                Toast.makeText(itemView.getContext(), "Titol polsat",Toast.LENGTH_SHORT);
            }
        }
    }

    public Cicles_ReciclerView(ArrayList<CicleFlorida> llistat_cicles) {
        this.llistat_cicles = llistat_cicles;
        Log.d("MIO", "constructorAdaptador");
    }

    @NonNull
    @Override
    public CicleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_cicles_recicler_view,viewGroup, false);

        Log.d("MIO", "oncreateAdatpdor");
        return new CicleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CicleViewHolder cicleViewHolder, int i) {

        cicleViewHolder.familia.setText(llistat_cicles.get(i).getFamiliaProfessional());
        cicleViewHolder.titol.setText(llistat_cicles.get(i).getTitol());
        cicleViewHolder.tipus.setText(llistat_cicles.get(i).getTipus());
        Log.d("MIO", "Asignando");
    }

    @Override
    public int getItemCount() {
        return llistat_cicles.size();
    }
}
