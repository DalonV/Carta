package tfg.davidparamo.carta;

/**
 * Created by david on 13/05/2017.
 */

public class Pedido {
    private int numMesa;
    private String plato;
    private Boolean cantidadPlato;

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public Boolean getCantidadPlato() {
        return cantidadPlato;
    }

    public void setCantidadPlato(Boolean cantidadPlato) {
        this.cantidadPlato = cantidadPlato;
    }
}
