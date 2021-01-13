package com.example.repaso_gridview_victorruiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {
private GridView gridView;
private AdaptadorDeCoches adaptador;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usarToolbar();

        gridView = (GridView) findViewById(R.id.grid);
        adaptador = new AdaptadorDeCoches(this);
        gridView.setAdapter(adaptador);
        gridView.setOnItemClickListener(this);
        }

private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      // setSupportActionBar(toolbar);
        }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
        return true;
        }

        return super.onOptionsItemSelected(item);
        }

@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Coche item = (Coche) parent.getItemAtPosition(position);

        Intent intent = new Intent(this, ActividadDetalle.class);
        intent.putExtra(ActividadDetalle.EXTRA_PARAM_ID, item.getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

        ActivityOptionsCompat activityOptions =
        ActivityOptionsCompat.makeSceneTransitionAnimation(
        this,
        new Pair<View, String>(view.findViewById(R.id.imagen_coche),
        ActividadDetalle.VIEW_NAME_HEADER_IMAGE)
        );

        ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
        } else
        startActivity(intent);
        }


}
