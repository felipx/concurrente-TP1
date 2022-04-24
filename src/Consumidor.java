import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Consumidor implements Runnable {




    private int tiempo;

    private Buffer bufferValidado;

    private ReentrantReadWriteLock lockvalidado;

    private int cantidadConsumidos;


    /** Constructor con parametros  */
    public Consumidor( int tiempo, Buffer bufferValidado, ReentrantReadWriteLock lockinicial,
                       ReentrantReadWriteLock lockvalidado ) {

        this.tiempo = tiempo;
        this.bufferValidado = bufferValidado;
        this.lockvalidado = lockvalidado;
        cantidadConsumidos =  0 ;

    }

    public void consumir() throws Exception {

          bufferValidado.BorrarDato(bufferValidado.obtenerDato().getId());
          cantidadConsumidos++;
    }

    @Override
    public void run(){

        while(cantidadConsumidos<500) {
            try {
                consumir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
