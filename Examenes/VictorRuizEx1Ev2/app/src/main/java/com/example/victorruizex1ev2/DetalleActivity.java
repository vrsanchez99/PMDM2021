package com.example.victorruizex1ev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    TextView textView;

    public static final String EXTRA_DETALLE =
            "DETALLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        textView = (TextView)findViewById(R.id.detalle);

        FragmentDetalle detalle =
                (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.fragmentoDetalle);


        detalle.mostrarDetalle(getIntent().getStringExtra(EXTRA_DETALLE));
    }
}