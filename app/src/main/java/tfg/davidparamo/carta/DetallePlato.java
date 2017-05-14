package tfg.davidparamo.carta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


public class DetallePlato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_plato);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        TextView cantidadComida = (TextView) findViewById(R.id.cantidadPlato);
        int numero = Integer.parseInt(cantidadComida.getText().toString());
        TextView nombrePlato = (TextView) findViewById(R.id.nombrePlato);
        String nombre = nombrePlato.getText().toString();
        Pedido pedido = new Pedido(4,nombre, numero);
        AzureServiceAdapter.getInstance().insertarPedido(pedido);
    }
}
