package com.example.victorruizex2ev1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListaEntradaAdapter extends ArrayAdapter<Lista_entrada> {

    Context context;
    int layout;
    List<Lista_entrada> birdsList;

    public ListaEntradaAdapter(@NonNull Context context, int resource, @NonNull List<Lista_entrada> birds) {
        super(context, resource, birds);
        this.context = context;
        this.layout = resource;
        this.birdsList = birds;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(layout, parent, false);

        //Obtener la informacion del elemento de la lista que estoy iterando
        Lista_entrada personaActual = birdsList.get(position);
        TextView nombre = (TextView) v.findViewById(R.id.textNombreAnimal);
        ImageView foto = (ImageView) v.findViewById(R.id.imageView);
        TextView desc = (TextView) v.findViewById(R.id.textDescripcion);

        nombre.setText(personaActual.get_textoEncima());
        foto.setBackgroundResource(personaActual.get_idImagen());
        desc.setText(personaActual.get_textoDebajo());

        return v;
    }
}
