import java.util.Scanner;

public class Utilidades {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String pedirNombreJugador() {
        System.out.print("Ingresa tu nombre de guerrero: ");
        return SCANNER.nextLine().trim();
    }

    public static String pedirMovimiento() {
        String movimiento;
        do {
            System.out.print("Elige tu movimiento (piedra, papel, tijera): ");
            movimiento = SCANNER.nextLine().trim().toLowerCase();
            if (!esMovimientoValido(movimiento)) {
                System.out.println("Movimiento inválido. Intenta de nuevo.");
            }
        } while (!esMovimientoValido(movimiento));
        return movimiento;
    }

    public static boolean esMovimientoValido(String movimiento) {
        return movimiento.equals("piedra") || movimiento.equals("papel") || movimiento.equals("tijera");
    }

    public static boolean quiereJugarOtraVez() {
        System.out.print("¿Deseas jugar otra partida? (s/n): ");
        String respuesta = SCANNER.nextLine().trim().toLowerCase();
        return respuesta.startsWith("s");
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}