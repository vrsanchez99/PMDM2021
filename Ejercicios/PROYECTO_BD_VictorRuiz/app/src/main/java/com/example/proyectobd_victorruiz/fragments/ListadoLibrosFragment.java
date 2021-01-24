package com.example.proyectobd_victorruiz.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectobd_victorruiz.R;
import com.example.proyectobd_victorruiz.adapters.MyLibroRecyclerViewAdapter;
import com.example.proyectobd_victorruiz.model.repositories.OnLibroInteractionListener;
import com.example.proyectobd_victorruiz.model.vo.LibroBD;

import java.util.ArrayList;
import java.util.List;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmResults;


public class ListadoLibrosFragment extends Fragment {

    OnLibroInteractionListener mListener;
    RealmResults<LibroBD> libroDBList;
    Realm realm;

    public ListadoLibrosFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listado_libros, container, false);
        // Inflate the layout for this fragment
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            // Lista de averias

            libroDBList = realm.where(LibroBD.class).findAll();

            recyclerView.setAdapter(new MyLibroRecyclerViewAdapter(getActivity(), libroDBList, mListener));
        }


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);
        if (context instanceof OnLibroInteractionListener) {
            mListener = (OnLibroInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnLibroInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}