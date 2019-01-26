package com.example.hector.ciclesflorida;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Llistat.OnLlistatInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Llistat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Llistat extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private ArrayList<CicleFlorida> arrayCicles;
    private ArrayList<CicleFlorida> arrayFiltrado;
    private int id_tipusCicle;
    private RecyclerView rv;
    private Cicles_ReciclerView crv;
    private RecyclerView.LayoutManager rvlm;

    private OnLlistatInteractionListener mListener;

    public Llistat() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Llistat newInstance(ArrayList<CicleFlorida> arrayListrerefiltrado, int id_tipusCicle) {
        Llistat fragment = new Llistat();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, arrayListrerefiltrado);
        args.putInt(ARG_PARAM2, id_tipusCicle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            arrayCicles = getArguments().getParcelableArrayList(ARG_PARAM1);
            id_tipusCicle = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_llistat, container, false);
        //llistat=(TextView)v.findViewById(R.id.txtLlistat);
        arrayFiltrado=new ArrayList<CicleFlorida>();
        reReFiltrar();
        Log.d("MIO","oncreateview listado "+arrayFiltrado.size());

        rv=(RecyclerView)v.findViewById(R.id.fragment_reciclerView);
        rvlm=new LinearLayoutManager(v.getContext());
        rv.setLayoutManager(rvlm);

        crv=new Cicles_ReciclerView(arrayFiltrado);
        Log.d("MIO","antes set adapter");
        rv.setAdapter(crv);

        Log.d("MIO","despues set adapter");
        return v;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onLlistatInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLlistatInteractionListener) {
            mListener = (OnLlistatInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void reReFiltrar(){
       // llistat.setText("");

        for (CicleFlorida aux:arrayCicles) {

            switch (id_tipusCicle){
                case 1: //mitja
                    if (aux.getTipus()=="Mitjà"){
                       // llistat.setText(llistat.getText()+aux.toString()+"\n\n");
                        arrayFiltrado.add(aux);

                    }

                    break;
                case 2: //superior
                    if (aux.getTipus()=="Superior"){
                       // llistat.setText(llistat.getText()+aux.toString()+"\n\n");
                        arrayFiltrado.add(aux);

                    }

                    break;
            }
        }

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnLlistatInteractionListener {
        // TODO: Update argument type and name
        void onLlistatInteraction(Uri uri);
    }
}
