import java.util.Objects;

abstract class BoolVect implements LogicOperator{

    // la massima dimensione che boolVect può raggiungere. La taglia deve essere > 0
    final int taglia;

    /**
     * RI: un BoolVect è un classe astratta che rappresenta un vettore di boolean di grandezza > 0.
     */

    /**
     * Costruttore
     * @param taglia la taglia massima
     * @throws IllegalArgumentException se la taglia <= 0
     */
    BoolVect(final int taglia) throws IllegalArgumentException{
        if (taglia <= 0){
            throw new IllegalArgumentException();
        }
        this.taglia = taglia;
    }

    /**
     * Costruttore
     * @param taglia la taglia massima
     * @param str stringa dal quale creare il boolVector
     * @throws IllegalArgumentException se la taglia <= 0 oppure se la stringa è vuota
     */
    BoolVect(final int taglia, final String str)  throws IllegalArgumentException{
        if (str == ""){
            throw new IllegalArgumentException();
        }
        if (taglia <= 0){
            throw new IllegalArgumentException();
        }
        this.taglia = taglia;

    }

    /**
     * metodo astratto che ritorna la dimensione del boolVect
     * @return la dimensione del boolVector = (n+1) se esiste un valore uguale a true (n valore della sua posizione), 0 altrimenti.
     */
    abstract public int dimensione();


    /**
     * modifica del valore di verità in posizione pos
     * @param pos la posizione del valore di verità da modificare
     * @throws IndexOutOfBoundException se pos > della taglia
     */
    abstract void modificaValore(final int pos, final boolean valore) throws IndexOutOfBoundsException;

    /**
     * Ritorna il valore di this in una specifica posizione
     * @param pos la posizione del valore richiesto
     * @return il valore di this alla posizione richiesta se pos < taglia, false altrimenti
     * @throws IndexOutOfBoundException se pos > della taglia
     */
    abstract boolean getValore(final int pos)throws IndexOutOfBoundsException;

    @Override
    public String toString(){
        return "a";
    }
}
