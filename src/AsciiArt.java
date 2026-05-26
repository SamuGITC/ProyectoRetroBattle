public class AsciiArt {
    public static void mostrarLogo() {
        System.out.println("======================================");
        System.out.println("      RETRO BATTLE - BATALLA 8-BIT      ");
        System.out.println("======================================");
        System.out.println();
    }

    public static void mostrarVidas(String jugador, int vidasJugador, int vidasCPU) {
        System.out.println("--------------------------------------");
        System.out.printf("Vidas: %s = %d   |   CPU = %d%n", jugador, vidasJugador, vidasCPU);
        System.out.println("--------------------------------------");
    }

    public static void mostrarMovimiento(String nombre, String movimiento) {
        System.out.printf("%n%s ha elegido %s.%n", nombre, movimiento);
        mostrarArteMovimiento(movimiento);
        System.out.println();
    }

    public static void mostrarResultado(String resultado) {
        System.out.println("====== RESULTADO ======");
        System.out.println(resultado);
        System.out.println("=======================\n");
    }

    public static void mostrarSeparador() {
        System.out.println("\n======================================\n");
    }

    private static void mostrarArteMovimiento(String movimiento) {
        switch (movimiento) {
            case "piedra" -> System.out.println("   _______\n  /      /,\n /      //\n(______(/\n");
            case "papel" -> System.out.println("  _______\n /      /\\\n/      /  \\\n\\_____/___/\n");
            case "tijera" -> System.out.println("   _    _\n  ( \\__/ )\n   \"  /  \n  /     \\\n(_/\\/\\_)");
            default -> System.out.println("Movimiento desconocido.");
        }
    }
}
