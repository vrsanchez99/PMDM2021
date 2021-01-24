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

/**

 * create an instance of this fragment.
 */
public class NuevoLibroFragment extends DialogFragment {
    AlertDialog.Builder builder;
    OnNewLibroListener mListener;
    View v;
    EditText editTextTitulo, editTextDescripcion, editTextIsbn;

    Context ctx;


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
        editTextIsbn = (EditText) v.findViewById(R.id.editTextIsbn);

        builder.setView(v);

        builder.setTitle("Nuevo libro")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Avería guardada", Toast.LENGTH_SHORT).show();

                        String titulo = editTextTitulo.getText().toString();
                        String descripcion = editTextDescripcion.getText().toString();
                        int isbn = Integer.valueOf(editTextIsbn.getText().toString());
                        if(!titulo.isEmpty() && !descripcion.isEmpty() && !(isbn<0)) {
                            mListener.onLibroGuardarClickListener(titulo, descripcion, isbn);

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