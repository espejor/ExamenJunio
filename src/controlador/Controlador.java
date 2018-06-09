package controlador;

import controlador.menu.Menu;
import modelo.IBBDD;
import modelo.BDCiudades;
import modelo.Ciudad;
import modelo.ExistCiudadException;
import vista.IVista;

import java.io.IOException;
import java.util.Iterator;

public class Controlador implements IControlador {
    private IBBDD bbdd;
    protected IVista vista;

    public Controlador(IBBDD bbdd, IVista vista) {
        this.bbdd = bbdd;
        this.vista = vista;
    }


    public void iniciar() {
        new Menu(bbdd,vista).iniciarMenu();
    }

    public void listarBD(){
        if (!bbdd.estaVacia()) {
            vista.escribir("Datos en memoria:");
            Iterator<Ciudad> it = ((BDCiudades) bbdd).iterator();
            while (it.hasNext()) {
                Ciudad ciudad = it.next();
                vista.escribir(ciudad.toString());
            }
        }else{
            vista.escribir("No hay datos");
        }
    }

    @Override
    public void guardarBD() {
        try {
            bbdd.guardarBD();
            vista.escribir("Datos guardados");
        } catch (IOException e) {
            vista.escribir(e.getMessage());
        }
    }

    @Override
    public void cargarBD() {
        String opcion = "";
        if (!bbdd.estaVacia()) {
            vista.escribir("Si carga la BD desde el fichero machacará los datos que tiene cargados en memoria\n" +
                    "Continuar -> 1 --- Cancelar -> 0\n");
            opcion = vista.leer("");
        }
        if (!opcion.equals("0")) {
            try {
                bbdd = bbdd.cargarBD();
                listarBD();
            } catch (IOException e) {
                vista.escribir(e.getMessage());
            } catch (ClassNotFoundException e) {
                vista.escribir(e.getMessage());
            }
        }
    }

    @Override
    public void buscar() {
        String cp = leerCp();
        try {
            vista.escribir("Encontrado: " + bbdd.buscar(cp));
        } catch (ExistCiudadException e) {
            vista.escribir(e.getMessage());
        }
    }

    @Override
    public void borrar() {
        String cp = leerCp();
        try {
            vista.escribir("Se ha borrado: " + bbdd.delete(cp));
        } catch (ExistCiudadException e) {
            vista.escribir(e.getMessage());
        }
    }

    @Override
    public void capturarDatos(){
        vista.escribir("Toma de Datos");
        vista.escribir("=============");
        String ciudad = vista.leer("Introduzca la Ciudad:");
        String cp = leerCp();
        if (!cp.equals("00000")) {
            try {
                bbdd.insert(new Ciudad(cp, ciudad));
            } catch (ExistCiudadException e) {
                vista.escribir(e.getMessage());
            }
        }
    }

    private String leerCp(){
        String cp;
        try {
            cp = vista.leer("Introduzca el CP:");
            if (cp.length() != 5 || !isNumeric(cp))
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            vista.escribir("El CP es erróneo");
            cp = "00000";
        }
        return cp;
    }

    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

}
