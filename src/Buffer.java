import java.util.HashSet;

public class Buffer {

    private final int LimiteDatos;
    private HashSet<Dato> Datos;

    public Buffer(int LimiteDatos) {
        this.LimiteDatos = LimiteDatos;
        this.Datos = new HashSet<Dato>();
    }

    public void AgregarDato(Dato dato) {
        if (Datos.size() >= LimiteDatos)
            return;
        
    }
}
