package com.example.proyectobd_victorruiz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectobd_victorruiz.R;
import com.example.proyectobd_victorruiz.model.repositories.OnLibroInteractionListener;
import com.example.proyectobd_victorruiz.model.vo.LibroBD;

import java.util.List;

import io.realm.OrderedRealmCollection;
import io.realm.RealmChangeListener;
import io.realm.RealmList;
import io.realm.RealmResults;

public class MyLibroRecyclerViewAdapter extends RecyclerView.Adapter<MyLibroRecyclerViewAdapter.ViewHolder> {

    private final OrderedRealmCollection<LibroBD> mValues;
    private final OnLibroInteractionListener mListener;
    private Context ctx;
    private RealmChangeListener listener;

    public MyLibroRecyclerViewAdapter(Context context, OrderedRealmCollection<LibroBD> items, OnLibroInteractionListener listener) {
        ctx = context;
        mValues = items;
        mListener = listener;
        this.listener = new RealmChangeListener<OrderedRealmCollection<LibroBD>>() {
            @Override
            public void onChange(OrderedRealmCollection<LibroBD> results) {
                notifyDataSetChanged();
            }
        };

        if (items != null) {
            addListener(items);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_listado_libros_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewTitulo.setText(holder.mItem.getTitulo());
        holder.textViewDescripcion.setText(holder.mItem.getDescripcion());
        holder.te

        if (!(holder.mItem.getImagenPortada() == 0)) {
            Glide.with(ctx)
                    .load(holder.mItem.getImagenPortada())
                    .into(holder.imageViewFotoLibro);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onLibroClick(holder.mItem);
                }
            }
        });

        /*holder.imageViewEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onLibroEdit(holder.mItem);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewTitulo;
        public final TextView textViewDescripcion;
        public final ImageView imageViewFotoLibro;
        public LibroBD mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewTitulo = (TextView) view.findViewById(R.id.textViewTitulo);
            textViewDescripcion = (TextView) view.findViewById(R.id.textViewModeloCoche);
            imageViewFotoLibro = (ImageView) view.findViewById(R.id.imageViewLibro);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewTitulo.getText() + "'";
        }
    }

    private void addListener(OrderedRealmCollection<LibroBD> items) {
        if (items instanceof RealmResults) {
            RealmResults realmResults = (RealmResults) items;
            realmResults.addChangeListener(listener);
        } else if (items instanceof RealmList) {
            RealmList<LibroBD> list = (RealmList<LibroBD>) items;
            //noinspection unchecke
            list.addChangeListener((RealmChangeListener) listener);
        } else {
            throw new IllegalArgumentException("RealmCollection not supported: " + items.getClass());
        }
    }
}
