package controlador.menu;

public class OpcionCapturar extends Opcion {
    public OpcionCapturar(String capturarDatos,Menu menu) {
        super(capturarDatos,menu);
    }

    @Override
    public void ejecutar() {
        menu.capturarDatos();
    }
}
