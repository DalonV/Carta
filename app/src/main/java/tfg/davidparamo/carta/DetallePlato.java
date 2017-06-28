package tfg.davidparamo.carta;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.util.concurrent.ListenableFuture;
import com.microsoft.windowsazure.mobileservices.MobileServiceList;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static tfg.davidparamo.carta.GlobalSettings.platosDelPedido;


public class DetallePlato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_plato);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setInterface();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void aumentarCantidad(View view) {
        TextView cantidadComida = (TextView) findViewById(R.id.cantidadPlato);
        int numero = Integer.parseInt(cantidadComida.getText().toString());
        cantidadComida.setText(Integer.toString(++numero));
    }

    public void disminuirCantidad(View view) {
        TextView cantidadComida = (TextView) findViewById(R.id.cantidadPlato);
        int numero = Integer.parseInt(cantidadComida.getText().toString());
        if(numero>1) cantidadComida.setText(Integer.toString(--numero));
    }

    public void addPlato(View view) {
        TextView cantidadComida = (TextView) findViewById(R.id.cantidadPlato);
        int cantidad = Integer.parseInt(cantidadComida.getText().toString());
        Plato platoActual = GlobalSettings.platoActual;
        String nombre = platoActual.getNombre();
        String precio = platoActual.getPrecio();
        GlobalSettings.reciboTotal += Float.parseFloat(precio) * cantidad;
        boolean repetido = false;
        Pedido pedido = new Pedido(GlobalSettings.numMesa, nombre, cantidad, precio);
        for (Pedido ped : GlobalSettings.pedidoActual) {
            if ((ped.getPlato()).equals(pedido.getPlato())) {
                Log.d("Cantidad en el pedido", Integer.toString(ped.getCantidadPlato()));
                Log.d("Cantidad a mayores", Integer.toString(pedido.getCantidadPlato()));
                int aux = ped.getCantidadPlato() + pedido.getCantidadPlato();
                ped.setCantidadPlato(aux);
                repetido = true;
            }
        }

        if (!repetido) {
            GlobalSettings.pedidoActual.add(pedido);
            GlobalSettings.recibo.add(pedido);
            platosDelPedido.put(platoActual.getNombre(), platoActual);
        }

        Toast.makeText(this, "Se ha agregado el plato al pedido", Toast.LENGTH_SHORT).show();
        finish();

    }

    private void setInterface() {
        Plato plato = GlobalSettings.platoActual;
        setTitle(plato.getNombre());
        TextView precio = (TextView) findViewById(R.id.precio);
        precio.setText(plato.getPrecio() + " €");
        TextView descripcion = (TextView) findViewById(R.id.descripcionPlato);
        descripcion.setText(plato.getDescripcion());
        ImageView imagen = (ImageView) findViewById(R.id.imagenPlato);
        Picasso.with(this).load(plato.getImageUrl())
                .into(imagen, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("BIEN", "successfully load the image");
                    }

                    @Override
                    public void onError() {
                        Log.d("Mal", "fail to load the image");
                    }
                });
    }

}
