import java.util.concurrent.TimeUnit;

public class Revisor implements Runnable{
    public static int N_REVISORES;
    private Buffer bufferInicial;
    private Buffer bufferValidado;
    private Integer cantidadRevisados;
    private final int demora;

    public Revisor(Buffer bufferInicial, Buffer bufferValidado, int demora){
        this.bufferInicial = bufferInicial;
        this.bufferValidado = bufferValidado;
        this.cantidadRevisados = 0;
        this.demora = demora;
    }

    public void run(){
        while(Consumidor.getDatosconsumidos() < Consumidor.getMaximasConsumisiones()){
            revisar();
        }
    }

    public void revisar(){
        try {
            Dato dato = this.bufferInicial.obtenerDato();
            if(!dato.revisadoPor(this)){
                TimeUnit.SECONDS.sleep(this.demora);
                dato.addReviewer(this);
            }
            this.copiar(dato);
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void copiar(Dato dato){
        Dato copia;
        if(dato.getReviewersCount() == N_REVISORES){
            try {
                copia = dato.clone();
                this.bufferValidado.agregarDato(copia);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
