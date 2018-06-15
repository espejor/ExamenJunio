package controlador.menu;

public class OpcionFactory<T,K> implements SimpleFactory<T,K>{
    private final static String CARGAR_BD = "Cargar Base de Datos";
    private final static String GUARDAR_BD = "Guardar Base de Datos";
    private final static String CAPTURAR_DATOS = "Capturar Datos";
    private final static String BUSCAR_CIUDAD = "Buscar por CP";
    private final static String BORRAR_CIUDAD = "Borrar Ciudad";
    private final static String LISTAR_DATOS = "Listar Datos";
    Menu menu;


    public static String[] listaDeOpcionesStr = {CARGAR_BD,GUARDAR_BD,CAPTURAR_DATOS,BUSCAR_CIUDAD,BORRAR_CIUDAD,LISTAR_DATOS};

    public OpcionFactory(Menu menu) {
        this.menu = menu;
    }
    //
//    public static Opcion getOpcion(String opcion, Menu menu) {
//        if (opcion.equals(CARGAR_BD))
//            return new OpcionCargar(CARGAR_BD,menu);
//        if (opcion.equals(GUARDAR_BD))
//            return new OpcionGuardar(GUARDAR_BD,menu);
//        if (opcion.equals(CAPTURAR_DATOS))
//            return new OpcionCapturar(CAPTURAR_DATOS,menu);
//        if (opcion.equals(BUSCAR_CIUDAD))
//            return new OpcionBuscar(BUSCAR_CIUDAD,menu);
//        if (opcion.equals(BORRAR_CIUDAD))
//            return new OpcionBorrar(BORRAR_CIUDAD,menu);
//        if (opcion.equals(LISTAR_DATOS))
//            return new OpcionListar(LISTAR_DATOS,menu);
//        return null;
//    }

    @Override
    public T getProduct(K opcion) {
        if (opcion.equals(CARGAR_BD))
            return (T) new OpcionCargar(CARGAR_BD,menu);
        if (opcion.equals(GUARDAR_BD))
            return (T) new OpcionGuardar(GUARDAR_BD,menu);
        if (opcion.equals(CAPTURAR_DATOS))
            return (T) new OpcionCapturar(CAPTURAR_DATOS,menu);
        if (opcion.equals(BUSCAR_CIUDAD))
            return (T) new OpcionBuscar(BUSCAR_CIUDAD,menu);
        if (opcion.equals(BORRAR_CIUDAD))
            return (T) new OpcionBorrar(BORRAR_CIUDAD,menu);
        if (opcion.equals(LISTAR_DATOS))
            return (T) new OpcionListar(LISTAR_DATOS,menu);
        return null;
    }
}
