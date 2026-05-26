import java.util.Random;

public class CPU extends Jugador {
    private static final String[] OPCIONES = {"piedra", "papel", "tijera"};
    private final Random random;

    public CPU(String nombre, int vidas) {
        super(nombre, vidas);
        this.random = new Random();
    }

    public void seleccionarMovimiento() {
        int indice = random.nextInt(OPCIONES.length);
        setEleccionActual(OPCIONES[indice]);
    }
}