package modelo;

import modelo.accesoFicheros.AccesoAFicheros;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class BDCiudades implements IBBDD,Serializable, Iterable<Ciudad>{
    private ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();

    @Override
    public void insert(Ciudad ciudad) throws ExistCiudadException {
        if (existe(ciudad.getCp()))
            throw new ExistCiudadException("Ya existe el CP: " + ciudad.getCp());
        ciudades.add(ciudad);
    }

    @Override
    public Ciudad delete(String cp)  throws ExistCiudadException {
        Ciudad ciudad = buscar(cp);
        ciudades.remove(ciudad);
        return ciudad;
    }

    @Override
    public Ciudad buscar(String cp) throws ExistCiudadException {
        for (Ciudad ciudad : ciudades){
            if (ciudad.getCp().equals(cp))
                return ciudad;
        }
        throw new ExistCiudadException("No existe el CP: " + cp);
    }

    @Override
    public boolean existe(String cp) {
        for (Ciudad ciudad : ciudades){
            if (ciudad.getCp().equals(cp))
                return true;
        }
        return false;
    }


    @Override
    public int size() {
        return ciudades.size();
    }

    @Override
    public boolean estaVacia() {
        return ciudades.isEmpty();
    }

    @Override
    public void guardarBD() throws IOException {
        new AccesoAFicheros().guardar(this);
    }

    @Override
    public IBBDD cargarBD() throws IOException, ClassNotFoundException {
        return new AccesoAFicheros().leer();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<Ciudad> iterator() {
        return new IteratorDeCiudad(ciudades);
    }
}
