package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDeCiudad implements Iterator<Ciudad> {
    ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
    private int index = 0;

    public IteratorDeCiudad(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return index != ciudades.size();
    }

    /**
     * Returns the next element in the iteration.
     * @return the next element in the iteration
     */
    @Override
    public Ciudad next() {
        return ciudades.get(index++);
    }
}
