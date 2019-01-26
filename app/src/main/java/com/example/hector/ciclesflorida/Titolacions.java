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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Titolacions.OnTitolacionsInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Titolacions#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Titolacions extends Fragment implements  View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button b_empresa, b_esports, b_informatica;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnTitolacionsInteractionListener mListener;

    public Titolacions() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Titolacions.
     */
    // TODO: Rename and change types and number of parameters
    public static Titolacions newInstance(String param1, String param2) {
        Titolacions fragment = new Titolacions();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_titolacions, container, false);
        b_empresa=v.findViewById(R.id.b_empresa);
        b_esports=v.findViewById(R.id.b_esports);
        b_informatica=v.findViewById(R.id.b_informatica);
        b_informatica.setOnClickListener(this);
        b_esports.setOnClickListener(this);
        b_empresa.setOnClickListener(this);

        return v;
    }



    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.b_empresa){
            Log.d("MIO", "Pulsado boton empresa");
            mListener.buscarTitulacionsEmpresa();
            //mListener.onTitolacionsInteraction(b_empresa);
        }
        if (v.getId()==R.id.b_esports){
            Log.d("MIO", "Pulsado boton esports");
            mListener.buscarTitulacionsEsports();

           // mListener.onTitolacionsInteraction(b_esports);
        }
        if (v.getId()==R.id.b_informatica){
            Log.d("MIO", "Pulsado boton informatica");
            mListener.buscarTitulacionsInformatica();
            //mListener.onTitolacionsInteraction(b_informatica);
        }


    }
    // TODO: Rename method, update argument and hook method into UI event
   /* public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onTitolacionsInteraction(Button);
        }
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTitolacionsInteractionListener) {
            mListener = (OnTitolacionsInteractionListener) context;
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
    public interface OnTitolacionsInteractionListener {
        // TODO: Update argument type and name
        void buscarTitulacionsEmpresa();
        void  buscarTitulacionsInformatica();
        void buscarTitulacionsEsports();
    }
}
