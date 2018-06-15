package controlador.menu;

public interface SimpleFactory<T, K> {
    T getProduct(K clave);
}
