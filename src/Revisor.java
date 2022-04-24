import java.util.concurrent.TimeUnit;

public class Revisor implements Runnable{
    private int N_REVISORES;
    private Buffer bufferInicial;
    private Buffer bufferValidado;
    private Integer cantidadRevisados;
    private final int demora;

    public Revisor(Buffer bufferInicial, Buffer bufferValidado, int demora, int N_REVISORES){
        this.bufferInicial = bufferInicial;
        this.bufferValidado = bufferValidado;
        this.cantidadRevisados = 0;
        this.demora = demora;
        this.N_REVISORES = N_REVISORES;
    }

    public void run(){
        System.out.printf("inicio revisor\n");
        while(Consumidor.getDatosconsumidos() < Consumidor.getMaximasConsumisiones()){
            revisar();
            System.out.printf("revisando\n");
        }
    }

    public void revisar(){
        try {
            Dato dato = this.bufferInicial.obtenerDato();
            if (dato == null) {
                System.out.printf("revisor dato null\n");
                return;
            }
            System.out.printf("revisor dato no null\n");
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
        if(dato.getReviewersCount() == this.N_REVISORES){
            try {
                copia = dato.clone();
                this.bufferValidado.agregarDato(copia);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setCantidad(int num){
        N_REVISORES = num;
    }


}
