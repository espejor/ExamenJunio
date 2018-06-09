package controlador.menu;

public class OpcionCargar extends Opcion {
    public OpcionCargar(String cargarBd, Menu menu) {
        super(cargarBd,menu);
    }

    @Override
    public void ejecutar() {
        menu.cargarBD();
    }
}
