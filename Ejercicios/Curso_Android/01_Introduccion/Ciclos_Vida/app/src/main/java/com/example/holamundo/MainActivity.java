package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String metodo = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Estado del ciclo: ", "onCreate()");
        metodo = "OnCreate()";
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Estado del ciclo: ", "onRestart()");
        metodo = "OnRestart()";
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Estado del ciclo: ", "onResume()");
        metodo = "OnResume()";
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Estado del ciclo: ", "onPause()");
        metodo = "OnPause()";
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Estado del ciclo: ", "onStop()");
        metodo = "OnStop()";
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Estado del ciclo: ", "onStart()");
        metodo = "OnStart()";
    }
}