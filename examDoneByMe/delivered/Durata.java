
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


//7295 secondi corrisponde alla stringa 2:01:35

    @Override
    public String toString() {
        return "11:11:11";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Durata))
            return false;

        final Durata tmp = (Durata) o;
        return tmp.durata == durata;
    }

}
