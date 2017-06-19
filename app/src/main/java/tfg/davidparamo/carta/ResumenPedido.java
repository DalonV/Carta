package tfg.davidparamo.carta;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ResumenPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_pedido);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.confirmPedido);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Pedido realizado",Toast.LENGTH_LONG).show();
                AzureServiceAdapter.getInstance().insertarPedido(GlobalSettings.pedidoActual);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                getApplicationContext().startActivity(intent);
            }
        });
        PlatoAdapter mAdapter;
        mAdapter = new PlatoAdapter(ResumenPedido.this);
        ListView listViewToDo = (ListView) findViewById(R.id.listaResumen);
        listViewToDo.setAdapter(mAdapter);
    }
}
