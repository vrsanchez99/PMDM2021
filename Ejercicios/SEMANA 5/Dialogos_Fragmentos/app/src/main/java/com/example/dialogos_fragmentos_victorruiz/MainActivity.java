package com.example.dialogos_fragmentos_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogoSexo.RespuestaDialogoSexo, View.OnClickListener {

    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(this);
    }

    @Override
    public void onRespuesta(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            DialogoSexo ds = new DialogoSexo();
            ds.show(getSupportFragmentManager(), "Mi diálogo");
        }
    }
}