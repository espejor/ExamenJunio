package controlador.menu;

public class OpcionBuscar extends Opcion {
    public OpcionBuscar(String buscarCiudad, Menu menu) {
        super(buscarCiudad,menu);
    }

    @Override
    public void ejecutar() {
        menu.buscar();
    }
}
