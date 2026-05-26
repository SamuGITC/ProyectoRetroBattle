public class AsciiArt {
    public static void mostrarLogo() {
        System.out.println("=== RETRO BATTLE ===");
    }

    public static void mostrarMovimiento(String jugador, String movimiento) {
        System.out.printf("%s ha elegido %s%n", jugador, movimiento);
    }
}
