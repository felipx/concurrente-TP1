import java.util.HashMap;
import java.lang.Thread;

public class Creador{

    private Buffer bufferInicial;
    private ReentrantReadWriteLock Lock;
    private int cantidadCreados;
    private long demoraMs; 

    /**
     * Constructor con parámetros
     * Inicializa las variables de instancia
     * @param bufferInicial Buffer donde enviar los datos creados.
     * @param demora Cuanto tiempo demora en crear un dato
     */
    public Creador(Buffer bufferInicial, long demora){
        this.bufferInicial = bufferInicial;
        this.cantidadCreados = 0;
        this.demoraMs = demora;
    }

    /**
     * Crea un nuevo dato (demorando el tiempo correspondiente)
     * y se lo entrega al buffer. 
     */
    public void crear(){
        Dato nuevoDato= new Dato();
        sleep(this.demoraMs);
        this.cantidadCreados++;
        this.bufferInicial.AgregarDato(nuevoDato);
    }

}