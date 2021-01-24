package com.example.proyectobd_victorruiz.model.repositories;

import com.example.proyectobd_victorruiz.model.vo.LibroBD;

public interface OnLibroInteractionListener {
    public void onLibroClick(LibroBD libro);
    public void onLibroEdit(LibroBD mItem);
}
