package tfg.davidparamo.carta;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.microsoft.windowsazure.mobileservices.MobileServiceList;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

public class PantallaCarga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AzureServiceAdapter.Initialize(this);
        new GetPlatos().execute();
    }

    private class GetPlatos extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params) {
            MobileServiceTable<Plato> mToDoTable = AzureServiceAdapter.getInstance().getClient().getTable("Platos", Plato.class);
            try {
                MobileServiceList<Plato>  platos = mToDoTable.execute().get();
                for(Plato plato: platos){
                    Log.d("QUE TIPO DE PLATO", plato.getTipoPlato());
                    switch (plato.getTipoPlato()) {

                        case "Primero": GlobalSettings.platosPrimero.add(plato); break;
                        case "Segundo": GlobalSettings.platosSegundo.add(plato); break;
                        case "Postre": GlobalSettings.platosPostre.add(plato); break;
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("Salta una excepcion ","en getPlatos");
            }
            Log.d("CONECTADO ", "CHACHI MI GENERAL");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            getApplicationContext().startActivity(intent);

            finish();

        }
    }
}
