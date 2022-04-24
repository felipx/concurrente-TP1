import java.util.concurrent.TimeUnit;

public class Consumidor implements Runnable {


    private static int datosconsumidos = 0;

    private int demoraConsumidor;

    private Buffer bufferValidado;

    private Buffer bufferInicial;

    private int cantidadConsumidos;

    private static final int MAXIMAS_CONSUMISIONES = 5;


    /** Constructor con parametros  */
    public Consumidor(Buffer bufferValidado, Buffer bufferInicial,int demoraConsumidor) {

        this.demoraConsumidor = demoraConsumidor;
        this.bufferInicial = bufferInicial;
        this.bufferValidado = bufferValidado;
        cantidadConsumidos =  0 ;

    }

    public synchronized void aumentarConsumisiones() {
        datosconsumidos++;
        System.out.println("Consumidos: " + datosconsumidos);
    }

    public static synchronized int getDatosconsumidos(){
        return datosconsumidos;
    }

    public static int getMaximasConsumisiones(){
        return MAXIMAS_CONSUMISIONES;
    }

    public void consumir(){
        try {
            TimeUnit.SECONDS.sleep(this.demoraConsumidor);
            Dato dato = bufferValidado.obtenerDato();
            if (dato == null)
                return;
            int id = dato.getId();
            bufferValidado.BorrarDato(id);
            bufferInicial.BorrarDato(id);
            cantidadConsumidos++;
            aumentarConsumisiones();
        }catch (NullPointerException e) {

        }catch (Exception e){
            e.printStackTrace();
        }

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
