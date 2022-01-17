import java.util.Map;

public class PoliticaMoltiplicativa extends ListinoAbs{

    /**
    * Costruttore.
    * @param giocattolo2prezzo mappa giocattolo e prezzo.
    */
    public PoliticaMoltiplicativa(Map<Giocattolo, Integer> giocattolo2prezzo){
        super(giocattolo2prezzo);
    }

    /**
    * Costo di un giocattolo per la quantità specificata.
    * @param g il giocattolo.
    * @param numero il numero di giocattoli.
    * @throws IllegalArgumentException se il numero è negativo o uguale a zero.
    */
    @Override
    public float costo(Giocattolo g, int numero){
        if (numero <= 0){
            throw new IllegalArgumentException("Il numero dei giocattoli da aggiungere non può essere negativo o uguale a zero");
        }

        Integer prezzo = giocattolo2prezzo.get(g);
        if (prezzo == null){
            throw new IllegalArgumentException("Il giocattolo richiesto non esiste nel listino");
        }

        return (float) (numero*prezzo);
    }
}