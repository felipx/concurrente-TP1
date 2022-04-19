public class Main {
    public  static final int bufferSize = 100;
    public static final int tiempoDeCreacion = 0;
    public static final int tiempoDeRevision = 0;
    public static final int tiempoDeConsumision = 0;


    public static void main(String[] s){
        Buffer bufferInicial = new Buffer(bufferSize);
        Buffer bufferValidado = new Buffer(bufferSize);

        for(int i=0; i < Creador.N_CREADORES; i++){
            Creador creador = new Creador(bufferInicial, tiempoDeCreacion);
            Thread thread = new Thread(creador);
            thread.start();
        }

        for(int i=0; i < Revisor.N_REVISORES; i++){
            Revisor revisor = new Revisor(bufferInicial, bufferValidado, tiempoDeRevision);
            Thread thread = new Thread(revisor);
            thread.start();
        }
    }
}
