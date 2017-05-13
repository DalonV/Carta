package tfg.davidparamo.carta;

/**
 * Created by david on 13/05/2017.
 */

public class Pedido {
    private int numMesa;
    private String plato;
    private int cantidadPlato;

    public Pedido(int num, String nombre, int cantidad ) {
        numMesa = num;
        plato = nombre;
        cantidadPlato = cantidad;
    }

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

    public int getCantidadPlato() {
        return cantidadPlato;
    }

    public void setCantidadPlato(int cantidadPlato) {
        this.cantidadPlato = cantidadPlato;
    }
}
