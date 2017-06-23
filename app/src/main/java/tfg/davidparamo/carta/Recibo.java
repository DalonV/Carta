package tfg.davidparamo.carta;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Recibo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo);
        ReciboAdapter mAdapter;
        mAdapter = new ReciboAdapter(Recibo.this);
        ListView listViewToDo = (ListView) findViewById(R.id.listaRecibo);
        listViewToDo.setAdapter(mAdapter);

        TextView precioTotal = (TextView) findViewById(R.id.precioTotal);
        precioTotal.setText("TOTAL: " + Float.toString(GlobalSettings.reciboTotal) + " €");
    }
}
