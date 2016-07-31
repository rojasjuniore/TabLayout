package com.rojasjuniore.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Junior on 30/07/2016.
 */
public class GridAdapter extends BaseAdapter {

    private final Context myContext;
    private final Product[] myitems;

    public GridAdapter(Context c, Product[] items) {
        myContext = c;
        this.myitems = items;
    }


    @Override
    public int getCount() {
        // Decremento en 1, para no contar el header view
        return myitems.length - 1;
    }

    @Override
    public Product getItem(int position) {
        return myitems[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) myContext.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);

        }

        Product item = getItem(position);

        // Seteando Imagen
        ImageView image = (ImageView) view.findViewById(R.id.imagen);
        Glide.with(image.getContext()).load(item.getIdThumbnail()).into(image);

        // Seteando Nombre
        TextView name = (TextView) view.findViewById(R.id.nombre);
        name.setText(item.getNombre());

        // Seteando Descripción
        TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        descripcion.setText(item.getDescripcion());

        // Seteando Precio
        TextView precio = (TextView) view.findViewById(R.id.precio);
        precio.setText(item.getPrecio());

        // Seteando Rating
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rating);
        ratingBar.setRating(item.getRating());

        return view;
    }
}
