package tfg.davidparamo.carta;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.common.util.concurrent.ListenableFuture;
import com.microsoft.windowsazure.mobileservices.MobileServiceList;

import java.util.List;
import java.util.concurrent.ExecutionException;


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

    public void aumentarCantidad(View view){
        TextView cantidadComida = (TextView) findViewById(R.id.cantidadPlato);
        int numero = Integer.parseInt(cantidadComida.getText().toString());
        cantidadComida.setText(Integer.toString(++numero));
    }

    public void disminuirCantidad(View view){
        TextView cantidadComida = (TextView) findViewById(R.id.cantidadPlato);
        int numero = Integer.parseInt(cantidadComida.getText().toString());
        cantidadComida.setText(Integer.toString(--numero));
    }

    public void addPlato(View view){
        Log.d("fgvgvgvgvg","dfvdfdfvdfvdfvfvdfvdfvd");
        TextView cantidadComida = (TextView) findViewById(R.id.cantidadPlato);
        int numero = Integer.parseInt(cantidadComida.getText().toString());
        TextView nombrePlato = (TextView) findViewById(R.id.nombrePlato);
        String nombre = nombrePlato.getText().toString();
        Pedido pedido = new Pedido(4,nombre, numero);
       // AzureServiceAdapter.getInstance().insertarPedido(pedido);

    }

    private void setInterface(){
        Plato plato = GlobalSettings.platoActual;
        TextView nombre = (TextView) findViewById(R.id.nombrePlato);
        nombre.setText(plato.getNombre());
        TextView precio = (TextView) findViewById(R.id.precio);
        precio.setText(plato.getPrecio());
        TextView descripcion = (TextView) findViewById(R.id.descripcionPlato);
        descripcion.setText(plato.getDescripcion());
    }

}
