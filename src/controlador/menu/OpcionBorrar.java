package controlador.menu;

public class OpcionBorrar extends Opcion {
    public OpcionBorrar(String borrarCiudad, Menu menu) {
        super(borrarCiudad,menu);
    }

    @Override
    public void ejecutar() {
        menu.borrar();
    }
}
