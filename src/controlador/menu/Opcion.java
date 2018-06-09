package controlador.menu;

public abstract class Opcion {
    protected Menu menu;
    private String etiqueta;

    public Opcion(String etiqueta,Menu menu) {
        this.etiqueta = etiqueta;
        this.menu = menu;
    }

    /**
     * Getter de etiqueta
     * @return etiqueta
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    public abstract void ejecutar();
}
