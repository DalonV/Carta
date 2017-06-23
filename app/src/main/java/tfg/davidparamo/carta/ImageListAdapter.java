package tfg.davidparamo.carta;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.windowsazure.mobileservices.MobileServiceList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by david on 26/03/2017.
 */


public class ImageListAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;
    protected  Activity activity;
    private String[] imageUrls;
    private ArrayList<Plato> platos;


    public ImageListAdapter(Context context, Activity activity, String[] imageUrls, ArrayList<Plato> platos) {
        super(context, R.layout.postreslayout, imageUrls);
        this.context = context;
        this.imageUrls = imageUrls;
        this.platos = platos;

        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (null == convertView) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.itemlayout, parent, false);
        }

            if(v==null)Log.d("entro porque null", "pues eso");
            TextView precio = (TextView) v.findViewById(R.id.idPlatoLista);
            precio.setText(platos.get(position).getNombre());
            ImageView imagen = (ImageView) v.findViewById(R.id.platoImgButton);
            imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),position+"",Toast.LENGTH_LONG).show();
                Plato seleccionado = platos.get(position);
                GlobalSettings.platoActual = seleccionado;
                Intent intent = new Intent(context, DetallePlato.class);
                context.startActivity(intent);
            }
            });

        Picasso
                .with(context)
                .load(imageUrls[position])
                .fit() // will explain later
                .into(imagen);

        return v;
    }
}
