import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.lang.Thread;

public class Creador{

    private Buffer bufferInicial;
    private ReentrantReadWriteLock Lock;
    private int cantidadCreados;
    private long demoraMs; //El tiempo que tarda en crear un dato

    public Creador(Buffer bufferInicial, long demora){
        this.bufferInicial = bufferInicial;
        this.cantidadCreados = 0;
        this.demoraMs = demora;
    }

    public crear(void){
        Dato nuevoDato= new Dato();
        sleep(demoraMs);
        this.cantidadCreados++;
        this.bufferInicial.AgregarDato(nuevoDato);
    }

}