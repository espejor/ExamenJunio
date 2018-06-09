package vista;

import java.io.PrintStream;
import java.util.Scanner;

public class Vista implements IVista {
    private PrintStream salida = System.out;
    private Scanner entrada = new Scanner(System.in);


    @Override
    public String leer(String etiqueta) {
        escribir(etiqueta);
        return entrada.nextLine();
    }

    @Override
    public void escribir(String texto) {
        salida.println(texto);
    }

}
