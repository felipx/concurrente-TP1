import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Consumidor implements Runnable {




    private int tiempo;

    private Buffer  bufferinciar;

    private ReentrantReadWriteLock lockinicial;

    private Buffer bufferValidado;

    private ReentrantReadWriteLock lockvalidado;

    private Integer cantidadConsumidos;

    public Consumidor(){}

    public void consumir(){}

    @Override
    public void run(){}


}
