import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class Inventario implements InventarioInterface{

    private Map<Giocattolo, Integer> giocattoli;

    /**
    * Costruttore
    */
    public Inventario(){
        this.giocattoli = new HashMap<>();
    }

    /**
    * Ritorna il numero dei giocattoli g presenti nell'inventario
    * @param g il giocattolo richiesto.
    * @param IllegalArgumentException se g è null.
    */
    public int getGiocattolo(Giocattolo g){
        if (Objects.isNull(g)){
            throw new IllegalArgumentException("null giocattolo.");
        }

        Integer num = giocattoli.get(g);

        if (num == null){
            return 0;
        }

        return (int)num;
    }

    /**
    * Aggiungi un certo nuero di giocattoli all'inventario.
    * @param g il giocattolo da aggiungere.
    * @param numero numero dei giocattoli da aggiungere.
    * @throws IllegalArgumentException se il numero è negativo o uguale a zero.
    * @param IllegalArgumentException se g è null.
    */
    public void aggiungi(int numero, Giocattolo g){
        if (Objects.isNull(g)){
            throw new IllegalArgumentException("null giocattolo.");
        }
        if (numero <= 0){
            throw new IllegalArgumentException("Il numero dei giocattoli da aggiungere non può essere negativo o uguale a zero");
        }

        Integer num = giocattoli.get(g);
        if (num == null){
            giocattoli.put(g, numero);
        } else {
            giocattoli.put(g, (numero + (int)num));
        }
    }

    /**
    * Rimuovi un certo numero di giocattoli dall'inventario.
    * @param g il giocattolo da eliminare.
    * @param numero numero dei giocattoli da rimuovere dall'inventario.
    * @throws IllegalArgumentException se il numero è negativo o uguale a zero.
    * @throws IllegalArgumentException se il numero di giocattoli da rimuovere eccede il numero dei giocattoli nell'inventario.
    * @param IllegalArgumentException se g è null.
    */
    public void rimuoviGiocattoli(Giocattolo g, int numero){
        if (Objects.isNull(g)){
            throw new IllegalArgumentException("null giocattolo.");
        }
        if (numero <= 0){
            throw new IllegalArgumentException("Il numero dei giocattoli da aggiungere non può essere negativo o uguale a zero");
        }

        Integer num = giocattoli.get(g);
        if (num == null || (int)num <= 0){
            throw new IllegalArgumentException("Impossibile rimuovere giocattolo. Il numero numero di giocattoli da rimuovere eccede il numero dei giocattoli nell'inventario");
        }

        giocattoli.put(g, ((int)num - numero));
    }
}