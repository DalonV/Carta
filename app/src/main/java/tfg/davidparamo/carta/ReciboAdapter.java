package tfg.davidparamo.carta;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by david on 23/06/2017.
 */

public class ReciboAdapter extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Pedido> items;

    public ReciboAdapter(Activity activity) {
        this.activity = activity;
        this.items = GlobalSettings.recibo;
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
            Log.d("entro porque null", "pues eso");
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_recibo, null);
        }
        Pedido actual = items.get(position);
        TextView nombre = (TextView) v.findViewById(R.id.nombreRecibo);
        nombre.setText(actual.getPlato());
        TextView precioLabel = (TextView) v.findViewById(R.id.precioRecibo);
        float precioPorCantidad = Float.parseFloat(actual.getPrecio()) * actual.getCantidadPlato();
        precioLabel.setText(precioPorCantidad + " €");
        TextView cantidad = (TextView) v.findViewById(R.id.cantidadRecibo);
        cantidad.setText("x" + Integer.toString(actual.getCantidadPlato()));

        return v;
    }


}