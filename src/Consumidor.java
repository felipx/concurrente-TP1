

public class Consumidor implements Runnable {


    private static int datosconsumidos = 0;

    private int tiempo;

    private Buffer bufferValidado;

    private int cantidadConsumidos;

    private final int maximasConsumisiones = 1000;


    /** Constructor con parametros  */
    public Consumidor( int tiempo, Buffer bufferValidado) {

        this.tiempo = tiempo;
        this.bufferValidado = bufferValidado;
        cantidadConsumidos =  0 ;

    }

    public synchronized void aumentarConsumisiones() {

        datosconsumidos++;

    }

    public synchronized int getDatosconsumidos(){

        return datosconsumidos;

    }

    public void consumir() throws Exception {

          bufferValidado.BorrarDato(bufferValidado.obtenerDato().getId());
          cantidadConsumidos++;
          aumentarConsumisiones();
    }

    @Override
    public void run(){

        while(cantidadConsumidos<maximasConsumisiones) {
            try {
                consumir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
