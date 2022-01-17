import java.util.Map;
import java.util.HashMap;

public class Acquisto{

    private Giocattolo giocattolo;
    private int quantita;
    private int costoTotale;
    private Map<Bancarella, Integer> bancarelle; 

    /**
    * Costruttore.
    * @param g il giocattolo.
    * @param quantita la quantita.
    */
    public Acquisto(Giocattolo g, int quantita){
        this.giocattolo = g;
        this.quantita = quantita;
        this.bancarelle = new HashMap<>();
    }

    public void setBancarella(Bancarella b, int numero){
        bancarelle.put(b,numero);
    }

    public void addCosto(float costo){
        costoTotale += costo;
    }

    @Override
    public String toString(){
        String res = "Acquisto di: " + giocattolo + ", per un costo di: " + costoTotale + ", numero: " + quantita + " di cui:\n";

        for(Map.Entry<Bancarella, Integer> v : bancarelle.entrySet()){
            res += v.getValue() + "da " + v.getKey().proprietario; 
        }

        return res;
    }
}