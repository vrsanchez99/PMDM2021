package com.example.imagenes_con_picasso_glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (ImageView) findViewById(R.id.imageView2logo);

       // Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(logo);

        Picasso.get()
                .load("http://i.imgur.com/DvpvklR.png")
                .resize(50, 50)
                .centerCrop()
                .into(logo);

        //Lo mismo pero con Glide
       /* RequestOptions cropOptions = new RequestOptions().fitCenter();

        Glide.with(this)
                .load("http://miguelcamposrivera.com/logo_mecaround.png")
                .apply(cropOptions)
                .into(logo);*/

    }
}