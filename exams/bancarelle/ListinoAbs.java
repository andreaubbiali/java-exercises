import java.util.Map;
import java.util.HashMap;

public abstract class ListinoAbs implements ListinoInterface{

    public Map<Giocattolo, Integer> giocattolo2prezzo;

    /**
    * Costruttore.
    * @param giocattolo2prezzo mappa di giocattolo con il prezzo.
    * @param IllegalArgumentException se giocattolo2prezzo è null
    */
    public ListinoAbs(Map<Giocattolo, Integer> giocattolo2prezzo){
        if (giocattolo2prezzo == null){
            throw new IllegalArgumentException("giocattolo2prezzo null");
        }
        this.giocattolo2prezzo = new HashMap<>();
        this.giocattolo2prezzo = giocattolo2prezzo;
    }

    /**
    * Aggiunta di un elemento nel listino.
    * @param g il giocattolo da aggiungere.
    * @param prezzo il prezzo del giocattolo.
    * @throws ListinoException se l'elemento esiste già nel listino.
    */
    public void aggiungiElemento(Giocattolo g, Integer prezzo){
        // TODO

        // giocattolo2prezzo.put();
    }

    /**
    * Aggiornamento del costo del giocattolo nel listino.
    * @param g il giocattolo da aggiornare.
    * @param prezzo il nuovo prezzo del giocattolo
    * @throws ListinoException se l'elemento non esiste nel listino.
    */
    public void aggiornaElemento(Giocattolo g, Integer prezzo){
        // TODO

        // giocattolo2prezzo.put();
    }

}