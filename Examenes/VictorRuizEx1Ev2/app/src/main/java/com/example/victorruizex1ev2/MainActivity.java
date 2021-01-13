package com.example.victorruizex1ev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnListenerNombre{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentListado fListado = (FragmentListado) getSupportFragmentManager().findFragmentById(R.id.fragmentListado);

        fListado.setOyenteNombre(this);

    }

    @Override
    public void onNombreSeleccionado(Lista lista) {

        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById(R.id.fragmentoDetalle) != null);

        if(hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager()
                    .findFragmentById(R.id.fragmentoDetalle)).mostrarDetalle(lista.getDescripcion());
        }
        else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_DETALLE, lista.getDescripcion());
            startActivity(i);
        }

    }
}