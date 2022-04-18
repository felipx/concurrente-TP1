import java.util.HashSet;

public class Dato {

    private final HashSet<Long> reviews;
    private int id;
    private boolean enUso;

    /**
     * Constructor sin parámetros
     *
     */
    public Dato(){
            reviews = new HashSet<>();
    }

    /**
     * Agrega un revisor al HashSet usando el ID del thread.
     * Verifica que no lo haya revisado antes, si no imprime un error
     *
     * @param thread El revisor a agregar
     */
    public void addReviewer(Thread thread){
        enUso = true;
        if(checkReviewer(thread)){
                reviews.add(thread.getId());
        }
        else{
            System.out.println(String.format("El hilo %d ya ha validado este dato", thread.getId()));
        }
        enUso = false;
    }

    /**
     * Devuelve la cantidad de revisores que han validado el dato
     *
     */
    public int getReviewersCount(){ return reviews.size(); }

    /**
     * Devuelve el id del dato
     *
     */
    public int getId(){ return id; }

    /**
     * Verifica que el validador no haya revisado el dato anteriormente
     *
     * @param thread El revisor del cual se quiere validar
     */
    public boolean checkReviewer(Thread thread){
            return reviews.contains(thread.getId());
        }
  

    /**
     * Realiza la copia de un dato
     *
     */
    public Object clone(){
            Dato dato = null;
            try {
                dato = (Dato) super.clone();
            } catch (CloneNotSupportedException e) {}

            return dato;
        }
    }
