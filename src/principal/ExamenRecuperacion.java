package principal;

import controlador.Controlador;
import modelo.IBBDD;
import modelo.BDCiudades;
import vista.IVista;
import vista.Vista;

public class ExamenRecuperacion {
    public static void main(String args[]) {
        IVista vista = new Vista();
        IBBDD bbdd = new BDCiudades();

        Controlador controlador = new Controlador(bbdd,vista);
        controlador.iniciar();
    }
}
