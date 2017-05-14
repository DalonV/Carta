package tfg.davidparamo.carta;

/**
 * Created by david on 12/05/2017.
 */


import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.util.Log;
import android.widget.Toast;

import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.concurrent.ExecutionException;

import static java.security.AccessController.getContext;

public class AzureServiceAdapter {
    private String mMobileBackendUrl = "http://cartamoviltfg.azurewebsites.net";
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
            } else {
            throw new IllegalStateException("AzureServiceAdapter is already initialized");
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



    public Pedido insertarPedido (Pedido pedido){
        Log.d("MIIIIIIIIIIIIIIIIIII", Boolean.toString(pedido == null));
        MobileServiceTable<Pedido> mToDoTable = mClient.getTable("Pedidos", Pedido.class);

        Pedido actualizado = null;
        try {
            actualizado = mToDoTable.insert(pedido).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(mContext,"Me han pulsado",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(mContext, DetallePlato.class);
        mContext.startActivity(intent);
        return actualizado;
    }
}