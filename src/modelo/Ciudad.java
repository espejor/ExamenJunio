package modelo;

import java.io.Serializable;

public class Ciudad implements Serializable{
    private String cp;
    private String nombre;

    public Ciudad(String cp, String nombre) {
        this.cp = cp;
        this.nombre = nombre;
    }

    public String getCp() {
        return cp;
    }



    @Override
    public String toString() {
        return nombre + "\t\t=>\t\t" + getCp();
    }
}
