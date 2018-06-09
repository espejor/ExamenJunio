package controlador.menu;

public class OpcionGuardar extends Opcion {
    public OpcionGuardar(String guardarBd, Menu menu) {
        super(guardarBd,menu);
    }

    @Override
    public void ejecutar() {
        menu.guardarBD();
    }
}
