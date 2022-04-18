import java.util.HashMap;
import java.lang.Thread;

public class Creador{

    private Buffer bufferInicial;
    private ReentrantReadWriteLock Lock;
    private int cantidadCreados;
    private long demoraMs; //El tiempo que tarda en crear un dato

    /* Constructor */
    public Creador(Buffer bufferInicial, long demora){
        this.bufferInicial = bufferInicial;
        this.cantidadCreados = 0;
        this.demoraMs = demora;
    }

    /* Crea un nuevo dato (con su demora respectiva) y se lo entrega al buffer inicial */
    public void crear(void){
        Dato nuevoDato= new Dato();
        sleep(this.demoraMs);
        this.cantidadCreados++;
        this.bufferInicial.AgregarDato(nuevoDato);
    }

}