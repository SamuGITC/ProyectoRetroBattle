public class Animaciones {
    public static void mostrarCuentaRegresiva() {
        System.out.println("3... 2... 1...");
    }

    public static void esperar(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
