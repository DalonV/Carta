package tfg.davidparamo.carta;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.windowsazure.mobileservices.MobileServiceList;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by david on 05/06/2017.
 */

public class PlatoAdapter extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Pedido> items;

    public PlatoAdapter(Activity activity) {
        this.activity = activity;
        this.items = GlobalSettings.pedidoActual;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Pedido> pedidos) {
        for(Pedido p : pedidos){
            items.add(p);
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_carrito, null);
        }
        Pedido actual = items.get(position);
        Plato plato = GlobalSettings.platosDelPedido.get(actual.getPlato());
        TextView nombre = (TextView) v.findViewById(R.id.nombreCarrito);
        nombre.setText(actual.getPlato());
        ImageView imagen = (ImageView) v.findViewById(R.id.imageCarrito);
        Log.d("URL DE LA IMAGEN",plato.getImageUrl());
        TextView precio = (TextView) v.findViewById(R.id.precioCarrito);
        precio.setText(plato.getPrecio());
        TextView cantidad = (TextView) v.findViewById(R.id.cantidadCarrito);
        cantidad.setText(Integer.toString(actual.getCantidadPlato()));
        Button eliminar = (Button) v.findViewById(R.id.eliminarCarrito);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pedido ped = items.get(position);
                items.remove(position);
                Toast.makeText(v.getContext(),"Plato eliminado",Toast.LENGTH_LONG).show();
                GlobalSettings.platosDelPedido.remove(ped.getPlato());
                notifyDataSetChanged();

            }
        });
        Button aumentarCantidad = (Button) v.findViewById(R.id.masCarrito);
        aumentarCantidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cantidadComida = (TextView) activity.findViewById(R.id.cantidadCarrito);
                int numero = Integer.parseInt(cantidadComida.getText().toString());
                cantidadComida.setText(Integer.toString(++numero));
            }
        });

        Button disminuirCantidad = (Button) v.findViewById(R.id.menosCarrito);
        disminuirCantidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cantidadComida = (TextView) activity.findViewById(R.id.cantidadCarrito);
                int numero = Integer.parseInt(cantidadComida.getText().toString());
                cantidadComida.setText(Integer.toString(--numero));
            }
        });
        Picasso.with(activity).load(plato.getImageUrl())
                .into(imagen, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("BIEN","successfully load the image");
                    }

                    @Override
                    public void onError() {
                        Log.d("Mal","fail to load the image");
                    }
                });
        return v;
    }


}
