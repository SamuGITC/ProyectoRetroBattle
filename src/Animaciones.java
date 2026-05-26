public class Animaciones {
    public static void mostrarCuentaRegresiva() {
        System.out.print("Preparando batalla");
        for (int i = 3; i > 0; i--) {
            System.out.print(" " + i);
            esperar(400);
        }
        System.out.println(" ¡YA!");
    }

    public static void mostrarBarraCargando(String mensaje) {
        System.out.print(mensaje);
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            esperar(200);
        }
        System.out.println();
    }

    public static void esperar(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
