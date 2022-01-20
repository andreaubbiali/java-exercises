import java.time.LocalTime;
import java.util.Objects;

/**
 * Una durata è una classe mutabile che rappresenta una durata di un brano.
 */
public class Durata {

    public int durata;

    /**
     * deve essere positiva.
    */

    /**
     * Costruttore di una durata.
     * @param durata la durata in numero.
     */
    public Durata(int durata) {
        this.durata = durata;

        assert repOK();
    }

    /**
     * Costruttore di una durata da una stringa.
     * @param durata la durata sottoforma di stringa.
     */
    public Durata(String durata){
        Objects.requireNonNull(durata);

        String[] splitted = durata.trim().split(":");
        
        int minuti = Integer.parseInt(splitted[0]);
        int secondi = Integer.parseInt(splitted[1]);

        this.durata = (minuti*60)+secondi;
    }

    /**
     * Aggiunta di una durata a this.
     * @param d la durata da aggiungere.
     */
    public void add(int d) {
        this.durata += d;

        assert repOK();
    }
    
    /**
     * Rimozione di una durata.
     * @param d la durata da rimuovere.
     */
    public void sub(int d) {
        this.durata -= d;

        assert repOK();
    }

    public boolean repOK() {
        return this.durata > 0;
    }

    @Override
    public String toString() {
        LocalTime time = LocalTime.ofSecondOfDay(this.durata);

        if (time.getHour() == 0){
            return time.getMinute() + ":" + time.getSecond();
        }
        return time.getHour() + ":" + time.getMinute() + ":" + time.getSecond();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Durata))
            return false;

        final Durata tmp = (Durata) o;
        return tmp.durata == durata;
    }

}
