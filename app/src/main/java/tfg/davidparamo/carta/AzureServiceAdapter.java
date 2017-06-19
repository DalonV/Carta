package tfg.davidparamo.carta;

/**
 * Created by david on 12/05/2017.
 */


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Debug;
import android.util.Log;
import android.widget.Toast;

import com.google.common.util.concurrent.ListenableFuture;
import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableQueryCallback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static java.security.AccessController.getContext;

public class AzureServiceAdapter {
    private String mMobileBackendUrl = "http://cartamovil.azurewebsites.net";
    private Context mContext;
    private MobileServiceClient mClient;
    private static AzureServiceAdapter mInstance = null;

    public AzureServiceAdapter(Context context) {
            mContext = context;
        try {
            mClient = new MobileServiceClient(mMobileBackendUrl, mContext);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void Initialize(Context context) {
            if (mInstance == null) {
            mInstance = new AzureServiceAdapter(context);
            }
    }

    public static AzureServiceAdapter getInstance() {
            if (mInstance == null) {
            throw new IllegalStateException("AzureServiceAdapter is not initialized");
            }
            return mInstance;
    }

    public MobileServiceClient getClient() {
            return mClient;
            }



    public void insertarPedido (List<Pedido> pedido){
        Log.d("Me quedo en","insertar pedido");
        new MyAsyncTask().execute(pedido);
    }

    private class MyAsyncTask extends AsyncTask<List<Pedido>,Void,Void>{

        @Override
        protected Void doInBackground(List<Pedido>... pedido) {
            Log.d("MIIIIIIIIIIIIIIIIIII", Boolean.toString(pedido == null));
            Log.d("longitud lista", pedido[0].size() + "");
            MobileServiceTable<Pedido> mToDoTable = mClient.getTable("Pedidos", Pedido.class);
            try {
                for(Pedido ped: pedido[0])
                    mToDoTable.insert(ped).get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("PEDIDO INSERTADO","PEDIDO INSERTADO");
            GlobalSettings.pedidoActual.clear();
            return null;
        }
    }

}