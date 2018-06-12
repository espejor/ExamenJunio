package modelo.accesoFicheros;

import modelo.IBBDD;


import java.io.*;

public class AccesoAFicheros {
    public void guardar(IBBDD bdCiudades) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/archivos/bd.dat"));
        oos.writeObject(bdCiudades);
        oos.close();
    }


    public IBBDD leer() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/archivos/bd.dat"));
        IBBDD ibbdd = (IBBDD) ois.readObject();
        ois.close();
        return ibbdd;
    }
}
