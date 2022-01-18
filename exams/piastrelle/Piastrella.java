
/**
* Classe immutabile astratta che rappresenta una piastrella
*/
public abstract class Piastrella implements PiastrellaInterface{

    private int costo;

    /**
    * RI: la superficie deve essere una grandezza maggiore di zero.
    *       il costo deve essere una grandezza maggiore di zero.
    */

    /**
    * Costruttore di una piastrella.
    * @param costo il costo di una piastrella.
    * @throws IllegalArgumentException se il costo è <= 0.
    */
    public Piastrella(int costo){
        if(costo <= 0){
            throw new IllegalArgumentException("Il costo deve essere >= 0");
        }

        this.costo = costo;
    }

    /**
    * Ritorna la superficie totale in base al numero di piastrelle.
    * @param numero il numero di piastrelle.
    * @throws IllegalArgumentException se numero è <= 0.
    * @return la superficie totale.
    */
    public int getSuperficieTot(int numero){
        if (numero <= 0){
            throw new IllegalArgumentException("Numero non può essere <= 0");
        }
        return calcSuperficie() * numero;
    }

    /**
    * Ritorna costo.
    * @return il valore di costo.
    */
    public int getCosto(){
        return this.costo;
    }
}