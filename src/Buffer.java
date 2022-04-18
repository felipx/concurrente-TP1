import java.util.HashMap;

public class Buffer {

    private final int LimiteDatos;
    private HashMap<Integer, Dato> Datos;
    static int rechazados = 0;

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
     * Le asigna un ID a un dato y lo agrega al Buffer.
     * No se puede agregar un dato si el total de datos es mayor
     * o igual a LimiteDatos.
     * @param dato El dato a agregar en el Buffer.
     */
    public void AgregarDato(Dato dato) {
        if (Datos.size() >= LimiteDatos){
            this.rechazados++;
            return;
        }
        Datos.put(dato.hashCode(), dato);
    }

    /**
     * Obtiene un dato del Buffer.
     * Si no hay datos o si están en uso, devuelve null.
     */
    public Dato ObtenerDato() {
        if (Datos.isEmpty())
            return null;
        for (int key : Datos.keySet()) {
            if (Datos.get(key).isEnUso() || Datos.get(key).isValidado())
                continue;
            return Datos.get(key);
        }
        return null;
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
