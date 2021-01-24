package com.example.proyectobd_victorruiz.model.vo;

import com.example.proyectobd_victorruiz.app.MainApp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class LibroBD extends RealmObject {


    @PrimaryKey
    private long id;
    @Required
    private String titulo;
    private String descripcion;
    private int isbn;

    public static final String LIBRODB_ID = "id";
    public static final String LIBRODB_TITULO = "titulo";
    public static final String LIBRODB_DESCRIPCION = "descripcion";
    public static final String LIBRODB_ISBN = "imagenPortada";

    public LibroBD() {
        this.id = MainApp.LIBRO_ID.incrementAndGet();
    }

    public LibroBD(String titulo, String descripcion, int isbn) {
        this.id = MainApp.LIBRO_ID.incrementAndGet();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}
