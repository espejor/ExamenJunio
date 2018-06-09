package modelo;

import java.io.IOException;

public interface IBBDD {
    void insert(Ciudad ciudad) throws ExistCiudadException;
    Ciudad delete(String cp)  throws ExistCiudadException;
    Ciudad buscar(String cp) throws ExistCiudadException;
    boolean existe(String cp);
    int size();
    boolean estaVacia();
    void guardarBD() throws IOException;
    IBBDD cargarBD() throws IOException, ClassNotFoundException;
}
