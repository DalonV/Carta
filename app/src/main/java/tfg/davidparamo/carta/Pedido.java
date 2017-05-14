package tfg.davidparamo.carta;

import com.microsoft.windowsazure.mobileservices.table.DateTimeOffset;

/**
 * Created by david on 13/05/2017.
 */

public class Pedido {


    @com.google.gson.annotations.SerializedName("id")
    private String mId;
    public String getId() { return mId; }
    public final void setId(String id) { mId = id; }

    @com.google.gson.annotations.SerializedName("createdAt")
    private DateTimeOffset mCreatedAt;
    public DateTimeOffset getCreatedAt() { return mCreatedAt; }
    protected void setCreatedAt(DateTimeOffset createdAt) { mCreatedAt = createdAt; }

    @com.google.gson.annotations.SerializedName("updatedAt")
    private DateTimeOffset mUpdatedAt;
    public DateTimeOffset getUpdatedAt() { return mUpdatedAt; }
    protected void setUpdatedAt(DateTimeOffset updatedAt) { mUpdatedAt = updatedAt; }

    @com.google.gson.annotations.SerializedName("version")
    private String mVersion;
    public String getVersion() { return mVersion; }
    public final void setVersion(String version) { mVersion = version; }

    @com.google.gson.annotations.SerializedName("numMesa")
    private int numMesa;
    public int getNumMesa() {
        return numMesa;
    }
    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    @com.google.gson.annotations.SerializedName("plato")
    private String plato;
    public String getPlato() {
        return plato;
    }
    public void setPlato(String plato) {
        this.plato = plato;
    }

    @com.google.gson.annotations.SerializedName("cantidad")
    private int cantidadPlato;
    public int getCantidadPlato() {
        return cantidadPlato;
    }
    public void setCantidadPlato(int cantidadPlato) {
        this.cantidadPlato = cantidadPlato;
    }

    public Pedido(int num, String nombre, int cantidad ) {
        this.setCantidadPlato(cantidad);
        this.setPlato(nombre);
        this.setNumMesa(num);
    }
}
