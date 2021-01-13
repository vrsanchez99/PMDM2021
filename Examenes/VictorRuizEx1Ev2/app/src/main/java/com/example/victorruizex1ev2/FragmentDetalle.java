package com.example.victorruizex1ev2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentDetalle extends Fragment {



    public FragmentDetalle() {
        // Required empty public constructor
    }

    public void mostrarDetalle(String texto) {

        TextView txtDetalle =  (TextView)getView().findViewById(R.id.detalle);
        txtDetalle.setText(texto);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }




}