package com.example.intentexplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button)findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                // Creating explicit intent
                Intent i = new Intent(getApplicationContext(),
                        MainActivity2.class);
                startActivity(i);
            }
        });
    }






}