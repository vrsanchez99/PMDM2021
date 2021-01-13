package com.example.victorruizex1ev2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adaptador extends ArrayAdapter<Lista> {

    Context context;
    int layout;
    List<Lista> list;

    public Adaptador(@NonNull Context context, int resource, @NonNull List<Lista> objects) {
        super(context, resource, objects);

        this.context = context;
        this.layout = resource;
        this.list = objects;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = LayoutInflater.from(context).inflate(layout, parent, false);
        Lista personaActual = list.get(position);
        TextView nombre = (TextView) v.findViewById(R.id.detalle);

        nombre.setText(personaActual.getNombre());
        return v;
    }
}
