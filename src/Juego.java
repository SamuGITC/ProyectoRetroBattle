import java.util.Random;
import java.util.Scanner;

public class Juego {
    private static final int VIDAS_INICIALES = 3;
    private static final String[] OPCIONES = {"piedra", "papel", "tijera"};

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        AsciiArt.mostrarLogo();
        System.out.println("Bienvenido a RetroBattle. ¡Que comience la batalla!");
        System.out.print("Ingresa tu nombre de guerrero: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            nombre = "Guerrero Retro";
        }

        boolean jugarOtraVez;
        do {
            Jugador jugador = new Jugador(nombre, VIDAS_INICIALES);
            CPU cpu = new CPU("CPU", VIDAS_INICIALES);
            jugarPartida(scanner, jugador, cpu);

            System.out.print("¿Deseas jugar otra partida? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            jugarOtraVez = respuesta.startsWith("s");
            if (jugarOtraVez) {
                AsciiArt.mostrarSeparador();
            }
        } while (jugarOtraVez);

        System.out.println("Gracias por jugar RetroBattle. Hasta la próxima!");
        scanner.close();
    }

    private void jugarPartida(Scanner scanner, Jugador jugador, CPU cpu) {
        Random random = new Random();

        while (jugador.getVidas() > 0 && cpu.getVidas() > 0) {
            AsciiArt.mostrarVidas(jugador.getNombre(), jugador.getVidas(), cpu.getVidas());
            String movimientoJugador = pedirMovimientoValido(scanner);
            String movimientoCPU = OPCIONES[random.nextInt(OPCIONES.length)];

            AsciiArt.mostrarMovimiento(jugador.getNombre(), movimientoJugador);
            AsciiArt.mostrarMovimiento(cpu.getNombre(), movimientoCPU);

            String resultado = determinarGanador(movimientoJugador, movimientoCPU, jugador, cpu);
            AsciiArt.mostrarResultado(resultado);
        }

        if (jugador.getVidas() > 0) {
            System.out.println("¡Victoria! Has derrotado a la CPU.");
        } else {
            System.out.println("Derrota... La CPU gana esta vez.");
        }
    }

    private String pedirMovimientoValido(Scanner scanner) {
        String movimiento;
        do {
            System.out.print("Elige tu movimiento (piedra, papel, tijera): ");
            movimiento = scanner.nextLine().trim().toLowerCase();
            if (!esMovimientoValido(movimiento)) {
                System.out.println("Movimiento inválido. Intenta de nuevo.");
            }
        } while (!esMovimientoValido(movimiento));
        return movimiento;
    }

    private boolean esMovimientoValido(String movimiento) {
        for (String opcion : OPCIONES) {
            if (opcion.equals(movimiento)) {
                return true;
            }
        }
        return false;
    }

    private String determinarGanador(String movimientoJugador, String movimientoCPU, Jugador jugador, CPU cpu) {
        if (movimientoJugador.equals(movimientoCPU)) {
            return "Empate. Ninguno pierde vida.";
        }

        boolean jugadorGana = (movimientoJugador.equals("piedra") && movimientoCPU.equals("tijera"))
                || (movimientoJugador.equals("papel") && movimientoCPU.equals("piedra"))
                || (movimientoJugador.equals("tijera") && movimientoCPU.equals("papel"));

        if (jugadorGana) {
            cpu.perderVida();
            return String.format("%s gana la ronda. CPU pierde una vida.", movimientoJugador);
        }

        jugador.perderVida();
        return String.format("CPU gana la ronda. %s pierde una vida.", movimientoJugador);
    }
}
