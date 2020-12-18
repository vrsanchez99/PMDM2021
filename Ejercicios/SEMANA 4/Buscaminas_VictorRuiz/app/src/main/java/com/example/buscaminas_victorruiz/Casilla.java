package com.example.buscaminas_victorruiz;

public class Casilla {

    public char contenido = '.';
    public boolean destapado = false;

    public Casilla(){}



    public char getContenido() {
        return contenido;
    }

    public void setContenido(char contenido) {
        this.contenido = contenido;
    }

    public boolean isDestapado() {
        return destapado;
    }

    public void setDestapado(boolean destapado) {
        this.destapado = destapado;
    }

    @Override
    public String toString() {
        return "Casilla{" +
                "contenido=" + contenido +
                ", destapado=" + destapado +
                '}';
    }
}
