package tfg.davidparamo.carta;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by david on 26/03/2017.
 */


public class ImageListAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;

    private String[] imageUrls;

    public ImageListAdapter(Context context, String[] imageUrls) {
        super(context, R.layout.postreslayout, imageUrls);

        this.context = context;
        this.imageUrls = imageUrls;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.itemlayout, parent, false);
        }

        ImageView imagen = (ImageView) convertView;
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Me han pulsado",Toast.LENGTH_LONG).show();
                Plato primero = GlobalSettings.platos.get(0);
                GlobalSettings.platoActual = primero;
                Intent intent = new Intent(context, DetallePlato.class);
                context.startActivity(intent);
            }
        });
        Picasso
                .with(context)
                .load(imageUrls[position])
                .fit() // will explain later
                .into(imagen);

        return convertView;
    }
}
