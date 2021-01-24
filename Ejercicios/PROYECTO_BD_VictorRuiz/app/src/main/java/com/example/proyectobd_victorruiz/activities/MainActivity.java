package com.example.proyectobd_victorruiz.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.proyectobd_victorruiz.R;
import com.example.proyectobd_victorruiz.fragments.ListadoLibrosFragment;
import com.example.proyectobd_victorruiz.fragments.NuevoLibroFragment;
import com.example.proyectobd_victorruiz.model.repositories.OnLibroInteractionListener;
import com.example.proyectobd_victorruiz.model.repositories.OnNewLibroListener;
import com.example.proyectobd_victorruiz.model.vo.LibroBD;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        OnLibroInteractionListener,
        OnNewLibroListener {

    DialogFragment dialogNuevoLibro, dialogEditLibro;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogNuevoLibro = new NuevoLibroFragment();
                dialogNuevoLibro.show(getSupportFragmentManager(), "DialogoNueva");
            }
        });

        Realm.init(this);

        realm = Realm.getDefaultInstance();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Personalización del contenido del NavigationView header
        ImageView ivAvatar = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.imageViewAvatar);
        ivAvatar.setImageResource(R.drawable.ic_man);


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor, new ListadoLibrosFragment())
                .commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onLibroGuardarClickListener(String titulo, String descripcion, int isbn) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                LibroBD libro = new LibroBD();
                libro.setTitulo(titulo);
                libro.setDescripcion(descripcion);
                libro.setIsbn(isbn);


                realm.copyToRealm(libro);
            }
        });
    }

    @Override
    public void onLibroUpdateClickListener(long id, String titulo, String descripcion, int imagen) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                LibroBD nuevoLibro = new LibroBD();
                nuevoLibro.setId(id);
                nuevoLibro.setTitulo(titulo);
                nuevoLibro.setDescripcion(descripcion);


                realm.copyToRealmOrUpdate(nuevoLibro);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment f = null;

        if (id == R.id.nav_libros) {
            f = new ListadoLibrosFragment();
        } else if (id == R.id.nav_share) {

        }

        if (f != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenedor, f)
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onLibroClick(LibroBD libro) {

    }

    @Override
    public void onLibroEdit(LibroBD mItem) {

    }
}