package com.example.proyectobd_victorruiz.model.repositories;

public interface OnNewLibroListener {
    public void onLibroGuardarClickListener(String titulo, String descripcion, int isbn);
    public void onLibroUpdateClickListener(long id, String titulo, String descripcion, int isbn);
}
