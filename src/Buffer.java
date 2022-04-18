import java.util.HashMap;

public class Buffer {

    private final int LimiteDatos;
    private HashMap<Integer, Dato> Datos;

    /**
     * Constructor con parámetros
     * Inicializa las variables de instancia
     * @param LimiteDatos Cantidad máxima de datos.
     */
    public Buffer(int LimiteDatos) {
        this.LimiteDatos = LimiteDatos;
        this.Datos = new HashMap<Integer, Dato>();
    }

    /**
     * Agrega un dato al Buffer.
     * No se puede agregar un dato si el total de datos es mayor
     * o igual a LimiteDatos
     * @param dato El dato a agregar en el Buffer.
     */
    public void AgregarDato(Dato dato) {
        if (Datos.size() >= LimiteDatos)
            return;
        Datos.put(dato.getId(), dato);
    }

    /**
     * Obtiene un dato del Buffer, según su id.
     * Si no hay dato con el id indicado, devuelve null.
     * @param id El id del dato a obtener del Buffer.
     */
    public Dato ObtenerDato(int id) {
        if (Datos.isEmpty() || !Datos.containsKey(id))
            return null;
        for (int key : Datos.keySet()) {
            if (Datos.get(key).)
        }
        return Datos.get(id);
    }

    /**
     * Elimina un dato del Buffer.
     * @param id El id del dato a eliminar del Buffer.
     */
    public void BorrarDato(int id) {
        if (!Datos.containsKey(id))
            return;
        Datos.remove(id);
    }

}
