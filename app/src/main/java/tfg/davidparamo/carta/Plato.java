package tfg.davidparamo.carta;

import com.microsoft.windowsazure.mobileservices.table.DateTimeOffset;

/**
 * Created by david on 27/05/2017.
 */

public class Plato {
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

    @com.google.gson.annotations.SerializedName("nombre")
    private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @com.google.gson.annotations.SerializedName("ingredientes")
    private String ingredientes;
    public String getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    @com.google.gson.annotations.SerializedName("descripcion")
    private String descripcion;
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
                this.descripcion = descripcion;
    }

    @com.google.gson.annotations.SerializedName("precio")
    private String precio;
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @com.google.gson.annotations.SerializedName("tipoPlato")
    private String tipoPlato;
    public String getTipoPlato() {
        return tipoPlato;
    }
    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
    }


    public Plato(String nombre, String ingre, String descri, String precio, String tipoPlato ) {
        this.setNombre(nombre);
        this.setIngredientes(ingre);
        this.setDescripcion(descri);
        this.setPrecio(precio);
        this.setTipoPlato(tipoPlato);
    }

    @Override
    public String toString() {
        return (nombre+" "+ingredientes+ " " +descripcion);
    }
}
