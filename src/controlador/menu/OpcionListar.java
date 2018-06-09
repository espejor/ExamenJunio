package controlador.menu;

public class OpcionListar extends Opcion {
    public OpcionListar(String listarDatos,Menu menu) {
        super(listarDatos,menu);
    }

    @Override
    public void ejecutar() {
        menu.listarBD();
    }
}
