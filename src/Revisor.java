import java.util.concurrent.TimeUnit;

public class Revisor implements Runnable{
    public static final int N_REVISORES = 2;
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
            this.copiar((Dato) dato.clone());
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void copiar(Dato dato){
        if(dato.getReviewersCount() == N_REVISORES){
            try {
                this.bufferValidado.agregarDato(dato);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
