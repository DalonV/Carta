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
    private String mCreatedAt;
    public String getCreatedAt() { return mCreatedAt; }
    protected void setCreatedAt(String createdAt) { mCreatedAt = createdAt; }

    @com.google.gson.annotations.SerializedName("updatedAt")
    private String mUpdatedAt;
    public String getUpdatedAt() { return mUpdatedAt; }
    protected void setUpdatedAt(String updatedAt) { mUpdatedAt = updatedAt; }

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

    @com.google.gson.annotations.SerializedName("precio")
    private String precio;
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @com.google.gson.annotations.SerializedName("cantidad")
    private int cantidadPlato;
    public int getCantidadPlato() {
        return cantidadPlato;
    }
    public void setCantidadPlato(int cantidadPlato) {
        this.cantidadPlato = cantidadPlato;
    }

    @com.google.gson.annotations.SerializedName("preparado")
    private boolean preparado;
    public boolean getPreparado() {
        return preparado;
    }
    public void setPreparado(boolean preparado) {
        this.preparado = preparado;
    }

    public Pedido(int num, String nombre, int cantidad, String precio) {
        this.setCantidadPlato(cantidad);
        this.setPlato(nombre);
        this.setNumMesa(num);
        this.setPrecio(precio);
        preparado = false;
    }
}
