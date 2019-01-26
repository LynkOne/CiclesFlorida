package com.example.hector.ciclesflorida;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TipusCicle.OnTCicleInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TipusCicle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TipusCicle extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARRAY_FILTRAT = "param1";
    private static final String TIPUS_CICLE = "param2";
    Button b_mitja, b_superior;
    private boolean superior, mitja;


    // TODO: Rename and change types of parameters
    private ArrayList<CicleFlorida> mParam1;
    private ArrayList<CicleFlorida> arrayFiltrado;
    private int idTipusCicle;
    private String mParam2;

    private OnTCicleInteractionListener comunica_fragment;

    public TipusCicle() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TipusCicle newInstance(ArrayList<CicleFlorida> cf, int tipusDeCicles) {
        TipusCicle fragment = new TipusCicle();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARRAY_FILTRAT, cf);
        args.putInt(TIPUS_CICLE,tipusDeCicles);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1=getArguments().getParcelableArrayList(ARRAY_FILTRAT);
            idTipusCicle=getArguments().getInt(TIPUS_CICLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_tipus_cicle, container, false);
        b_mitja=v.findViewById(R.id.b_mitja);
        b_superior=v.findViewById(R.id.b_superior);
        b_mitja.setOnClickListener(this);
        b_superior.setOnClickListener(this);
        mitja=false;
        superior=false;
        arrayFiltrado = new ArrayList<CicleFlorida>();
        Log.d("MIO", "antes de filtrar");
        filtrarArray();
        if(!mitja){
            b_mitja.setEnabled(false);
        }
        if(!superior){
            b_superior.setEnabled(false);
        }
        return v;
    }
    @Override
    public void onClick(View v){
        if (v.getId()==R.id.b_mitja){
            Log.d("MIO", "Pulsado boton mitja");
            comunica_fragment.onTCicleInteraction(1, arrayFiltrado);
        }
        if (v.getId()==R.id.b_superior){
            Log.d("MIO", "Pulsado boton superior");
            comunica_fragment.onTCicleInteraction(2, arrayFiltrado);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
   /* public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onTCicleInteraction(uri);
        }
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTCicleInteractionListener) {
            comunica_fragment = (OnTCicleInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        comunica_fragment = null;
    }


    public void filtrarArray(){
        Log.d("MIO","dist"+mParam1.size());
        for (CicleFlorida aux:mParam1) {
            switch (idTipusCicle){
                case 1: //empresa
                    if (aux.getFamiliaProfessional()=="EMPRESA"){
                        arrayFiltrado.add(aux);
                        if (aux.getTipus()=="Superior"){
                            superior=true;
                        }
                        else{
                            mitja=true;
                        }
                    }


                    break;
                case 2: //informatica
                    if (aux.getFamiliaProfessional()=="INFORMÀTICA"){
                        arrayFiltrado.add(aux);
                        if (aux.getTipus()=="Superior"){
                            superior=true;
                        }
                        else{
                            mitja=true;
                        }
                    }

                    break;
                case 3: //esports
                    if (aux.getFamiliaProfessional()=="ESPORT"){
                        arrayFiltrado.add(aux);
                        if (aux.getTipus()=="Superior"){
                            superior=true;
                        }
                        else{
                            mitja=true;
                        }
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
    public interface OnTCicleInteractionListener {
        // TODO: Update argument type and name
        void onTCicleInteraction(int id, ArrayList<CicleFlorida> arrayFiltrado);
    }

}
