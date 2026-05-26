
public class Jugador {
    private final String nombre;
    private int vidas;
    private String eleccionActual;

    public Jugador(String nombre, int vidas) {
        this.nombre = nombre;
        this.vidas = vidas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void perderVida() {
        if (vidas > 0) {
            vidas--;
        }
    }

    public void curarVidas(int cantidad) {
        if (cantidad > 0) {
            vidas += cantidad;
        }
    }

    public boolean estaVivo() {
        return vidas > 0;
    }

    public String getEleccionActual() {
        return eleccionActual;
    }

    public void setEleccionActual(String eleccionActual) {
        this.eleccionActual = eleccionActual;
    }
}
