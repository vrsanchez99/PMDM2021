package com.example.holausuario_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView mensaje = null;
    private String[] input = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mensaje = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        input = intent.getStringArrayExtra("user_Data");
        mensaje.setText("Hola " + input[0] + " tienes " + input[1] + " años.");

    }
}