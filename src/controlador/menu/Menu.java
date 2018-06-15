package controlador.menu;

import controlador.Controlador;
import modelo.IBBDD;
import vista.IVista;

import java.util.ArrayList;

import static controlador.menu.OpcionFactory.listaDeOpcionesStr;

public class Menu extends Controlador {
    private ArrayList<Opcion> opciones = new ArrayList<Opcion>();
    private static int SALIR = -1;
    private static int ERROR = -2;

    public Menu(IBBDD bbdd, IVista vista) {
        super(bbdd,vista);
    }

    public void iniciarMenu() {
        int opcion;
        crearMenu();
        do {
            mostrarMenu();
            opcion = capturarOpcion();
            if (opcion >= 0 && opcion < opciones.size())
                opciones.get(opcion).ejecutar();
            else if (opcion == ERROR)
                vista.escribir("Debe introducir un número");
            else if (opcion != SALIR)
                vista.escribir("Debe introducir un valor válido de opción");
        }while (opcion != SALIR);
    }

    private void crearMenu() {
        for (String opcionStr : listaDeOpcionesStr) {
            Opcion opcion = new OpcionFactory<Opcion,String>(this).getProduct(opcionStr);
            opciones.add(opcion);
        }
    }

    private void mostrarMenu() {
        vista.escribir("Elija opción. <0> para salir");
        for (int i = 0; i < opciones.size(); i++) {
            vista.escribir((i + 1) + ".- " + opciones.get(i).getEtiqueta());
        }
    }

    private int capturarOpcion() {
        try {
            return Integer.parseInt(vista.leer("")) - 1;
        } catch (NumberFormatException e) {
            return ERROR;
        }
    }

}
