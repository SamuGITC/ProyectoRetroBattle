import java.util.Random;

public class Juego {
    private static final int VIDAS_INICIALES = 3;

    public void iniciar() {
        Utilidades.limpiarPantalla();
        AsciiArt.mostrarLogo();
        System.out.println("Bienvenido a RetroBattle. ¡Que comience la batalla!");

        String nombre = Utilidades.pedirNombreJugador();
        if (nombre.isBlank()) {
            nombre = "Guerrero Retro";
        }

        boolean jugarOtraVez;
        do {
            Jugador jugador = new Jugador(nombre, VIDAS_INICIALES);
            CPU cpu = new CPU("CPU", VIDAS_INICIALES);
            jugarPartida(jugador, cpu);

            jugarOtraVez = Utilidades.quiereJugarOtraVez();
            if (jugarOtraVez) {
                AsciiArt.mostrarSeparador();
            }
        } while (jugarOtraVez);

        System.out.println("Gracias por jugar RetroBattle. Hasta la próxima!");
    }

    private void jugarPartida(Jugador jugador, CPU cpu) {
        Random random = new Random();

        while (jugador.estaVivo() && cpu.estaVivo()) {
            AsciiArt.mostrarVidas(jugador.getNombre(), jugador.getVidas(), cpu.getVidas());
            String movimientoJugador = Utilidades.pedirMovimiento();
            jugador.setEleccionActual(movimientoJugador);

            cpu.seleccionarMovimiento();
            String movimientoCPU = cpu.getEleccionActual();

            Animaciones.mostrarCuentaRegresiva();
            AsciiArt.mostrarMovimiento(jugador.getNombre(), movimientoJugador);
            AsciiArt.mostrarMovimiento(cpu.getNombre(), movimientoCPU);

            String resultado = determinarGanador(movimientoJugador, movimientoCPU, jugador, cpu);
            AsciiArt.mostrarResultado(resultado);
        }

        if (jugador.estaVivo()) {
            System.out.println("¡Victoria! Has derrotado a la CPU.");
        } else {
            System.out.println("Derrota... La CPU gana esta vez.");
        }
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
