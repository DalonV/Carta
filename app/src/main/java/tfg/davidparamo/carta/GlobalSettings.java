package tfg.davidparamo.carta;

import com.microsoft.windowsazure.mobileservices.MobileServiceList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by david on 01/06/2017.
 */

public class GlobalSettings {
    public static float reciboTotal = 0.0f;
    public static int numMesa = 3;
    public static MobileServiceList<Plato> platos;
    public static ArrayList<Plato> platosPrimero = new ArrayList<>();
    public static ArrayList<Plato> platosSegundo = new ArrayList<>();
    public static ArrayList<Plato> platosPostre = new ArrayList<>();

    public static ArrayList<Pedido> pedidoActual = new ArrayList<>();
    public static ArrayList<Pedido> recibo = new ArrayList<>();
    public static HashMap<String,Plato> platosDelPedido = new HashMap<>();
    public static Plato platoActual;
}
