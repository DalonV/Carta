package tfg.davidparamo.carta;

/**
 * Created by david on 12/05/2017.
 */


import android.content.Context;
import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

public class AzureServiceAdapter {
    private String mMobileBackendUrl = "http://cartamoviltfg.azurewebsites.net";
    private Context mContext;
    private MobileServiceClient mClient;
    private static AzureServiceAdapter mInstance = null;

    private AzureServiceAdapter(Context context) {
            mContext = context;
        try {
            mClient = new MobileServiceClient(mMobileBackendUrl, mContext);
        }
        catch (Exception e){ }
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

    MobileServiceTable<Pedido> mToDoTable = mClient.getTable("Pedidos", Pedido.class);

    public void insertarPedido (Pedido pedido){
        mToDoTable.insert(pedido);
    }
}