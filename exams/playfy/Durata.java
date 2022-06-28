import java.util.Objects;

public class Durata {

    // durata immutabile specificata in secondi
    public final int durata;
    
    /**
     * Rappresentazione di una durata. Una durata non può mai essere negativa ma può essere = 0.
     */

    /**
     * Costruttore tramite seondi
     * @param seconds secondi della durata
     * @throws IllegalArgumentException se i secondi sono negativi
     */
    public Durata(final int seconds){
        if (seconds < 0){
            throw new IllegalArgumentException();
        }
        this.durata = seconds;
    }

    /**
     * Costruttore di una durata da una stringa di tipo hh:mm:ss
     * @param str la stringa dalla quale derivare i secondi
     * @throws IllegalArgumentException se la stringa non è ben formattata o se i secondi derivanti sono negativi
     */
    // public Durata(String str){

    // }

    /**
     * Somma tra durate
     * @param d2 durata da aggiungere
     * @return la nuova durata data dalla somma delle due durate
     * @throws NullPointerException se d1 o d2 sono nulle
     */
    public Durata addDurata(final Durata d2){
        Objects.requireNonNull(d2);

        return new Durata(this.durata + d2.durata);
    }

    /**
     * Sottrazione tra durate
     * @param d2 durata da sottrarre
     * @return la nuova durata data dalla sottrazione delle due durate
     * @throws NullPointerException d2 è nulle
     */
    public Durata removeDurata(final Durata d2){
        Objects.requireNonNull(d2);
        
        return new Durata(this.durata - d2.durata);
    }

}
