import java.util.Scanner;

public class Utilidades {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String pedirNombreJugador() {
        System.out.print("Nombre: ");
        return SCANNER.nextLine().trim();
    }
}
