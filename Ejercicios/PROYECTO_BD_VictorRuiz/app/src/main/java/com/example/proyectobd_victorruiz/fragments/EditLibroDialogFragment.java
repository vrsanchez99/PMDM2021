package com.example.proyectobd_victorruiz.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.proyectobd_victorruiz.R;
import com.example.proyectobd_victorruiz.model.repositories.OnNewLibroListener;
import com.example.proyectobd_victorruiz.model.vo.LibroBD;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditLibroDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditLibroDialogFragment extends DialogFragment {
    private long idLibro;
    private String titulo, descripcion;
    private int isbn;
    AlertDialog.Builder builder;
    OnNewLibroListener mListener;
    View v;
    EditText editTextTitulo, editTextDescripcion,editTextIsbn;
    Context ctx;

    public EditLibroDialogFragment() {
        // Required empty public constructor
    }

    public static EditLibroDialogFragment newInstance(long idA, String t, String d, int i) {
        EditLibroDialogFragment fragment = new EditLibroDialogFragment();
        Bundle args = new Bundle();
        args.putLong(LibroBD.LIBRODB_ID, idA);
        args.putString(LibroBD.LIBRODB_TITULO, t);
        args.putString(LibroBD.LIBRODB_DESCRIPCION, d);
        args.putInt(LibroBD.LIBRODB_ISBN, i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idLibro = getArguments().getLong(LibroBD.LIBRODB_ID);
            titulo = getArguments().getString(LibroBD.LIBRODB_TITULO);
            descripcion = getArguments().getString(LibroBD.LIBRODB_DESCRIPCION);
            isbn = getArguments().getInt(LibroBD.LIBRODB_ISBN);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        builder = new AlertDialog.Builder(getActivity());

        ctx = getActivity();

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        v = inflater.inflate(R.layout.fragment_nuevo_libro, null);
        editTextTitulo = (EditText) v.findViewById(R.id.editTextTitulo);
        editTextDescripcion = (EditText) v.findViewById(R.id.editTextDescripcion);
       editTextDescripcion =(EditText)v.findViewById(R.id.editTextIsbn);

        editTextTitulo.setText(titulo);
        editTextDescripcion.setText(descripcion);
        editTextIsbn.setText(String.valueOf(isbn));

        builder.setView(v);

        builder.setTitle("Editando avería")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Libro guardado", Toast.LENGTH_SHORT).show();

                        String titulo = editTextTitulo.getText().toString();
                        String descripcion = editTextDescripcion.getText().toString();
                        int imagen = R.id.imageViewLibro;
                        if (!titulo.isEmpty() && !descripcion.isEmpty() && !(imagen == 0)) {
                            mListener.onLibroUpdateClickListener(idLibro, titulo, descripcion, imagen);

                            dialog.dismiss();
                        } else {
                            Toast.makeText(ctx, "Introduzca todos los datos", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Cancelar > cerrar el cuadro de diálogo
                        dialog.dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (OnNewLibroListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement OnNewLibroListener");
        }
    }
}