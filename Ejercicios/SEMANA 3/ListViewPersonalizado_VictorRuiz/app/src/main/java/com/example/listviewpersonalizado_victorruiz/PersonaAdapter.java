package com.example.listviewpersonalizado_victorruiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PersonaAdapter extends ArrayAdapter<Persona> {

    Context context;
    int layout;
    List<Persona> personList;


    public PersonaAdapter(@NonNull Context context, int resource, @NonNull List<Persona> personas) {
        super(context, resource, personas);
        this.context = context;
        this.layout = resource;
        this.personList = personas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(layout, parent, false);

        //Obtener la informacion del elemento de la lista que estoy iterando
        Persona personaActual = personList.get(position);
        TextView nombre = (TextView) v.findViewById(R.id.textView);
        ImageView foto = (ImageView) v.findViewById(R.id.imageView);

        nombre.setText(personaActual.getNombre());

        if (personaActual.getGenero() == 'm') {
            foto.setBackgroundResource(R.drawable.mujer);
        } else if (personaActual.getGenero() == 'h') {
            foto.setBackgroundResource(R.drawable.hombre);
        }
        return v;
    }
}
