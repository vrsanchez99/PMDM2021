package com.example.multiscreen2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout contenedor = (FrameLayout)findViewById(R.id.contenedor);

        if(contenedor!=null){
            //bjkdslja
        }
    }
}