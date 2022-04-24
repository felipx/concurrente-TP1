

public class Consumidor implements Runnable {


    private static int datosconsumidos = 0;

    private int tiempo;

    private Buffer bufferValidado;

    private int cantidadConsumidos;

    private static final int MAXIMAS_CONSUMISIONES = 1000;


    /** Constructor con parametros  */
    public Consumidor( int tiempo, Buffer bufferValidado) {

        this.tiempo = tiempo;
        this.bufferValidado = bufferValidado;
        cantidadConsumidos =  0 ;

    }

    public synchronized void aumentarConsumisiones() {

        datosconsumidos++;

    }

    public static synchronized int getDatosconsumidos(){

        return datosconsumidos;

    }

    public static int getMaximasConsumisiones(){
        return MAXIMAS_CONSUMISIONES;
    }

    public void consumir() throws Exception {

          bufferValidado.BorrarDato(bufferValidado.obtenerDato().getId());
          cantidadConsumidos++;
          aumentarConsumisiones();
    }

    @Override
    public void run(){

        while(cantidadConsumidos< MAXIMAS_CONSUMISIONES) {
            try {
                consumir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
