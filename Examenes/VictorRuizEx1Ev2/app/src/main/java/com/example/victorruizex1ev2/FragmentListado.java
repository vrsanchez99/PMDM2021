package com.example.victorruizex1ev2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class FragmentListado extends Fragment implements AdapterView.OnItemClickListener {


    private ListView listaNombres;
    Context context = this.getContext();

    private List<Lista> nombres;
    private Adaptador adaptador;

    private OnListenerNombre oyenteNombre;

    public void setOyenteNombre(OnListenerNombre oyenteNombre) {
        this.oyenteNombre = oyenteNombre;
    }

    public FragmentListado() {
        // Required empty public constructor
    }

    /*

“");
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nombres = new ArrayList<Lista>();

        nombres.add(new Lista("Natalia","Origen griego. Natalia, como Natalio, toma su raíz de Natal, con la etimología en «natalis dies» (relacionado con el día del natalicio de Cristo), con el significado de \"día del nacimiento\" de \"aquella que cuida de la vida" ));
        nombres.add(new Lista("Asperia","Origen Griego. El Occidente. Los griegos aplicaban este nombre a las penínsulas Itálica e Ibérica" ));
        nombres.add(new Lista("Alicia","Alicia es un nombre propio femenino de origen griego en su variante en español. Proviene del griego antiguo Αλήθεια (alétheia), que significa \\\"verdad\\\". El nombre se popularizó con Las aventuras de Alicia en el país de las maravillas, de Lewis Carroll.);" ));
        nombres.add(new Lista("Enma","Emma es un nombre para una niña de origen germánico que significa 'la que es fuerte'. El nombre de vuestra hija se utiliza en todo el mundo sin apenas variantes y se trata de uno de los nombres que más gustan a padres y niñas por la calidez y la ternura que desprende su pronunciación." ));
        nombres.add(new Lista("Ruth","" ));

        adaptador = new Adaptador(context, R.layout.item_persona, nombres);


        listaNombres.setAdapter(adaptador);
        listaNombres.setOnItemClickListener(this);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_listado, container, false);
        listaNombres = v.findViewById(R.id.lista);

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (oyenteNombre!=null) {
            oyenteNombre.onNombreSeleccionado(
                    (Lista)listaNombres.getAdapter().getItem(position));
        }



    }
}